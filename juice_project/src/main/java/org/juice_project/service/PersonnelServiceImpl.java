package org.juice_project.service;

import org.juice_project.domain.EmployeeVO;
import org.juice_project.mapper.PersonnelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonnelServiceImpl implements PersonnelService{
    @Autowired
    private PersonnelMapper personnelMapper;

    @Override
    public List<EmployeeVO> selectEmployee() {
        List<EmployeeVO> employeeVOList = personnelMapper.selectEmployee();
        return employeeVOList;
    }
}
