package org.juice_project.service;

import org.apache.ibatis.session.RowBounds;
import org.juice_project.domain.ComVO;
import org.juice_project.mapper.ComMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ComServiceImpl implements ComService {
    @Autowired
    private ComMapper comMapper;


    public List<ComVO> getJoinCompanyList() {
        return comMapper.getJoinCompanyList();
    }
}
