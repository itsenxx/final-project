package org.juice_project.mapper;

import org.juice_project.domain.EmployeeVO;

import java.util.List;

public interface PersonnelMapper {
    List<EmployeeVO> selectEmployee();

    int insertEmployee(EmployeeVO employeeVO);

    int deleteEmployee(int empId);

    int updateEmployee(EmployeeVO employeeVO);



    EmployeeVO selectCustomers(int empId);
    void changePassword(int empId,
                        String newPassword);
    void resetPassword(int empId,
                        String newPassword);



}
