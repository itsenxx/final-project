package org.juice_project.service;

import lombok.extern.log4j.Log4j;


import org.juice_project.domain.BuyVO;
import org.juice_project.domain.Criteria;
import org.juice_project.mapper.BuyMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Log4j
@Service
public class BuyServicelmpl implements BuyService {



    @Autowired
    BuyMapper mapper;




    @Override
    public List<BuyVO> getList() {
        List<BuyVO> buyVOList = mapper.getList();
        return buyVOList;
    }

    @Override
    public void register(BuyVO vo) {
        log.info("register......" + vo);
        mapper.insertSelectKey1(vo);

    }

    @Override
    public BuyVO get(int materId) {
        log.info("get......" + materId);
        return mapper.read(materId);
    }

    @Override
    public boolean modify(BuyVO buy) {
        log.info("modify......" + buy);
        return mapper.update(buy) == 1;
    }

    @Override
    public boolean remove(String mater_id) {
        log.info("remove...." + mater_id);
        return mapper.delete(mater_id) == 1;
    }


}

