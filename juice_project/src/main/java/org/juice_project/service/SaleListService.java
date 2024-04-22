package org.juice_project.service;

import org.juice_project.domain.BoardVO;
import org.juice_project.domain.SaleVO;

import java.util.List;

public interface SaleListService {
    public List<SaleVO> getList();
    public List<SaleVO> SaleList();
    List<SaleVO> getPaginatedSaleList(int offset, int limit);

    int getSaleCount();
}
