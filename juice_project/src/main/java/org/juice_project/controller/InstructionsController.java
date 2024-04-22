package org.juice_project.controller;

import org.juice_project.domain.InstructionsVO;
import org.juice_project.domain.ProductVO;
import org.juice_project.service.InstructionsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/production")
public class InstructionsController {
  @Autowired
  private InstructionsService instructionsService;

  //조회
  @GetMapping("/instructions")
    public String instructions(Model model){
      List<InstructionsVO> instructionsVOList = instructionsService.selectInstructions();
      model.addAttribute("instructionsVOList", instructionsVOList);
      return "production/instructions";
  }
  //입력
  @PostMapping("/instructions_btn")
  public String instructions_btn(
      @RequestParam("prod_id") int prodId,
      @RequestParam("inst_amt") int instAmt,
      @RequestParam("inst_date") String instDate,
      RedirectAttributes rttr
  ) {
    int rtn1 = instructionsService.insertInstructions(
        prodId,
        instAmt,
        instDate
    );
    int rtn2 = instructionsService.insertProduction(
        prodId,
        instAmt,
        instDate
    );

    rttr.addFlashAttribute("insertInstructions", rtn1);
    rttr.addFlashAttribute("insertProduction", rtn2);

    return "redirect:/production/instructions";
  }

  //유효성 검사
  @GetMapping("/checkProdId")
  @ResponseBody
  public ResponseEntity<?> checkProdId(
      @RequestParam("prod_id") int prodId
  ){
    boolean isValid = instructionsService.checkProdId(prodId);
    return new ResponseEntity<>(Map.of("isValid", isValid), HttpStatus.OK);
  }

}
