package org.juice_project.service;

import org.juice_project.domain.BomVO;
import org.juice_project.domain.ProductVO;

import java.util.List;
import java.util.Map;

public interface DevelopmentService {
    List<Map<String, Object>> getMonthlySalesData();

    List<Map<String, Object>> getSalesDataByProduct(Integer month);

    List<Map<String, Object>> getSalesDataByCustomer(Integer month);

    void insertProduct(String prodName,
                       int lotSize,
                       String unit);

    List<ProductVO> selectAllProduct();

    void updateProductCondition(int prodId,
                                int condition);

    void insertProdInventory(int prodId);

    int findProdId(String prodName);

    List<BomVO> selectMaterial(int prodId);

    void deleteBom(int prodId);

    void insertBom(int prodId,
                   List<BomVO> updateDetails);

    List<BomVO> selectAllBom();
}
