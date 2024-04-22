package org.juice_project.controller;

import jakarta.servlet.http.HttpSession;
import org.juice_project.domain.EmployeeVO;
import org.juice_project.service.PersonnelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;
import java.util.Objects;

@Controller
@RequestMapping("/personnel")
public class PersonnelController {
    @GetMapping("/personalmanagement")
    public String personalmanagement() {
        return "personnel/personalmanagement";
    }

    @Autowired
    private PersonnelService personnelService;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @GetMapping("/selectEmployee")
    public ResponseEntity<?> selectEmployee() {
        List<EmployeeVO> employeeVOList = personnelService.selectEmployee();
        return new ResponseEntity<>(employeeVOList, HttpStatus.OK);
    }

    @PostMapping("/insertEmployee")
    public ResponseEntity<?> insertEmployee(@RequestBody EmployeeVO employeeVO){
        String empName = employeeVO.getEmpName();
        String phone = employeeVO.getPhone();
        String address = employeeVO.getAddress();
        String email = employeeVO.getEmail();
        int depId = employeeVO.getDepId();
        String position = employeeVO.getPosition();
        return personnelService.insertEmployee(empName, phone, address, email, depId, position) == 1 ? new ResponseEntity<>("success", HttpStatus.OK) : new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @PostMapping("/deleteEmployee")
    public ResponseEntity<Integer> deleteEmployee(@RequestParam("empId") int empId) {
        try {
            int result = personnelService.remove(empId);
            return ResponseEntity.ok(result);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(-1);
        }
    }

    @PostMapping("/updateEmployee")
    public ResponseEntity<String> updateEmployee(@RequestBody EmployeeVO employeeVO) {
        try {
            int result = personnelService.updateEmployee(employeeVO);
            if (result == 1) {
                return ResponseEntity.ok("success");
            } else {
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("failed");
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("failed");
        }
    }

    @PostMapping("/changePassword")
    public String changePassword(@RequestParam("empId") int empId,
                                 @RequestParam("newPassword") String newPassword,
                                 HttpSession session,
                                 RedirectAttributes redirectAttributes) {
        Integer sessionempId = (Integer) session.getAttribute("emp_id");
        if (sessionempId == null || sessionempId != empId) {
            System.out.println("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");
            redirectAttributes.addFlashAttribute("message", "로그인 상태가 아닙니다.");
            return "redirect:mypage";
        }
        try {
            String encodedPassword = bCryptPasswordEncoder.encode(newPassword);
            personnelService.changePassword(empId, encodedPassword);
            session.setAttribute("password", encodedPassword);
            System.out.println("bbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbb");
            redirectAttributes.addFlashAttribute("message", "비밀번호 변경을 성공했습니다.");
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("cccccccccccccccccccccccccc");
            redirectAttributes.addFlashAttribute("message", "비밀번호 변경을 실패했습니다.");
        }
        return "redirect:mypage";
    }


    @GetMapping("/mypage")
    public String myPage(HttpSession session, Model model) {
        String empName = (String) session.getAttribute("empName");
        Integer empId = (Integer) session.getAttribute("emp_id");
        String password = (String) session.getAttribute("password");
        model.addAttribute("empName", empName);
        model.addAttribute("empId", empId);
        model.addAttribute("password", password);
        return "personnel/mypage";
    }



    @PostMapping("/resetPassword")
    public String resetPassword(@RequestParam("empId") int empId,
                                HttpSession session,
                                RedirectAttributes redirectAttributes) {
        try {
            String encodedPassword = "$2a$10$zZMz4/ONUQ9wH.nAE6sNxu32NxbIfiHBO72d2LOrP4bJ63yolVOo6";
            personnelService.changePassword(empId, encodedPassword);
            session.setAttribute("password", encodedPassword);
            redirectAttributes.addFlashAttribute("message", "비밀번호 변경을 성공했습니다.");
        } catch (Exception e) {
            e.printStackTrace();
            redirectAttributes.addFlashAttribute("message", "비밀번호 변경을 실패했습니다.");
        }
        return "redirect:personalmanagement";
    }
}
