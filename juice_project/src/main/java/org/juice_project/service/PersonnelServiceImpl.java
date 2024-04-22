package org.juice_project.service;

import org.juice_project.domain.EmployeeVO;
import org.juice_project.mapper.PersonnelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import lombok.extern.log4j.Log4j;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Log4j
@Service
public class PersonnelServiceImpl implements PersonnelService{
    @Autowired
    private PersonnelMapper personnelMapper;

    @Override
    public List<EmployeeVO> selectEmployee() {
        List<EmployeeVO> employeeVOList = personnelMapper.selectEmployee();
        return employeeVOList;
    }

    @Override
    public int insertEmployee(String empName, String phone, String address, String email, int depId, String position) {
        EmployeeVO employeeVO = new EmployeeVO();
        employeeVO.setEmpName(empName);
        employeeVO.setPhone(phone);
        employeeVO.setAddress(address);
        employeeVO.setEmail(email);
        employeeVO.setDepId(depId);
        employeeVO.setPosition(position);
        return personnelMapper.insertEmployee(employeeVO);
    }

    @Override
    public void get(Long id) {
        // 메서드 로직을 여기에 구현합니다.
    }

    @Override
    public int remove(int empId) {
    return personnelMapper.deleteEmployee(empId);
    }



    @Override
    public int updateEmployee(EmployeeVO employeeVO) {
        return personnelMapper.updateEmployee(employeeVO);
    }





    @Override
    public void changePassword(int empId, String newPassword) {

        personnelMapper.changePassword(empId, newPassword);
    }

    @Override
    public void resetPassword(int empId, String newPassword) {

        personnelMapper.resetPassword(empId, newPassword);
    }



}
