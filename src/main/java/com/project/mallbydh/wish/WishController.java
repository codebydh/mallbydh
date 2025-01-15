package com.project.mallbydh.wish;

import com.project.mallbydh.member.MemberVO;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.HashMap;
import java.util.Map;

@Slf4j
@RequestMapping("/wish/*")
@RequiredArgsConstructor
@Controller
public class WishController {

    private final WishService wishService;

    @PostMapping("/wish_add")
    public ResponseEntity<Map<String, Object>> wishAdd(@RequestParam("prod_id") int prod_id, HttpSession session) {
        Map<String, Object> response = new HashMap<>();

        String u_id = ((MemberVO)session.getAttribute("login_auth")).getU_id();

        boolean isNewItem = wishService.addToWish(u_id, prod_id);

        response.put("status", "success");
        response.put("isNewItem", isNewItem);

        return ResponseEntity.ok(response);
    }

    @PostMapping("/wish_remove")
    public ResponseEntity<Map<String, Object>> wishRemove(@RequestParam("prod_id") int prod_id, HttpSession session) {
        Map<String, Object> response = new HashMap<>();

        String u_id = ((MemberVO)session.getAttribute("login_auth")).getU_id();

        boolean isRemoved = wishService.wishRemove(u_id, prod_id);

        response.put("status", "success");
        response.put("isRemoved", isRemoved);

        return ResponseEntity.ok(response);
    }
}
