package org.juice_project.domain;

import lombok.Data;

@Data
public class BomVO {
    private int prodId;
    private int materId;
    private int turn;
    private int content;
    private String materName;
    private String unit;
    private String prodName;
}
