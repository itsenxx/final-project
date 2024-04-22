package org.juice_project.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.session.RowBounds;
import org.juice_project.domain.ComVO;


import java.util.List;

@Mapper
public interface ComMapper {


    List<ComVO> getJoinCompanyList();
}
