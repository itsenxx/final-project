package org.juice_project.domain;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Data
public class BuyVO {
    private int materId;
    private int suppId;
    private int quantity;
    private String order_date;
    private int empId;
    private int buyId;
}