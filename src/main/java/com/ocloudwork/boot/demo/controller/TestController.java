package com.ocloudwork.boot.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ocloudwork.boot.demo.annotation.RuntimeLog;
import com.ocloudwork.boot.demo.service.RabbitmqService;

@RestController
@RequestMapping("/test")
public class TestController {
	
	@Autowired
	private RabbitmqService rabbitmqService;

	@RuntimeLog
	@RequestMapping(path = "sendMsg", method = RequestMethod.GET)
	public String route(String msg) {
		rabbitmqService.send(msg);
		return "ok";
	}
}
