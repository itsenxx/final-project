package org.juice_project.mapper;

import org.juice_project.domain.EmployeeVO;

import java.util.List;

public interface PersonnelMapper {
    List<EmployeeVO> selectEmployee();
}
