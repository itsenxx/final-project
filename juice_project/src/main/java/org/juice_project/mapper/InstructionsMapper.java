package org.juice_project.mapper;

import org.juice_project.domain.EmployeeVO;
import org.juice_project.domain.InstructionsVO;
import org.juice_project.domain.ProductVO;
import org.juice_project.domain.ProductionVO;
import java.util.List;

public interface InstructionsMapper {
  List<InstructionsVO> selectInstructions();
  int insertInstructions(InstructionsVO instructionsVO);
  int insertProduction(ProductionVO productionVO);
//  EmployeeVO findEmployeeById(int empId);
  ProductVO findProductById(int prodId);

}
