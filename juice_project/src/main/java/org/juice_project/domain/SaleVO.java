package org.juice_project.domain;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Data
@Getter
@Setter
public class SaleVO {
    private int prodId;
    private int orderId;
    private int prodQuan;
    private Date orderDate;


}
