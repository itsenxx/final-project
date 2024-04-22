package org.juice_project.service;

import lombok.extern.log4j.Log4j;
import org.apache.ibatis.session.RowBounds;
import org.juice_project.domain.BoardVO;
import org.juice_project.domain.BomVO;

import org.juice_project.domain.Criteria;
import org.juice_project.domain.MaterialVO;
import org.juice_project.mapper.BoardMapper;
import org.juice_project.mapper.BomMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Log4j
@Service
public class BomServicelmpl implements BomService {
    @Autowired
    BomMapper mapper;
    @Override
    public List<BomVO> getList( ) {
        log.info("getList..........");
        List<BomVO> bomVOList = mapper.getList();
        return bomVOList;
    }
    @Override
    public void register(BomVO vo) {
        log.info("register......" + vo);
        mapper.insertSelectKey1(vo);
        //mapper.insert(vo);
    }

    @Override
    public List<BomVO> getBomList(int prod_id) {
        return mapper.read(prod_id);
    }

    @Override
    public boolean modify(BomVO bom) {
        log.info("modify......" + bom);
        return mapper.update(bom) == 1;
    }


    @Autowired
    public BomServicelmpl(BomMapper bomMapper) {
        this.mapper = bomMapper;
    }

    @Override
    public List<BomVO> getPaginatedBomList(int offset, int limit) {
        return mapper.selectBomList(new RowBounds(offset, limit));
    }

    @Override
    public int getBomCount() { return mapper.selectBomCount(); }

    @Override
    public List<MaterialVO> getList2() {
        List<MaterialVO> materialVOList = mapper.getList2();
        return materialVOList;
    }

}
