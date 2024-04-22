package org.juice_project.controller;

import jakarta.servlet.http.HttpSession;
import org.eclipse.tags.shaded.org.apache.regexp.RE;
import org.juice_project.domain.BuyVO;
import org.juice_project.domain.MaterialVO;
import org.juice_project.domain.SuppMaterVO;
import org.juice_project.domain.SuppliersVO;
import org.juice_project.service.PurchaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/purchase")
public class PurchaseController {
    @Autowired
    private PurchaseService purchaseService;

    @GetMapping("/material")
    public String material() {
        return "purchase/material";
    }

    @GetMapping("/selectMaterial")
    public ResponseEntity<?> selectMaterial() {
        List<MaterialVO> materialVOList = purchaseService.selectMaterial();
        return new ResponseEntity<>(materialVOList, HttpStatus.OK);
    }

    @GetMapping("/selectMaterial2")
    public ResponseEntity<?> selectMaterial2(@RequestParam("suppId") int suppId) {
        List<MaterialVO> materialVOList = purchaseService.selectMaterial2(suppId);
        return new ResponseEntity<>(materialVOList, HttpStatus.OK);
    }

    @GetMapping("/selectMaterial3")
    public ResponseEntity<?> selectMaterial3(@RequestParam("suppId") int suppId) {
        List<MaterialVO> materialVOList = purchaseService.selectMaterial3(suppId);
        return new ResponseEntity<>(materialVOList, HttpStatus.OK);
    }

    @GetMapping("/selectSuppliers2")
    public ResponseEntity<?> selectSuppliers() {
        List<SuppliersVO> suppliersVOList = purchaseService.selectSuppliers2();
        return new ResponseEntity<>(suppliersVOList, HttpStatus.OK);
    }

    @GetMapping("/selectSuppliers")
    public ResponseEntity<?> selectSuppliers(@RequestParam("materId") int materId) {
        List<SuppliersVO> suppliersVOList = purchaseService.selectSuppliers(materId);
        return new ResponseEntity<>(suppliersVOList, HttpStatus.OK);
    }

    @PostMapping("/insertMaterial")
    public ResponseEntity<?> insertMaterial(@RequestBody MaterialVO materialVO) {
        purchaseService.insertMaterial(materialVO.getMaterName(), materialVO.getUnit());
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping("/insertSuppliers")
    public ResponseEntity<?> insertSuppliers(@RequestBody SuppliersVO suppliersVO) {
        purchaseService.insertSuppliers(suppliersVO.getSuppName(), suppliersVO.getPhoneNum(), suppliersVO.getAddress(), suppliersVO.getEmail());
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping("/insertSuppMater")
    public ResponseEntity<?> insertSuppMater(@RequestBody SuppMaterVO suppMaterVO) {
        purchaseService.insertSuppMater(suppMaterVO.getMaterId(), suppMaterVO.getSuppId());
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping("/insertBuy")
    public ResponseEntity<?> insertBuy(@RequestBody BuyVO buyVO, HttpSession session) {
        Integer empId = (Integer) session.getAttribute("emp_id");
        if (empId == null) {
            return new ResponseEntity<>("로그인을 해주세요.", HttpStatus.UNAUTHORIZED);
        }
        try {
            purchaseService.insertBuy(buyVO.getMaterId(), buyVO.getSuppId(), buyVO.getQuantity(), empId);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/selectAllMaterial")
    public ResponseEntity<?> selectAllMaterial() {
        List<MaterialVO> materialVOList = purchaseService.selectAllMaterial();
        return new ResponseEntity<>(materialVOList, HttpStatus.OK);
    }

    @GetMapping("/selectAllSuppliers")
    public ResponseEntity<?> selectAllSuppliers() {
        List<SuppliersVO> suppliersVOList = purchaseService.selectAllSuppliers();
        return new ResponseEntity<>(suppliersVOList, HttpStatus.OK);
    }

    @PostMapping("/updateMaterialCondition")
    public ResponseEntity<?> updateMaterialCondition(@RequestBody MaterialVO materialVO) {
        purchaseService.updateMaterialCondition(materialVO.getMaterId(), materialVO.getCondition());
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/supplier")
    public String supplier(){
        return "purchase/supplier";
    }

    @PostMapping("/deleteSuppMater")
    public ResponseEntity<?> deleteSuppMater(@RequestBody SuppMaterVO suppMaterVO) {
        purchaseService.deleteSuppMater(suppMaterVO.getSuppId(), suppMaterVO.getMaterId());
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping("/insertMaterInventory")
    public ResponseEntity<?> insertMaterInventory(@RequestBody MaterialVO materialVO){
        int materId = purchaseService.findMaterId(materialVO.getMaterName());
        purchaseService.insertMaterInventory(materId);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping("/updateMaterInventory")
    public ResponseEntity<?> updateMaterInventory(@RequestBody MaterialVO materialVO){
        int addInput = purchaseService.findInput(materialVO.getMaterId());
        int addInventory = purchaseService.findInventory(materialVO.getMaterId());
        int newInput = materialVO.getInventory() + addInput;
        int newInventory = materialVO.getInventory() + addInventory;
        purchaseService.updateMaterInventory(materialVO.getMaterId(), newInput, newInventory);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
