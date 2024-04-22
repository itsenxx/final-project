package org.juice_project.controller;

import jakarta.servlet.http.HttpSession;
import lombok.extern.log4j.Log4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.juice_project.domain.BoardVO;

import org.juice_project.service.BoardService;


import java.util.List;

@Controller
@Log4j
@RequestMapping("/board")
public class BoardController {
	private BoardService service;
	@Autowired
	public BoardController(BoardService boardService) {
		this.service = boardService;
	}
	/**
	 * 게시물 목록 조회
	 * @param model
	 * @return
	 */
	@GetMapping("/list")
	public void list( @RequestParam(defaultValue = "1") int page,
					  Model model) {
		int limit = 10;
		int offset = (page - 1) * limit;
		List<BoardVO> boardVOList = service.getPaginatedBoardList(offset, limit);
		int totalRecords = service.getBoardCount();
		int totalPages = (int) Math.ceil((double) totalRecords / limit);

		model.addAttribute("board", boardVOList);
		model.addAttribute("totalPages", totalPages);
		model.addAttribute("currentPage", page);
	}

	@GetMapping("/register")
	public void register(){

	}

	/**
	 * 게시물 등록
	 * @param board
	 * @param rttr
	 * @return
	 */
	@PostMapping("/register")
	public String register(BoardVO board, RedirectAttributes rttr, HttpSession session) {
		Integer empId = (Integer) session.getAttribute("emp_id");
		board.setBoardEmpId(empId);
		service.register(board);	// 실제 게시판 글 입력
		rttr.addFlashAttribute("result", board.getBoardId());
		return "redirect:/board/list";
	}

	@PostMapping("/modify")
	public String modify(BoardVO vo, RedirectAttributes rttr) {
		if (service.modify(vo)) {
			rttr.addFlashAttribute("result", "success");
		}
		return "redirect:/board/list";
	}

	@GetMapping({"/get", "/modify"})
	public void get(
			@RequestParam("board_id") int board_id
			, Model model
	) {
		model.addAttribute("board", service.get(board_id));
	}

	@PostMapping("/remove")
	public String remove(@RequestParam("boardId") int board_id, RedirectAttributes rttr) {
		if (service.remove(board_id)) {
			rttr.addFlashAttribute("result", "success");
		}
		return "redirect:/board/list";
	}

}

