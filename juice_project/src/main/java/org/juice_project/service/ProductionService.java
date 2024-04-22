package org.juice_project.service;

import org.juice_project.domain.*;

import java.util.List;

public interface ProductionService {
  List<ProductionVO> selectProduction();
  List<ManuProdVO> selectManuProd(Integer lotNum);
  List<ManuMaterVO> selectManuMater(Integer lotNum);



  int updateInstructions(int prodAmt, String prodDate, int empId, int lotNum);

  int deleteProduction(int lotNum);
  int updateProdInventory(int prodId, int input, int inventory);
  int updateMaterInventory(int deduct, int materId);

  boolean checkEmpId(int empId);

  int findProdId(String prodName);
  int findInput(int prodId);

  int findInventory(int prodId);
  int findLotSize(int prodId);
  List<MaterInventoryVO> selectMaterInventory(int prodId);
}
