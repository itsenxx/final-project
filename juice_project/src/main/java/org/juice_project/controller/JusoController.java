package org.juice_project.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.juice_project.domain.JusoCallbackData;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

@Controller
public class JusoController {
    @GetMapping("/sales/jusoPopup")
    public String showJusoPopupPage() {
        return "sales/jusoPopup"; // 주소 검색을 위한 JSP 파일의 이름을 반환합니다.
    }


    @PostMapping("/sales/jusoPopup")
    public String handleJusoCallback(JusoCallbackData jusoCallbackData, Model model) {
        // jusoCallbackData를 사용하여 주소 검색 결과를 처리하는 로직을 작성합니다.
        System.out.println("도로명 주소: " + jusoCallbackData.getRoadFullAddr());
        System.out.println("상세 주소: " + jusoCallbackData.getAddrDetail());

        model.addAttribute("RoadFullAddr", jusoCallbackData.getRoadFullAddr());
        model.addAttribute("AddrDetail", jusoCallbackData.getAddrDetail());

     return "sales/jusoPopup";
    }


//    @PostMapping("/sales/jusoPopup")
//    @ResponseBody
//    public JusoCallbackData handleJusoCallback(JusoCallbackData jusoCallbackData) throws JsonProcessingException {
//        // jusoCallbackData를 사용하여 주소 검색 결과를 처리하는 로직을 작성합니다.
//        System.out.println("도로명 주소: " + jusoCallbackData.getRoadFullAddr());
//        System.out.println("상세 주소: " + jusoCallbackData.getAddrDetail());
//
//        return jusoCallbackData;
//    }


}