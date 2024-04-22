package org.juice_project.controller;

import lombok.extern.log4j.Log4j;

import org.juice_project.domain.BomVO;
import org.juice_project.domain.BuyVO;
import org.juice_project.domain.Criteria;
import org.juice_project.service.BuyService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;
@Service
@Log4j
@Controller
@RequestMapping("/develop")
public class BuyController {

    private final BuyService buyService;

    /**
     * 게시물 목록 조회
     * @param model
     * @return
     */
    @GetMapping("/buy")
    public void list(Model model) {
        List<BuyVO> buyVOList = buyService.getList();
        model.addAttribute("buyList", buyVOList);
    }
    @GetMapping("/buyreg")
    public void register()
    {



    }

    /**
     * 게시물 등록
     * @param buy
     * @param rttr
     * @return
     */

    @PostMapping("/buyreg")
    public String register(BuyVO buy, RedirectAttributes rttr) {
        log.info("등록: " + buy);

        buyService.register(buy);	// 실제 게시판 글 입력
        rttr.addFlashAttribute("result", buy.getMaterId());

        return "redirect:/develop/buy";
    }

    @PostMapping("/modifyBuy")
    public String modify(BuyVO vo, RedirectAttributes rttr) {
        log.info("modify:" + vo);

        if (buyService.modify(vo)) {
            rttr.addFlashAttribute("result", "success");
        }
        return "redirect:/develop/buy";
    }

    @GetMapping({"/getBuy", "/modifyBuy"})
    public void getBuy(
            @RequestParam("Mater_id") int Mater_id
            , Model model
    ) {
        log.info("/get or modify");
        model.addAttribute("buy", buyService.get(Mater_id));
    }

    @PostMapping("/removeBuy")
    public String removeBuy(@RequestParam("Mater_id") String Mater_id, RedirectAttributes rttr) {
        log.info("remove..." + Mater_id);
        if (buyService.remove(Mater_id)) {
            rttr.addFlashAttribute("result", "success");
        }
        return "redirect:/develop/buy";
    }


    @Autowired
    public BuyController(BuyService buyService) {
        this.buyService = buyService;
    }

//    @GetMapping("/buy1")
//    public  String buy1Page(){
//        return "buy1"; //
//    }

//    @PostMapping("/develop/buyreg")
//    public String redirectToHome(Model model) {
//        return "redirect:/buy";
//    }

}