package org.juice_project.controller;

import jakarta.servlet.http.HttpSession;
import org.juice_project.domain.CustomerVO;
import org.juice_project.domain.OrdersVO;
import org.juice_project.service.SalesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
public class SalesRestController {

    @Autowired
    private SalesService salesService;

    @GetMapping("/getCustomerInfo")
    public CustomerVO getCustomerInfo(@RequestParam("custId") Long custId) {
        System.out.println("====================");
        CustomerVO customer = salesService.getOneCust(custId);
        System.out.println(customer);
        return customer;
    }
//    @PostMapping("/sales/orderUpdate")
//    public ResponseEntity<String> updateOrder(@RequestParam Long orderId) {
//        System.out.println("주문 업데이트=========================");
//        try {
//            salesService.updateOrder(orderId);
//            return new ResponseEntity<>("주문이 업데이트되었습니다.", HttpStatus.OK);
//        } catch (Exception e) {
//            // 업데이트 작업 중에 예외가 발생하면 오류 응답을 반환합니다.
//            return new ResponseEntity<>("주문 업데이트 중 오류가 발생했습니다.", HttpStatus.INTERNAL_SERVER_ERROR);
//        }
//    }

    @PostMapping("/sales/orderUpdate")
    public ResponseEntity<String> updateOrder(@RequestBody Map<String, Long> requestBody, HttpSession httpSession) {
        Long orderId = requestBody.get("orderId");
        Integer empId1 = (Integer)httpSession.getAttribute("empId");

        Long empId = empId1.longValue();

        System.out.println("주문 업데이트=========================");
        System.out.println(empId);
        System.out.println(orderId);
        try {
            salesService.updateOrder(orderId, empId);
            return new ResponseEntity<>("주문이 업데이트되었습니다.", HttpStatus.OK);
        } catch (Exception e) {
            // 업데이트 작업 중에 예외가 발생하면 오류 응답을 반환합니다.
            return new ResponseEntity<>("주문 업데이트 중 오류가 발생했습니다.", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
