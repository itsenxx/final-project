package org.juice_project.service;

import org.juice_project.domain.InstructionsVO;
import org.juice_project.domain.ProductVO;
import java.util.List;

public interface InstructionsService {

  List<InstructionsVO> selectInstructions();
  int insertInstructions(
      int prodId,
      int instAmt,
      String instDate
  );
  int insertProduction(
      int prodId,
      int instAmt,
      String instDate
  );
  boolean checkProdId(int prodId);
}
