package org.juice_project.controller;

import org.eclipse.tags.shaded.org.apache.regexp.RE;
import org.juice_project.domain.BomRequestVO;
import org.juice_project.domain.BomVO;
import org.juice_project.domain.ProductVO;
import org.juice_project.service.DevelopmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/development")
public class DevelopmentController {
    @Autowired
    private DevelopmentService developmentService;

    @GetMapping("/salesStatus")
    public String salesStatus() {
        return "development/salesStatus";
    }

    @GetMapping("/selectAllBom")
    public ResponseEntity<?> selectAllBom() {
        List<BomVO> bomVOList = developmentService.selectAllBom();
        return new ResponseEntity<>(bomVOList, HttpStatus.OK);
    }

    @GetMapping("/selectSalesData")
    public ResponseEntity<?> selectSalesData(@RequestParam("type") String type,
                                             @RequestParam(value = "month", required = false) Integer month) {
        try {
            List<Map<String, Object>> data;
            switch (type) {
                case "monthly":
                    data = developmentService.getMonthlySalesData();
                    break;
                case "product":
                    data = developmentService.getSalesDataByProduct(month);
                    break;
                case "customer":
                    data = developmentService.getSalesDataByCustomer(month);
                    break;
                default:
                    return ResponseEntity.badRequest().body("실패했습니다.");
            }
            System.out.println("Data to return: " + data);
            return ResponseEntity.ok(data);
        } catch (Exception e) {
            System.err.println("Error during data fetch: " + e.getMessage());
            return ResponseEntity.internalServerError().build();
        }
    }

    @GetMapping("/product")
    public String product() {
        return "development/product";
    }

    @GetMapping("/bom")
    public String bom () {
        return "development/bom";
    }

    @PostMapping("/insertProduct")
    public ResponseEntity<?> insertProduct(@RequestBody ProductVO productVO) {
        developmentService.insertProduct(productVO.getProdName(), productVO.getLotSize(), productVO.getUnit());
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/selectAllProduct")
    public ResponseEntity<?> selectAllProduct() {
        List<ProductVO> productVOList = developmentService.selectAllProduct();
        return new ResponseEntity<>(productVOList, HttpStatus.OK);
    }

    @PostMapping("/updateProductCondition")
    public ResponseEntity<?> updateProductCondition(@RequestBody ProductVO productVO) {
        developmentService.updateProductCondition(productVO.getProdId(), productVO.getCondition());
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping("/insertProdInventory")
    public ResponseEntity<?> insertProdInventory(@RequestBody ProductVO productVO){
        int prodId = developmentService.findProdId(productVO.getProdName());
        developmentService.insertProdInventory(prodId);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/selectMaterial")
    public ResponseEntity<?> selectMaterial(@RequestParam("prodId") int prodId){
        List<BomVO> bomVOList = developmentService.selectMaterial(prodId);
        return new ResponseEntity<>(bomVOList, HttpStatus.OK);
    }

    @PostMapping("/deleteBom")
    public ResponseEntity<?> deleteBom(@RequestBody BomVO bomVO){
        developmentService.deleteBom(bomVO.getProdId());
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping("/insertBom")
    public ResponseEntity<?> insertBom(@RequestBody BomRequestVO bomRequestVO) {
        int prodId = bomRequestVO.getProdId();
        List<BomVO> updateData = bomRequestVO.getMaterials();
        developmentService.insertBom(prodId, updateData);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
