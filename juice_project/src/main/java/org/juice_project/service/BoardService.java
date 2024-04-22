package org.juice_project.service;

import org.juice_project.domain.BoardVO;
//import org.juice_project.domain.Criteria;
import org.juice_project.domain.EmployeeVO;

import java.util.List;

// 게시판 서비스(등록, 상세 조회, 목록 조회, 수정, 삭제 etc)
public interface BoardService {
    public void register(BoardVO vo);
    public BoardVO get(int board_id);
    public boolean modify(BoardVO board);
    public boolean remove(int board_id);

    public List<BoardVO> getList();

    List<BoardVO> getPaginatedBoardList(int offset, int limit);

    int getBoardCount();
}

