package org.juice_project.service;

import lombok.extern.log4j.Log4j;
import org.apache.ibatis.session.RowBounds;
import org.juice_project.domain.SaleVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.juice_project.mapper.SaleListMapper;
import java.util.List;

@Service
@Log4j
public class SaleListServicelmpl implements SaleListService{
    @Autowired
    private SaleListMapper mapper;
    @Override
    public List<SaleVO> getList() {
        log.info("getList..........");
        List<SaleVO> saleVOList = mapper.getList();
        return saleVOList;
    }
    @Override
    public List<SaleVO> SaleList() {
        log.info("getList..........");
        List<SaleVO> saleVOList = mapper.SaleList();
        return saleVOList;
    }

    @Autowired
    public SaleListServicelmpl(SaleListMapper salelistMapper) {
        this.mapper = salelistMapper;
    }

    @Override
    public List<SaleVO> getPaginatedSaleList(int offset, int limit) {
        return mapper.selectSaleList(new RowBounds(offset, limit));
    }

    @Override
    public int getSaleCount() {
        return mapper.selectSaleCount();
    }
}
