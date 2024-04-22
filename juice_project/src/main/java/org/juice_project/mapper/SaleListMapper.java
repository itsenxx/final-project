package org.juice_project.mapper;

import org.apache.ibatis.session.RowBounds;
import org.juice_project.domain.BoardVO;
import org.juice_project.domain.SaleVO;

import java.util.List;

public interface SaleListMapper {
    List<SaleVO> getList();
    List<SaleVO> SaleList();

    List<SaleVO> selectSaleList(RowBounds rowBounds);

    int selectSaleCount();

}
