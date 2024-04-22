package org.juice_project.service;

import org.juice_project.domain.BoardVO;
import org.juice_project.domain.BomVO;
import org.juice_project.domain.MaterialVO;


import java.util.List;

public interface BomService {
    public List<BomVO> getList();
    public List<MaterialVO> getList2();        // 게시판 전체 목록 조회
    public void register(BomVO vo);
    public List<BomVO> getBomList(int prod_id);
    public boolean modify(BomVO bom);
    List<BomVO> getPaginatedBomList(int offset, int limit);


    int getBomCount();

}
