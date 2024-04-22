package org.juice_project.service;

import org.juice_project.domain.CustomerVO;
import org.juice_project.domain.OrdersVO;

import java.util.List;

public interface SalesService {


    public List<CustomerVO> getCustList();

    public int putCustomer(CustomerVO customerVO);

    public CustomerVO getOneCust(Long custId);
    public List<OrdersVO> getOneOrder(Long orderId);
    public List<OrdersVO> getOrderList();

    public int updateOrder(Long orderId, Long empId);

}
