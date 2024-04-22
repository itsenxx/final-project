
package org.juice_project.service;

import org.juice_project.domain.BomVO;
import org.juice_project.domain.MaterialVO;
import org.juice_project.domain.ProductVO;
import org.juice_project.mapper.DevelopmentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class DevelopmentServiceImpl implements DevelopmentService{
    @Autowired
    private DevelopmentMapper developmentMapper;

    @Override
    public List<Map<String, Object>> getMonthlySalesData() {
        return developmentMapper.selectMonthlySalesData();
    }

    @Override
    public List<Map<String, Object>> getSalesDataByProduct(Integer month) {
        return developmentMapper.selectSalesDataByProduct(month);
    }

    @Override
    public List<Map<String, Object>> getSalesDataByCustomer(Integer month) {
        return developmentMapper.selectSalesDataByCustomer(month);
    }

    @Override
    public void insertProduct(String prodName, int lotSize, String unit) {
        developmentMapper.insertProduct(prodName, lotSize, unit);
    }

    @Override
    public List<ProductVO> selectAllProduct() {
        List<ProductVO> productVOList = developmentMapper.selectAllProduct();
        return productVOList;
    }

    @Override
    public void updateProductCondition(int prodId, int condition) {
        developmentMapper.updateProductCondition(prodId, condition);
    }

    @Override
    public void insertProdInventory(int prodId) {
        developmentMapper.insertProdInventory(prodId);
    }

    @Override
    public int findProdId(String prodName) {
        return developmentMapper.findProdId(prodName);
    }

    @Override
    public List<BomVO> selectMaterial(int prodId) {
        List<BomVO> bomVOList = developmentMapper.selectMaterial(prodId);
        return bomVOList;
    }

    @Override
    public void deleteBom(int prodId) {
        developmentMapper.deleteBom(prodId);
    }

    @Override
    public void insertBom(int prodId, List<BomVO> updateDetails) {
        int turn = 1;
        for (BomVO detail : updateDetails) {
            developmentMapper.insertBom(prodId, detail.getMaterId(), detail.getContent(), turn++);
        }
    }

    @Override
    public List<BomVO> selectAllBom() {
        List<BomVO> bomVOList = developmentMapper.selectAllBom();
        return bomVOList;
    }
}
