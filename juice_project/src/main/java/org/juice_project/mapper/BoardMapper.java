package org.juice_project.mapper;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.session.RowBounds;
import org.juice_project.domain.BoardVO;
import org.juice_project.domain.EmployeeVO;


public interface BoardMapper {


  void insertSelectKey(BoardVO vo);    // 게시판 등록

  List<BoardVO> getList();

  BoardVO read(int board_id);

  int delete(int board_id);

  int update(BoardVO board);
  List<BoardVO> selectBoardList(RowBounds rowBounds);

  int selectBoardCount();

}
