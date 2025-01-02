package com.project.mallbydh.cart;

import ch.qos.logback.core.util.FileUtil;
import com.project.mallbydh.common.utils.FileUtils;
import com.project.mallbydh.member.MemberVO;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

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
    public String cartIndex() {
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
}
