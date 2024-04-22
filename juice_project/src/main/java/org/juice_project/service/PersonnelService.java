package org.juice_project.service;

import org.juice_project.domain.EmployeeVO;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface PersonnelService {

    public void get(Long bno);

    List<EmployeeVO> selectEmployee();

    int insertEmployee(String empName,
                       String phone,
                       String address,
                       String email,
                       int depId,
                       String position);

    int remove(int empId);

    int updateEmployee(EmployeeVO employeeVO);


     void changePassword(int empId,
                               String newPassword);

    void resetPassword(int empId,
                        String newPassword);

}
