package com.project.mallbydh.common.interceptor;


import com.project.mallbydh.member.MemberVO;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import java.io.BufferedReader;
import java.io.IOException;

@Component
public class LoginInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        HttpSession session = request.getSession();
        MemberVO memberVO = (MemberVO)session.getAttribute("login_auth");

        if(memberVO == null) {
            if(isAjaxRequest(request)) {
                response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
                response.setContentType("application/json");
                response.setCharacterEncoding("UTF-8");
                response.getWriter().write("{\"message\":\"Unauthorized\",\"redirectUrl\":\"/member/login\"}");
            } else {
                getTargetUrl(request);
                response.sendRedirect("/member/login");
            }
            return false;
        }
        return true;
    }

    // 인증되지 않은 상태에서 ajax 방식으로 post 요청 시 사용한 데이터
    private String getPostData(HttpServletRequest request) throws IOException {
        StringBuilder postData = new StringBuilder();
        BufferedReader reader = request.getReader();
        String line;
        while((line = reader.readLine()) != null) {
            postData.append(line);
        }
        return postData.toString();
    }

    // 클라이언트의 요청이 ajax인지 체크
    private boolean isAjaxRequest(HttpServletRequest request) {
        boolean isAjax = false;

        String header = request.getHeader("AJAX");
        if(header != null && header.equals("true")) {
            isAjax = true;
        }

        return isAjax;
    }

    // 인증되지 않은 상태에서 원래 요청한 주소(URI)의 정보를 저장
    private void getTargetUrl(HttpServletRequest request) {
        String uri = request.getRequestURI();
        String query = request.getQueryString();

        if(query == null || query.equals("null")) {
            query = "";
        }else {
            query = "?" + query;
        }

        String targetUrl = uri + query;

        if(request.getMethod().equals("GET")) {
            request.getSession().setAttribute("targetUrl", targetUrl);
        }
    }
}
