package org.juice_project.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/production")
public class ProdInventoryController {
  @GetMapping("/prodInventory")
  public String prodInventory(){
    return "production/prodInventory";
  }
}
