package com.project.mallbydh.wish;

import com.project.mallbydh.member.MemberVO;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Slf4j
@RequestMapping("/wish/*")
@RequiredArgsConstructor
@Controller
public class WishController {

    private final WishService wishService;

    @PostMapping("/wish_add")
    public ResponseEntity<String> wishAdd(WishVO vo, HttpSession session) throws Exception {
        ResponseEntity<String> entity = null;

        String u_id = ((MemberVO)session.getAttribute("login_auth")).getU_id();
        vo.setU_id(u_id);
        wishService.wishAdd(vo);

        entity = new ResponseEntity<String>("success", HttpStatus.OK);

        return entity;
    }

    @PostMapping("/wish_remove")
    public ResponseEntity<String> wishRemove(@RequestParam("prod_id") int prod_id, HttpSession session) throws Exception {
        ResponseEntity<String> entity = null;

        String u_id = ((MemberVO)session.getAttribute("login_auth")).getU_id();
        wishService.wishRemove(u_id, prod_id);

        entity = new ResponseEntity<String>("success", HttpStatus.OK);

        return entity;
    }
}
