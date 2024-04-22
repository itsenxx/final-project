package org.juice_project.controller;

import org.juice_project.domain.CustomerVO;
import org.juice_project.domain.OrdersVO;
import org.juice_project.service.SalesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/sales")
public class SalesController {

    @Autowired
    public SalesService salesService;

    @GetMapping("/management")
    public String sales(Model model) {
        List<CustomerVO> customerList = salesService.getCustList();
        model.addAttribute("customers", customerList);
        return "sales/management";
    }

    @GetMapping("/sample")
    public String sales() {
        return "sales/sample";
    }

    @PostMapping("/management")
    public String handleManagementRequest(@RequestParam("address") String address, Model model) {
        model.addAttribute("address", address);
        return "sales/management";
    }

    @PostMapping("/insertCustomer")
    public String register(CustomerVO customerVO, RedirectAttributes rttr) {
        salesService.putCustomer(customerVO);
        rttr.addFlashAttribute("result", customerVO.getCustId());

        return "redirect:management";
    }

    @GetMapping("/orders")
    public String orders(Model model) {
        List<OrdersVO> orderList = salesService.getOrderList();
        model.addAttribute("orders", orderList);
        return "sales/orders";
    }

    @GetMapping("/detailOrder")
    public ResponseEntity<?> detailOrder(@RequestParam("orderId") Long orderId) {
        System.out.println("qqqqqqqqqqqqqqqqqqqqqqqqqqqqqqq");
        List<OrdersVO> ordersVOList = (List<OrdersVO>) salesService.getOneOrder(orderId);
        return new ResponseEntity<>(ordersVOList, HttpStatus.OK);
    }



}