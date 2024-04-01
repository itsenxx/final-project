package org.juice_project.controller;

import org.juice_project.config.auth.SpringSecPrincipalDetails;
import org.juice_project.domain.EmployeeVO;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/home")
public class HomeController {
    @GetMapping("/login")
    public String login(){
        return "home/login";
    }

    @GetMapping("/login-failure")
    public String loginFail() {
        return "home/login-failure";
    }

    @GetMapping("/home")
    public String home(Model model) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication != null && !(authentication instanceof AnonymousAuthenticationToken)) {
            Object principal = authentication.getPrincipal();
            if(principal instanceof SpringSecPrincipalDetails) {
                SpringSecPrincipalDetails userDetails = (SpringSecPrincipalDetails) principal;
                EmployeeVO employeeVO = userDetails.getEmployeeVO();
                model.addAttribute("employee", employeeVO);
            }
        }
        return "home/home";
    }

    @GetMapping("/logout")
    public String logout() {
        return "home/login";
    }
}
