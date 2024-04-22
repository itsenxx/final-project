package org.juice_project.mapper;

import org.juice_project.domain.*;

import java.util.List;

public interface ProductionMapper {

  List<ProductionVO> selectProduction();
  List<ManuProdVO> selectManuProd(Integer lot_num);
  List<ManuMaterVO> selectManuMater(Integer lot_num);
  List<MaterInventoryVO> selectMaterInventory(int prodId);
  int updateInstructions(InstructionsVO instructionsVO);
  int deleteProduction(int lot_num);
  int updateProdInventory(ProdInventoryVO prodInventoryVO);
  int updateMaterInventory(MaterInventoryVO materInventoryVO);


  EmployeeVO findEmployeeById(int empId);
  ProductVO findProductById(int ProdId);


  int findProdId(String prodName);
  int findInput(int prodId);
  int findInventory(int prodId);
  int findLotSize(int prodId);
}
