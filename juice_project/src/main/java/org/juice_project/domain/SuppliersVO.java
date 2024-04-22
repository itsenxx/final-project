package org.juice_project.domain;

import lombok.Data;

@Data
public class SuppliersVO {
    private int suppId;
    private String suppName;
    private String phoneNum;
    private String address;
    private String email;
    private int materId;
    private String createDate;
}
