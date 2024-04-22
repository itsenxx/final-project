package org.juice_project.domain;

import lombok.Data;

@Data
public class ProductVO {
    private int prodId;
    private String prodName;
    private String unit;
    private int lotSize;
    private int condition;
    private int inventory;
}
