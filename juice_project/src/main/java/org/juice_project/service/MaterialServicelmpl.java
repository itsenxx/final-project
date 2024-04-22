package org.juice_project.service;

import lombok.extern.log4j.Log4j;
import org.juice_project.domain.BomVO;
import org.juice_project.domain.Criteria;
import org.juice_project.domain.MaterialVO;
import org.juice_project.mapper.BomMapper;
import org.juice_project.mapper.MaterialMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Log4j
@Service
public class MaterialServicelmpl implements MaterialService {
    @Autowired
    MaterialMapper mapper;
    @Override
    public List<MaterialVO> getList(Criteria cri) {
        log.info("getList..........");
        List<MaterialVO> materialVOList = mapper.getList(cri);
        return materialVOList;
    }
}
