package org.juice_project.controller;

import lombok.extern.log4j.Log4j;
import org.juice_project.domain.MaterInventoryVO;
import org.juice_project.domain.ProdInventoryVO;
import org.juice_project.service.InventoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.ResourceBundle;
@Log4j
@Controller
@RequestMapping("/inventory")
public class inventoryController {
  @Autowired
  private InventoryService inventoryService;

  @GetMapping("/inventory")
  public String prodInventory(Model model) {
    List<MaterInventoryVO> materInventoryVOList = inventoryService.selectMaterInventory();
    List<ProdInventoryVO> prodInventoryVOList = inventoryService.selectProdInventory();
    model.addAttribute("materInventoryVOList", materInventoryVOList);
    model.addAttribute("prodInventoryVOList", prodInventoryVOList);
    return "inventory/inventory";
  }

}

