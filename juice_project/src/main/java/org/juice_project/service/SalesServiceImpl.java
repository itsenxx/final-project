package org.juice_project.service;

import lombok.extern.log4j.Log4j;
import org.juice_project.domain.CustomerVO;
import org.juice_project.domain.OrdersVO;
import org.juice_project.mapper.SalesMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
@Log4j
public class SalesServiceImpl implements SalesService {

    @Autowired
    private SalesMapper salesMapper;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;
    @Override
    public List<CustomerVO> getCustList() {
        return salesMapper.getCustomerList();
    }

    @Override
    public int putCustomer(CustomerVO customerVO) {
        
        //암호화 과정 취소
        //String rawPwd = customerVO.getPassword();
        //String encryptPwd = bCryptPasswordEncoder.encode(rawPwd);       
        //customerVO.setPassword(encryptPwd);

        return salesMapper.insertCustomer(customerVO);
    }

    @Override
    public CustomerVO getOneCust(Long custId) {
        return salesMapper.getCustId(custId);
    }

    @Override
    public List<OrdersVO> getOrderList() {
        return salesMapper.getOrderList();
    }

    @Override
    public List<OrdersVO> getOneOrder(Long orderId) {
        List<OrdersVO> ordersVOList = salesMapper.getOrderId(orderId);
        return ordersVOList;
    }

    @Override
    public int updateOrder(Long orderId, Long empId) {
        return salesMapper.updateOrder(orderId, empId);
    }
}
