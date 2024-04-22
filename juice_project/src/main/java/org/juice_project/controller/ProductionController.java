package org.juice_project.controller;

import lombok.extern.log4j.Log4j;
import org.juice_project.domain.*;
import org.juice_project.service.ProductionService;
import org.juice_project.service.ResponsEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;


@Log4j
@Controller
@RequestMapping("/production")
public class ProductionController {
  @Autowired
  private ProductionService productionService;

  @RequestMapping(value = "/production", method = {RequestMethod.GET, RequestMethod.POST})
  public String production(Model model){
    List<ProductionVO> productionVOList = productionService.selectProduction();
    model.addAttribute("productionVOList", productionVOList);
    return "production/production";
  }

  @GetMapping("/checkEmpId")
  @ResponseBody
  public ResponseEntity<?> checkEmpId(
      @RequestParam("emp_id") int empId
  ){
    boolean isValid = productionService.checkEmpId(empId);
    return new ResponseEntity<>(Map.of("isValid", isValid), HttpStatus.OK);
  }

  @GetMapping("/selectProduction")
  @ResponseBody
  public ResponseEntity<?> selectProductionData() {
    List<ProductionVO> productionVOList = productionService.selectProduction();
    return new ResponseEntity<>(productionVOList, HttpStatus.OK);
  }

  @GetMapping("/selectManuProd")
  @ResponseBody
  public ResponseEntity<?> manuProd(
      @RequestParam(value = "lot_num", required = false) Integer lotNum
  ){
    List<ManuProdVO> manuProdVOList = productionService.selectManuProd(lotNum);
    if(manuProdVOList != null){
      return new ResponseEntity<>(manuProdVOList, HttpStatus.OK);
    }else{
      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
  }

  @GetMapping("/selectManuMater")
  @ResponseBody                             //ajax 사용 시 필요
  public ResponseEntity<?> manuMater(
      @RequestParam(value = "lot_num", required = false) Integer lotNum
  ){
    List<ManuMaterVO> manuMaterVOList = productionService.selectManuMater(lotNum);
    if(manuMaterVOList != null){
      return new ResponseEntity<>(manuMaterVOList, HttpStatus.OK);
    }else{
      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
  }

  @RequestMapping(method = {RequestMethod.POST},
      value = "/updateInstructions",
      produces = {MediaType.TEXT_PLAIN_VALUE})
  @ResponseBody                             //ajax 사용 시 필요
  public ResponseEntity<?> updateInstructions(
      @RequestBody InstructionsVO instructionsVO
  ){
    int prodAmt = instructionsVO.getProdAmt();
    String prodDate = instructionsVO.getProdDate();
    int empId = instructionsVO.getEmpId();
    int lotNum = instructionsVO.getLotNum();
    System.out.println(prodAmt);
    System.out.println(prodDate);
    System.out.println(empId);
    System.out.println(lotNum);
    return productionService.updateInstructions(prodAmt, prodDate, empId, lotNum) == 1 ? new ResponseEntity<>("success",HttpStatus.OK):new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
  }

  @RequestMapping(method = {RequestMethod.POST},
      value = "/deleteProduction",
      produces = {MediaType.TEXT_PLAIN_VALUE})
  @ResponseBody
  public ResponseEntity<?> deleteProduction(
      @RequestBody DeleteProductionDTO dto){
    int lotNum = dto.getLotNum();
    return productionService.deleteProduction(lotNum) == 1 ? new ResponseEntity<>("success", HttpStatus.OK):new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
  }

  @RequestMapping(method={RequestMethod.POST},
      value = "/updateProdInventory",
      produces = {MediaType.TEXT_PLAIN_VALUE}
  )
  @ResponseBody
  public ResponseEntity<?> updateProdInventory(
      @RequestBody ProdInventoryVO prodInventoryVO
  ){
    int input = prodInventoryVO.getInput();
    String prodName = prodInventoryVO.getProdName();
    int prodId = productionService.findProdId(prodName);
    int currentInput = productionService.findInput(prodId);
    int currentInventory = productionService.findInventory(prodId);
    int newInventory = input + currentInventory;
    int newInput = input + currentInput;
    return productionService.updateProdInventory(prodId, newInput, newInventory)== 1 ? new ResponseEntity<>("success", HttpStatus.OK):new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
  }

  @RequestMapping(method={RequestMethod.POST},
      value = "/updateMaterInventory",
      produces = {MediaType.TEXT_PLAIN_VALUE}
  )
  @ResponseBody
  public ResponseEntity<?> updateMaterInventory(
      @RequestBody ProdInventoryVO prodInventoryVO
  ){
    int output = prodInventoryVO.getOutput();
    String prodName = prodInventoryVO.getProdName();
    int prodId = productionService.findProdId(prodName);
    int lotSize = productionService.findLotSize(prodId);
    System.out.println(output);
    System.out.println(prodName);
    System.out.println(prodId);
    System.out.println(lotSize);

    List<MaterInventoryVO> materInventoryVOList = productionService.selectMaterInventory(prodId);
    int[] content = new int[materInventoryVOList.size()];
    int[] deduct = new int[materInventoryVOList.size()];
    int[] materId = new int[materInventoryVOList.size()];
    for(int i = 0; i<materInventoryVOList.size(); i++){
      materId[i] = materInventoryVOList.get(i).getMaterId();
      content[i] = materInventoryVOList.get(i).getContent();
      deduct[i] = output * content[i] / lotSize;
      productionService.updateMaterInventory(deduct[i], materId[i]);
    }
    return new ResponseEntity<>(HttpStatus.OK);
  }
}
