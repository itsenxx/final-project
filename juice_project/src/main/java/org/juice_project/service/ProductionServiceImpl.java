package org.juice_project.service;

import lombok.extern.log4j.Log4j;
import org.juice_project.domain.*;
import org.juice_project.mapper.ProductionMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Log4j
@Service
public class ProductionServiceImpl implements ProductionService{
  @Autowired
  private ProductionMapper productionMapper;
  @Override
  public List<ProductionVO> selectProduction(){
    List<ProductionVO> productionVOList = productionMapper.selectProduction();
    return productionVOList;
  }

  @Override
  public List<ManuProdVO> selectManuProd(Integer lotNum){
    List<ManuProdVO> manuProdVOList = productionMapper.selectManuProd(lotNum);
    return manuProdVOList;
  }
  @Override
  public List<ManuMaterVO> selectManuMater(Integer lotNum){
    List<ManuMaterVO> manuMaterVOList = productionMapper.selectManuMater(lotNum);
    return manuMaterVOList;
  }



  @Override
  public boolean checkEmpId(int empId){
    return productionMapper.findEmployeeById(empId) !=null;
  }
  @Override
  public int updateInstructions(int prodAmt, String prodDate, int empId, int lotNum){
    InstructionsVO instructionsVO = new InstructionsVO();
    instructionsVO.setProdAmt(prodAmt);
    instructionsVO.setProdDate(prodDate);
    instructionsVO.setEmpId(empId);
    instructionsVO.setLotNum(lotNum);
    int rtn = productionMapper.updateInstructions(instructionsVO);
    return rtn;
  }
  @Override
  public int deleteProduction(int lotNum){
    return productionMapper.deleteProduction(lotNum);
  }
  @Override
  public int updateProdInventory(int prodId, int input, int inventory){
    ProdInventoryVO prodInventoryVO = new ProdInventoryVO();
    prodInventoryVO.setProdId(prodId);
    prodInventoryVO.setInput(input);
    prodInventoryVO.setInventory(inventory);
    int rtn = productionMapper.updateProdInventory(prodInventoryVO);
    return rtn;
  }

  @Override
  public int updateMaterInventory(int deduct, int materId) {
    MaterInventoryVO materInventoryVO = new MaterInventoryVO();
    materInventoryVO.setDeduct(deduct);
    materInventoryVO.setMaterId(materId);
    int rtn = productionMapper.updateMaterInventory(materInventoryVO);
    return rtn;
  }

  @Override
  public int findProdId(String prodName) {
    return productionMapper.findProdId(prodName);
  }

  @Override
  public int findInput(int prodId) {
    return productionMapper.findInput(prodId);
  }
  @Override
  public int findInventory(int prodId){
    return productionMapper.findInventory(prodId);
  }

  @Override
  public int findLotSize(int prodId) {
    return productionMapper.findLotSize(prodId);
  }

  @Override
  public List<MaterInventoryVO> selectMaterInventory(int prodId) {
    List<MaterInventoryVO> materInventoryVOList = productionMapper.selectMaterInventory(prodId);
    return materInventoryVOList;
  }

}
