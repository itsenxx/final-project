package org.juice_project.service;

import java.util.List;

import org.apache.ibatis.session.RowBounds;
import org.juice_project.domain.EmployeeVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.juice_project.domain.BoardVO;

import org.juice_project.mapper.BoardMapper;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;

@Log4j
@Service
public class BoardServiceImpl implements BoardService {
    @Autowired
    private BoardMapper mapper;

    @Override
    public void register(BoardVO vo) {
        log.info("register......" + vo);
        mapper.insertSelectKey(vo);
    }

    @Override
    public BoardVO get(int board_id) {
        log.info("get......" + board_id);
        return mapper.read(board_id);
    }

    @Override
    public boolean modify(BoardVO board) {
        log.info("modify......" + board);
        return mapper.update(board) == 1;
    }

    @Override
    public boolean remove(int board_id) {
        log.info("remove...." + board_id);
        return mapper.delete(board_id) == 1;
    }

     @Override
     public List<BoardVO> getList() {
         log.info("getList..........");
         List<BoardVO> boardVOList = mapper.getList();
         return boardVOList;
     }
    @Autowired
    public BoardServiceImpl(BoardMapper boardMapper) {
        this.mapper = boardMapper;
    }

    @Override
    public List<BoardVO> getPaginatedBoardList(int offset, int limit) {
        return mapper.selectBoardList(new RowBounds(offset, limit));
    }

    @Override
    public int getBoardCount() {
        return mapper.selectBoardCount();
    }
}
