package org.juice_project.controller;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;
import org.juice_project.domain.BomVO;
import org.juice_project.domain.Criteria;
import org.juice_project.domain.MaterialVO;
import org.juice_project.service.BomService;
import org.juice_project.service.MaterialService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@Log4j
@RequestMapping("/develop")
@AllArgsConstructor
public class MaterialController {
    private MaterialService service;
    @GetMapping("/material")
    public void list(Criteria cri, Model model) {
        log.info("material");

        List<MaterialVO> materialVOList = service.getList(cri);
        model.addAttribute("materialList", materialVOList);
        model.addAttribute("criteria", cri);
    }
}
