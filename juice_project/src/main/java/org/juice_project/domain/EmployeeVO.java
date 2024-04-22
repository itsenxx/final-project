package org.juice_project.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeVO {
    private int empId;
    private String empName;
    private String password;
    private String phone;
    private String address;
    private String email;
    private String position;
    private int depId;
    private String role;
    private String depName;
}
