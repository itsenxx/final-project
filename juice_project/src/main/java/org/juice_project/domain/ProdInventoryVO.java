package org.juice_project.domain;

import lombok.Data;

@Data
public class ProdInventoryVO {
  private String transMonth;
  private int prodId;
  private String prodName;
  private int prevInventory;
  private int input;
  private int output;
  private int inventory;
  private int deduct;
  private int content;
  private int lotSize;
  private int materId;
}
