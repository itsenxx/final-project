package org.juice_project.domain;

import lombok.Data;

@Data
public class UpdateInstructionsDTO {
  private int prodId;
  private int prodName;
  private int instAmt;
  private int prodAmt;
  private String instDate;
  private String prodDate;
  private int empId;
  private int lotNum;
}
