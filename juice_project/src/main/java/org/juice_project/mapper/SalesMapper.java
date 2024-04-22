package org.juice_project.mapper;

import org.juice_project.domain.CustomerVO;
import org.juice_project.domain.OrdersVO;

import java.util.List;

public interface SalesMapper {

    public List<CustomerVO> getCustomerList();

    public int insertCustomer(CustomerVO customerVO);

    CustomerVO getCustId(Long custId);
    List<OrdersVO> getOrderId(Long orderId);

    public List<OrdersVO> getOrderList();

    public int updateOrder(Long orderId, Long empId);

}
