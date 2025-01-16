package com.project.mallbydh.cart;

import com.project.mallbydh.common.utils.FileUtils;
import com.project.mallbydh.member.MemberVO;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Slf4j
@RequestMapping("/cart/*")
@RequiredArgsConstructor
@Controller
public class CartController {

    private final CartService cartService;
    private final FileUtils fileUtils;

    @Value("${com.project.mallbydh.upload.path}")
    private String uploadPath;

    @GetMapping("/")
    public String cartIndex(HttpSession session, Model model) throws Exception {

        String u_id = ((MemberVO)session.getAttribute("login_auth")).getU_id();

        List<Map<String, Object>> cart_list = cartService.cart_list(u_id);
        cart_list.forEach(cartVO -> {
            cartVO.put("prod_uploadfolder", cartVO.get("prod_uploadfolder").toString().replace("\\", "/"));
        });
        model.addAttribute("cart_list", cart_list);

        return "cart/list";
    }

    @PostMapping("/cart_add")
    public ResponseEntity<String> cartAdd(CartVO vo, HttpSession session) throws Exception {
        ResponseEntity<String> entity = null;

        String u_id = ((MemberVO)session.getAttribute("login_auth")).getU_id();
        vo.setU_id(u_id);
        cartService.cart_add(vo);

        entity = new ResponseEntity<String>("success", HttpStatus.OK);

        return entity;
    }

    // "선택삭제" 버튼
    @GetMapping("/cart_checkdelete")
    public String cartCheckDelete(@RequestParam("prod_id") List<Integer> prod_ids, HttpSession session) throws Exception {
        String u_id = ((MemberVO)session.getAttribute("login_auth")).getU_id();

        for(Integer prod_id : prod_ids) {
            cartService.cart_checkdelete(u_id, prod_id);
        }

        return "redirect:/cart/";
    }

    // "장바구니비우기" 버튼
    @GetMapping("/cart_empty")
    public String cartEmpty(HttpSession session) throws Exception {
        String u_id = ((MemberVO)session.getAttribute("login_auth")).getU_id();
        cartService.cart_empty(u_id);
        return "redirect:/cart/";
    }

    @GetMapping("/image_display")
    public ResponseEntity<byte[]> image_display(String dateFolderName, String fileName) throws Exception {

        return fileUtils.getFile(uploadPath + "\\" + dateFolderName, fileName);
    }

    @PostMapping("/cart_update")
    public ResponseEntity<Map<String, Object>> cartUpdate(@RequestParam("prod_id") int prod_id,
                                                          @RequestParam("cart_amount") int cart_amount,
                                                          HttpSession session) throws Exception {
        String u_id = ((MemberVO)session.getAttribute("login_auth")).getU_id();

        int subtotal = cartService.cartUpdate(cart_amount, prod_id, u_id);

        Map<String, Object> response = new HashMap<>();
        response.put("status", "success");
        response.put("subtotal", subtotal);

        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
