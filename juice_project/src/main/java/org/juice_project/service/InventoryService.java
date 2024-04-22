package org.juice_project.service;

import org.juice_project.domain.MaterInventoryVO;
import org.juice_project.domain.ProdInventoryVO;

import java.util.List;

public interface InventoryService {
  List<MaterInventoryVO> selectMaterInventory();
  List<ProdInventoryVO> selectProdInventory();
}
