package org.juice_project.service;

import org.juice_project.domain.MaterialVO;
import org.juice_project.domain.SuppliersVO;
import org.juice_project.mapper.PurchaseMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PurchaseServiceImpl implements PurchaseService {
    @Autowired
    private PurchaseMapper purchaseMapper;

    @Override
    public List<MaterialVO> selectMaterial() {
        List<MaterialVO> materialVOList = purchaseMapper.selectMaterial();
        return materialVOList;
    }

    @Override
    public List<SuppliersVO> selectSuppliers(int materId) {
        List<SuppliersVO> suppliersVOList = purchaseMapper.selectSuppliers(materId);
        return suppliersVOList;
    }

    @Override
    public void insertMaterial(String materName, String unit) {
        purchaseMapper.insertMaterial(materName, unit);
    }

    @Override
    public void insertBuy(int materId, int suppId, int quantity, int empId) {
        purchaseMapper.insertBuy(materId, suppId, quantity, empId);
    }

    @Override
    public List<MaterialVO> selectAllMaterial() {
        List<MaterialVO> materialVOList = purchaseMapper.selectAllMaterial();
        return materialVOList;
    }

    @Override
    public void updateMaterialCondition(int materId, int condition) {
        purchaseMapper.updateMaterialCondition(materId, condition);
    }

    @Override
    public List<SuppliersVO> selectSuppliers2() {
        List<SuppliersVO> suppliersVOList = purchaseMapper.selectSuppliers2();
        return suppliersVOList;
    }

    @Override
    public List<MaterialVO> selectMaterial2(int suppId) {
        List<MaterialVO> materialVOList = purchaseMapper.selectMaterial2(suppId);
        return materialVOList;
    }

    @Override
    public List<MaterialVO> selectMaterial3(int suppId) {
        List<MaterialVO> materialVOList = purchaseMapper.selectMaterial3(suppId);
        return materialVOList;
    }

    @Override
    public void insertSuppliers(String suppName, String phoneNum, String address, String email) {
        purchaseMapper.insertSuppliers(suppName, phoneNum, address, email);
    }

    @Override
    public void insertSuppMater(int materId, int suppId) {
        purchaseMapper.insertSuppMater(materId, suppId);
    }

    @Override
    public List<SuppliersVO> selectAllSuppliers() {
        List<SuppliersVO> suppliersVOList = purchaseMapper.selectAllSuppliers();
        return suppliersVOList;
    }

    @Override
    public void deleteSuppMater(int suppId, int materId) {
        purchaseMapper.deleteSuppMater(suppId, materId);
    }

    @Override
    public int findMaterId(String materName) {
        return purchaseMapper.findMaterId(materName);
    }

    @Override
    public void insertMaterInventory(int materId) {
        purchaseMapper.insertMaterInventory(materId);
    }

    @Override
    public int findInventory(int materId) {
        return purchaseMapper.findInventory(materId);
    }

    @Override
    public int findInput(int materId) {
        return purchaseMapper.findInput(materId);
    }

    @Override
    public void updateMaterInventory(int materId, int input, int inventory) {
        purchaseMapper.updateMaterInventory(materId, input, inventory);
    }
}
