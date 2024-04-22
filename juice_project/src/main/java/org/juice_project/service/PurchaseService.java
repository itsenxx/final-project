package org.juice_project.service;

import org.juice_project.domain.MaterialVO;
import org.juice_project.domain.SuppliersVO;

import java.util.List;

public interface PurchaseService {
    List<MaterialVO> selectMaterial();

    List<SuppliersVO> selectSuppliers(int materId);

    void insertMaterial(String materName,
                        String unit);

    void insertBuy(int materId,
                   int suppId,
                   int quantity,
                   int empId);

    List<MaterialVO> selectAllMaterial();

    void updateMaterialCondition(int materId,
                                 int condition);

    List<SuppliersVO> selectSuppliers2();

    List<MaterialVO> selectMaterial2(int suppId);

    List<MaterialVO> selectMaterial3(int suppId);

    void insertSuppliers(String suppName,
                         String phoneNum,
                         String address,
                         String email);

    void insertSuppMater(int materId,
                         int suppId);

    List<SuppliersVO> selectAllSuppliers();

    void deleteSuppMater(int suppId,
                         int materId);

    int findMaterId(String materName);

    void insertMaterInventory(int materId);

    int findInventory(int materId);

    int findInput(int materId);

    void updateMaterInventory(int materId, int input, int inventory);
}
