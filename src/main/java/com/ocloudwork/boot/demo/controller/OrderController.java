package com.ocloudwork.boot.demo.controller;

import java.time.ZoneId;
import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ocloudwork.boot.demo.dto.Order;

@Controller
public class OrderController {
	Logger logger = LoggerFactory.getLogger(getClass());
	
	@PostMapping("/postData")
    public @ResponseBody Map<String, Object> postData(String no, int quantity, String date) {
		logger.info("no:" + no);
		logger.info("quantity:" + quantity);
		logger.info("date:" + date);
        Map<String, Object> map = new HashMap<>();
        map.put("msg", "ok");
        map.put("quantity", quantity);
        map.put("no", no);
        map.put("date", date);
        return map;
    }

    @PostMapping("/postJson")
    public @ResponseBody Map<String, Object> postJson(@RequestBody Order order) {
    	logger.info("order no:" + order.getNo());
    	logger.info("order quantity:" + order.getQuantity());
    	logger.info("order date:" + order.getDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDate());
        Map<String, Object> map = new HashMap<>();
        map.put("msg", "ok");
        map.put("value", order);
        return map;
    }
}
