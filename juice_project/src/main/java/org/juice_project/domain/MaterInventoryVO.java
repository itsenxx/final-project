package org.juice_project.domain;

import lombok.Data;

@Data
public class MaterInventoryVO {
  private String transMonth;
  private int materId;
  private String materName;
  private int prevInventory;
  private int input;
  private int output;
  private int inventory;
  private int content;
  private int deduct;
  private int prodId;
  private String prodName;
}
