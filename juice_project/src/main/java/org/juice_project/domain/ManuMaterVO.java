package org.juice_project.domain;

import lombok.Data;

@Data
public class ManuMaterVO {
  private int lotNum;
  private int prodId;
  private String prodName;
  private int prodAmt;
  private int materId;
  private String materName;
  private int inputQut;
  private int bomQut;
  private int inventory;
}
