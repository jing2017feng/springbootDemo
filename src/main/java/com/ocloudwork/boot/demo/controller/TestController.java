package com.ocloudwork.boot.demo.controller;

import java.util.concurrent.CompletableFuture;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ocloudwork.boot.demo.annotation.RuntimeLog;
import com.ocloudwork.boot.demo.service.RabbitmqService;
import com.ocloudwork.boot.demo.utils.OpenOffice2PDF;

@RestController
@RequestMapping("/test")
public class TestController {
	
	@Autowired
	private RabbitmqService rabbitmqService;
	@Autowired
	private OpenOffice2PDF openOffice2PDF;

	@RuntimeLog
	@RequestMapping(path = "sendMsg", method = RequestMethod.GET)
	public String route(String msg) {
		rabbitmqService.send(msg);
		return "ok";
	}
	
	@RequestMapping(path = "openOffice2PDF", method = RequestMethod.GET)
	public String openOffice2PDF(String msg) {
		int i=0;
		CompletableFuture<Boolean> result1 = openOffice2PDF.openOffice2Pdf("D:/tmp/Openstack基础知识"+(++i)+".ppt","D:/tmp/Openstack基础知识"+ i +".pdf",1);
		CompletableFuture<Boolean> result2 = openOffice2PDF.openOffice2Pdf("D:/tmp/Openstack基础知识"+(++i)+".ppt","D:/tmp/Openstack基础知识"+ i +".pdf",2);
		CompletableFuture<Boolean> result3 = openOffice2PDF.openOffice2Pdf("D:/tmp/Openstack基础知识"+(++i)+".ppt","D:/tmp/Openstack基础知识"+ i +".pdf",3);
		CompletableFuture<Boolean> result4 = openOffice2PDF.openOffice2Pdf("D:/tmp/Openstack基础知识"+(++i)+".ppt","D:/tmp/Openstack基础知识"+ i +".pdf",4);
		CompletableFuture<Boolean> result5 = openOffice2PDF.openOffice2Pdf("D:/tmp/Openstack基础知识"+(++i)+".ppt","D:/tmp/Openstack基础知识"+ i +".pdf",5);
		CompletableFuture<Boolean> result6 = openOffice2PDF.openOffice2Pdf("D:/tmp/Openstack基础知识"+(++i)+".ppt","D:/tmp/Openstack基础知识"+ i +".pdf",6);
		CompletableFuture<Boolean> result7 = openOffice2PDF.openOffice2Pdf("D:/tmp/Openstack基础知识"+(++i)+".ppt","D:/tmp/Openstack基础知识"+ i +".pdf",7);
		CompletableFuture<Boolean> result8 = openOffice2PDF.openOffice2Pdf("D:/tmp/Openstack基础知识"+(++i)+".ppt","D:/tmp/Openstack基础知识"+ i +".pdf",8);
		CompletableFuture<Boolean> result9 = openOffice2PDF.openOffice2Pdf("D:/tmp/Openstack基础知识"+(++i)+".ppt","D:/tmp/Openstack基础知识"+ i +".pdf",9);
		// Wait until they are all done
		//CompletableFuture.allOf(result1, result2,result3,result4,result5,result6,result7,result8,result9).join();
		return "ok";
	}
}
