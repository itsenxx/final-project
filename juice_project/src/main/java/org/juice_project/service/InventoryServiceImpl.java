package org.juice_project.service;

import lombok.extern.log4j.Log4j;
import org.juice_project.domain.MaterInventoryVO;
import org.juice_project.domain.ProdInventoryVO;
import org.juice_project.mapper.InventoryMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Log4j
@Service
public class InventoryServiceImpl implements InventoryService {
  @Autowired
  private InventoryMapper inventoryMapper;

  @Override
  public List<MaterInventoryVO> selectMaterInventory(){
    List<MaterInventoryVO> materInventoryVOList = inventoryMapper.selectMaterInventory();
    return materInventoryVOList;
  }
  @Override
  public List<ProdInventoryVO> selectProdInventory(){
    List<ProdInventoryVO> prodInventoryVOList = inventoryMapper.selectProdInventory();
    return prodInventoryVOList;
  }
}
