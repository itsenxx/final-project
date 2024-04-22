package org.juice_project.domain;


import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.Date;

@Data
@AllArgsConstructor
public class CustomerVO {

    private int custId;
    private String custName;
    private String password;
    private String createDate;
    private String updateDate;
    private String phoneNum;
    private String roadAddr;
    private String detailAddr;

}
