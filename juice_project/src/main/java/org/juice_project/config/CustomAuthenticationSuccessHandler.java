package org.juice_project.config;

import jakarta.servlet.http.HttpSession;
import org.juice_project.config.auth.SpringSecPrincipalDetails;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

public class CustomAuthenticationSuccessHandler implements AuthenticationSuccessHandler {
    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException {
        HttpSession session = request.getSession();
        if(authentication.getPrincipal() instanceof SpringSecPrincipalDetails) {
            SpringSecPrincipalDetails userDetails = (SpringSecPrincipalDetails) authentication.getPrincipal();
            session.setAttribute("dep_id", userDetails.getEmployeeVO().getDepId());
            session.setAttribute("emp_id", userDetails.getEmployeeVO().getEmpId());
            session.setAttribute("password", userDetails.getEmployeeVO().getPassword());
            session.setAttribute("empName", userDetails.getEmployeeVO().getEmpName());
        }
        response.sendRedirect("/board/list");
    }
}
