package org.juice_project.mapper;

import org.juice_project.domain.EmployeeVO;

public interface EmployeeMapper {
    EmployeeVO selectByUserName(String username);
}
