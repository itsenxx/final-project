package org.juice_project.controller;

import org.juice_project.domain.EmployeeVO;
import org.juice_project.service.PersonnelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/personnel")
public class PersonnelController {
    @Autowired
    private PersonnelService personnelService;

    @GetMapping("/employee")
    public String employee(){
        return "personnel/employee";
    }

    @GetMapping("/selectEmployee")
    public ResponseEntity<?> selectEmployee() {
        List<EmployeeVO> employeeVOList = personnelService.selectEmployee();
        return new ResponseEntity<>(employeeVOList, HttpStatus.OK);
    }
}
