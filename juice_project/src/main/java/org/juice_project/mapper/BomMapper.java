package org.juice_project.mapper;

import org.apache.ibatis.session.RowBounds;
import org.juice_project.domain.BoardVO;
import org.juice_project.domain.BomVO;
import org.juice_project.domain.Criteria;
import org.juice_project.domain.MaterialVO;


import java.util.List;

public interface BomMapper {
   List<BomVO> getList();        // 게시판 전체 목록 조회

   // void insert(BomVO vo);     // 게시판 등록
   void insertSelectKey1(BomVO vo);    // 게시판 등록
   List<BomVO> read(int prod_id);

   List<MaterialVO> getList2();        // 게시판 전체 목록 조회

   int update(BomVO bom);
   List<BomVO> selectBomList(RowBounds rowBounds);

   int selectBomCount();

}
