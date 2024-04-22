package org.juice_project.mapper;

import org.juice_project.domain.MaterInventoryVO;
import org.juice_project.domain.ProdInventoryVO;

import java.util.List;

public interface InventoryMapper {
  List<MaterInventoryVO> selectMaterInventory();
  List<ProdInventoryVO> selectProdInventory();
}
