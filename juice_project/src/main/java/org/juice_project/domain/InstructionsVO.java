package org.juice_project.domain;

import lombok.Data;

import java.util.Date;

@Data
public class InstructionsVO {
  private int lotNum;
  private int prodId;
  private String prodName;
  private int instAmt;
  private int prodAmt;
  private String instDate;
  private String prodDate;
  private int empId;
  private String empName;
  private String completion;

}
