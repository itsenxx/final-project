package org.juice_project.mapper;

import org.juice_project.domain.BomVO;
import org.juice_project.domain.Criteria;
import org.juice_project.domain.MaterialVO;

import java.util.List;

public interface MaterialMapper {
    List<MaterialVO> getList(Criteria cri);        // 게시판 전체 목록 조회
}
