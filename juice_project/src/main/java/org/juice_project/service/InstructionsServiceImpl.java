package org.juice_project.service;

import lombok.extern.log4j.Log4j;
import org.juice_project.domain.InstructionsVO;
import org.juice_project.domain.ProductionVO;
import org.juice_project.mapper.InstructionsMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Log4j
@Service
public class InstructionsServiceImpl implements InstructionsService {
  @Autowired
  private InstructionsMapper instructionsMapper;


  @Override
  public List<InstructionsVO> selectInstructions() {
    List<InstructionsVO> instructionsVOList = instructionsMapper.selectInstructions();
    return instructionsVOList;
  }

  @Override
  public int insertInstructions(int prodId, int instAmt, String instDate) {
    InstructionsVO instructionsVO = new InstructionsVO();
    instructionsVO.setProdId(prodId);
    instructionsVO.setInstAmt(instAmt);
    instructionsVO.setInstDate(instDate);
    int rtn = instructionsMapper.insertInstructions(instructionsVO);
    return rtn;
  }


  @Override
  public int insertProduction(int prodId, int instAmt, String instDate) {
    ProductionVO productionVO = new ProductionVO();
    productionVO.setProdId(prodId);
    productionVO.setInstAmt(instAmt);
    productionVO.setInstDate(instDate);
    int rtn = instructionsMapper.insertProduction(productionVO);
    return rtn;
  }


  @Override
  public boolean checkProdId(int prodId) {
    return instructionsMapper.findProductById(prodId) != null;
  }
}
