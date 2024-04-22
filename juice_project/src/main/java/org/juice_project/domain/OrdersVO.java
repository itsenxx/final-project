package org.juice_project.domain;

import lombok.Data;

import java.util.Date;

@Data
public class OrdersVO {

    private Long orderId;
    private int custId;
    private int prodId;
    private int orderStatus;
    private String prodQuan;
    private String orderDate;
    private String saleDate;
    private String empId;
    private String custName;
    private String prodName;
}
