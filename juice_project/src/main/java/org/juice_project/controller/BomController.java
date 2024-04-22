package org.juice_project.controller;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;
import org.juice_project.domain.BoardVO;
import org.juice_project.domain.Criteria;
import org.juice_project.domain.MaterialVO;
import org.juice_project.service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.juice_project.domain.BomVO;

import lombok.RequiredArgsConstructor;
import org.juice_project.service.BomService;


import java.util.List;

@Controller
@Log4j
@RequestMapping("/develop")
public class BomController {
    private BomService service;

    @Autowired
    public BomController(BomService bomService) {
        this.service = bomService;
    }

    /**
     * 게시물 목록 조회
     * @param model
     * @return
     */
    @GetMapping("/bom")
    public void list( @RequestParam(defaultValue = "1") int page,
                      Model model) {
        int limit = 10;
        int offset = (page - 1) * limit;
        List<BomVO> bomVOList = service.getPaginatedBomList(offset, limit);
        int totalRecords = service.getBomCount();
        int totalPages = (int) Math.ceil((double) totalRecords / limit);

        List<MaterialVO> materialVOList = service.getList2();

        model.addAttribute("materialList", materialVOList);
        model.addAttribute("bom", bomVOList);
        model.addAttribute("totalPages", totalPages);
        model.addAttribute("currentPage", page);
    }

    @GetMapping("/register")
    public void register() {

    }

    /**
     * 게시물 등록
     * @param bom
     * @param rttr
     * @return
     */

    @PostMapping("/register")
    public String register(BomVO bom, RedirectAttributes rttr) {
        log.info("등록: " + bom);

        service.register(bom);	// 실제 게시판 글 입력
        rttr.addFlashAttribute("result", bom.getProdId());
//
        return "redirect:/develop/bom";
    }
    @PostMapping("/modifyBom")
    public String modify(BomVO vo, RedirectAttributes rttr) {
        if (service.modify(vo)) {
            rttr.addFlashAttribute("result", "success");
        }
        return "redirect:/develop/bom";
    }

    @GetMapping({"/getBom", "/modifyBom"})
    public void getBom(
            @RequestParam("prod_id") int prod_id
            , Model model
    ) {
        model.addAttribute("prod_id", prod_id);
        model.addAttribute("bomList", service.getBomList(prod_id));
    }

}


