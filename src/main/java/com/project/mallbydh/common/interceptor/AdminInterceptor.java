package com.project.mallbydh.common.interceptor;

import com.project.mallbydh.admin.AdminDTO;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

@Component
public class AdminInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        HttpSession session = request.getSession();
        AdminDTO adminDTO = (AdminDTO) session.getAttribute("admin_auth");

        if (adminDTO == null) {
            if (isAjaxRequest(request)) {
                response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
                response.setContentType("application/json");
                response.setCharacterEncoding("UTF-8");
                response.getWriter().write("{\"message\":\"Unauthorized\",\"redirectUrl\":\"/admin/\"}");
            } else {
                saveTargetUrl(request);
                response.sendRedirect("/admin/");
            }
            return false;
        }
        return true;
    }

    private boolean isAjaxRequest(HttpServletRequest request) {
        String header = request.getHeader("AJAX");
        return header != null && header.equals("true");
    }

    private void saveTargetUrl(HttpServletRequest request) {
        if (!"GET".equalsIgnoreCase(request.getMethod())) return;

        String uri = request.getRequestURI();
        String query = request.getQueryString();

        if (query != null && !"null".equals(query)) {
            uri += "?" + query;
        }

        request.getSession().setAttribute("targetUrl", uri);
    }
}
