package org.juice_project.controller;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;
import org.springframework.ui.Model;
import org.juice_project.domain.SaleVO;
import org.juice_project.service.SaleListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import java.util.List;

import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


@Controller
@Log4j
@RequestMapping("/develop")

public class SaleListController {
    private SaleListService Service;
    @Autowired
    public SaleListController(SaleListService salelistService) {
        this.Service = salelistService;
    }

    @GetMapping("/managements")
    public void managements (@RequestParam(defaultValue = "1") int page,
                             Model model) {
        int limit = 10;
        int offset = (page - 1) * limit;

        List<SaleVO> saleVOList = Service.getPaginatedSaleList(offset, limit);
        int totalRecords = Service.getSaleCount();
        int totalPages = (int) Math.ceil((double) totalRecords / limit);

        model.addAttribute("saleList", saleVOList);
        model.addAttribute("totalPages", totalPages);
        model.addAttribute("currentPage", page);

    }

    @GetMapping("/sum")
    public void sale (Model model) {

        List<SaleVO> saleVOList = Service.SaleList();
        model.addAttribute("sumList", saleVOList);
    }

}

