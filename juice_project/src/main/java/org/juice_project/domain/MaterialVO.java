package org.juice_project.domain;

import lombok.Data;

@Data
public class MaterialVO {
    private int materId;
    private String materName;
    private String unit;
    private int condition;
    private int inventory;
}
