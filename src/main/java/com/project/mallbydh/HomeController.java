package com.project.mallbydh;

import com.project.mallbydh.admin.product.ProductVO;
import com.project.mallbydh.common.utils.FileUtils;
import com.project.mallbydh.product.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@RequiredArgsConstructor
@Controller
public class HomeController {

    private final ProductService productService;
    private final FileUtils fileUtils;

    @Value("${com.project.mallbydh.upload.path}")
    private String uploadPath;

    @GetMapping("/")
    public String home(Model model) {

        // 최신상품 최근 8개만 표시 (ProductMapper.xml 에서 조정)
        List<ProductVO> latestProducts = productService.getLatestProducts();

        // 경로처리
        latestProducts.forEach(vo -> {
            vo.setProd_uploadfolder(vo.getProd_uploadfolder().replace("\\", "/"));
        });

        model.addAttribute("latestProducts", latestProducts);

        // 광고상품 8개 표시 (관리자에서 설정한 prod_priority에 근거한 순서)
        List<ProductVO> promotionProducts = productService.getPromotionProducts();

        // 경로처리
        promotionProducts.forEach(vo -> {
            vo.setProd_uploadfolder(vo.getProd_uploadfolder().replace("\\", "/"));
        });

        model.addAttribute("promotionProducts", promotionProducts);

        return "index";
    }

    // 이미지 출력
    @GetMapping("/image_display")
    public ResponseEntity<byte[]> image_display(String dateFolderName, String fileName) throws Exception {
        return fileUtils.getFile(uploadPath + "\\" + dateFolderName, fileName);
    }
}
