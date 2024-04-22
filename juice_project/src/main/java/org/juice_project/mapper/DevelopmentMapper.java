package org.juice_project.mapper;

import org.juice_project.domain.BomVO;
import org.juice_project.domain.MaterialVO;
import org.juice_project.domain.ProductVO;

import java.util.List;
import java.util.Map;

public interface DevelopmentMapper {
    List<Map<String, Object>> selectMonthlySalesData();

    List<Map<String, Object>> selectSalesDataByProduct(Integer month);

    List<Map<String, Object>> selectSalesDataByCustomer(Integer month);

    void insertProduct(String prodName,
                       int lotSize,
                       String unit);

    List<ProductVO> selectAllProduct();

    void updateProductCondition(int prodId,
                                int condition);

    int findProdId(String prodName);

    void insertProdInventory(int prodid);

    List<BomVO> selectMaterial(int prodId);

    void deleteBom(int prodId);

    void insertBom(int prodId,
                   int materId,
                   int content,
                   int turn);

    List<BomVO> selectAllBom();
}
