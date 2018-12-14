package com.ocloudwork.boot.demo.controller;

import java.time.ZoneId;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ocloudwork.boot.demo.dto.Order;

@Controller
public class OrderController {
	@PostMapping("/postData")
    public @ResponseBody Map<String, Object> postData(String no, int quantity, String date) {
        System.out.println("no:" + no);
        System.out.println("quantity:" + quantity);
        System.out.println("date:" + date);
        Map<String, Object> map = new HashMap<>();
        map.put("msg", "ok");
        map.put("quantity", quantity);
        map.put("no", no);
        map.put("date", date);
        return map;
    }

    @PostMapping("/postJson")
    public @ResponseBody Map<String, Object> postJson(@RequestBody Order order) {
        System.out.println("order no:" + order.no);
        System.out.println("order quantity:" + order.quantity);
        System.out.println("order date:" + order.date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate());
        Map<String, Object> map = new HashMap<>();
        map.put("msg", "ok");
        map.put("value", order);
        return map;
    }
}
