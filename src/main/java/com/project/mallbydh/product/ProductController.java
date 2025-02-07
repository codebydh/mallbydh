package com.project.mallbydh.product;

import com.project.mallbydh.admin.category.AdCategoryService;
import com.project.mallbydh.admin.product.ProductVO;
import com.project.mallbydh.common.utils.FileUtils;
import com.project.mallbydh.member.MemberVO;
import com.project.mallbydh.wish.WishService;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.apache.tomcat.util.net.openssl.ciphers.Authentication;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@RequiredArgsConstructor
@RequestMapping("/product/*")
@Controller
public class ProductController {

    private final ProductService productService;
    private final AdCategoryService AdCategoryService;
    private final FileUtils fileUtils;
    private final WishService wishService;

    @Value("${com.project.mallbydh.upload.path}")
    private String uploadPath;

    @GetMapping("/list")
    public String getProductList(@RequestParam(required = false) Integer cate_id,
                                 @RequestParam(required = false) Integer parent_id,
                                 Model model, HttpSession session) {

        List<ProductVO> productList;

        if (cate_id != null) {
            // 2차 카테고리로 조회
            productList = productService.getProductsByCateId(cate_id);
            model.addAttribute("currentCategory", AdCategoryService.getCategoryById(cate_id));
        } else if (parent_id != null) {
            // 1차 카테고리의 ALL 클릭 시
            List<Integer> subCategoryIds = AdCategoryService.getSubCategoriesByParentId(parent_id);
            productList = productService.getProductsByMultipleCateIds(subCategoryIds);
            model.addAttribute("currentCategory", AdCategoryService.getCategoryById(parent_id));
        } else {
            // 전체 상품 조회
            productList = productService.getAllProducts();
        }

        productList.forEach(vo -> {
            vo.setProd_uploadfolder(vo.getProd_uploadfolder().replace("\\", "/"));
        });

        model.addAttribute("productList", productList);
        model.addAttribute("categories", AdCategoryService.getAllCategories());

        // 로그인 상태일 때만 찜목록 처리
        MemberVO loginUser = (MemberVO) session.getAttribute("login_auth");
        if (loginUser != null) {
            List<Integer> wishList = wishService.getWishListForUser(loginUser.getU_id());
            model.addAttribute("wishList", wishList);
        }

        return "product/list";
    }

    // 이미지 출력
    @GetMapping("/image_display")
    public ResponseEntity<byte[]> image_display(String dateFolderName, String fileName) throws Exception {
        return fileUtils.getFile(uploadPath + "\\" + dateFolderName, fileName);
    }

    @GetMapping("/detail")
    public String getProductDetail(Integer prod_id, Model model) {
        ProductVO productVO = productService.getProductById(prod_id);
        productVO.setProd_uploadfolder(productVO.getProd_uploadfolder().replace("\\", "/"));
        model.addAttribute("productVO", productVO);
        return "product/detail";
    }

}
