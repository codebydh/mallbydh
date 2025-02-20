package com.project.mallbydh.admin.order;

import com.project.mallbydh.common.constants.Constants;
import com.project.mallbydh.common.utils.AdminOrderSearchCriteria;
import com.project.mallbydh.common.utils.FileUtils;
import com.project.mallbydh.common.utils.PageMaker;
import com.project.mallbydh.order.OrderService;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

@Slf4j
@RequiredArgsConstructor
@RequestMapping("/admin/order/*")
@Controller
public class AdminOrderController {

    private final AdminOrderService adminOrderService;
    private final OrderService orderService;
    private final FileUtils fileUtils;

    @Value("${com.project.mallbydh.upload.path}")
    private String uploadPath;

    @GetMapping("/")
    public String adminOrderList(@ModelAttribute("cri")AdminOrderSearchCriteria cri, Model model) {

        cri.setPerPageNum(Constants.ADMIN_PRODUCT_LIST_COUNT);

        // 주문 상태 처리
        if (cri.getOrd_status() == null || cri.getOrd_status().isEmpty() || cri.getOrd_status().contains("all")) {
            cri.setOrd_status(Arrays.asList("입금대기", "결제완료", "배송준비", "배송중", "배송완료", "주문취소"));
        }

        // 결제 방법 처리
        if (cri.getPayment_method() == null || cri.getPayment_method().isEmpty() || cri.getPayment_method().contains("all")) {
            cri.setPayment_method(Arrays.asList("카드결제", "카카오페이", "무통장입금"));
        }

        List<Map<String, Object>> orderList = adminOrderService.getOrderList(cri);
        model.addAttribute("orderList", orderList);

        PageMaker pageMaker = new PageMaker();
        pageMaker.setDisplayPageNum(Constants.ADMIN_PRODUCT_LIST_PAGESIZE);
        pageMaker.setCri(cri);
        pageMaker.setTotalCount(adminOrderService.getTotalOrderCount(cri));
        model.addAttribute("pageMaker", pageMaker);

        return "admin/order/list";
    }

    @GetMapping("/detail")
    public String adminOrderDetail(Integer ord_code, Model model) throws Exception {

        // 주문정보 삽입
        List<Map<String, Object>> orderInfo = orderService.getOrderDetailInfo(ord_code);

        // 이미지 경로 : 역슬래시 - 슬래시로 변환
        orderInfo.forEach(map -> {
            String uploadFolder = (String) map.get("prod_uploadfolder");
            map.put("prod_uploadfolder", uploadFolder.replace("\\", "/"));
        });

        model.addAttribute("orderInfo", orderInfo);

        return "admin/order/detail";
    }

    @PostMapping("/direct_cancel")
    public ResponseEntity<String> orderDirectCancel(Integer ord_code) throws Exception {
        ResponseEntity<String> entity = null;
        adminOrderService.orderDirectCancel(ord_code);
        entity = new ResponseEntity<String>("success", HttpStatus.OK);
        return entity;
    }

    @PostMapping("/update")
    public ResponseEntity<String> orderUpdate(OrderUpdateDTO dto) throws Exception {
        ResponseEntity<String> entity = null;
        adminOrderService.updateOrderInfo(dto);
        entity = new ResponseEntity<String>("success", HttpStatus.OK);
        return entity;
    }

    @GetMapping("/image_display")
    public ResponseEntity<byte[]> image_display(String dateFolderName, String fileName) throws Exception {

        return fileUtils.getFile(uploadPath + "\\" + dateFolderName, fileName);
    }

}
