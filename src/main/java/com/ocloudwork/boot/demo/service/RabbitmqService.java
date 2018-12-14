package com.ocloudwork.boot.demo.service;

import java.util.Date;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RabbitmqService {

	 @Autowired
	 private AmqpTemplate rabbitTemplate;

	 public void send(String msg) {
	    String sendMsg = msg + new Date();
	    System.out.println("Sender1 : " + sendMsg);
	    //springboot完美的支持对象的发送和接收，不需要格外的配置,对象需要实现序列化接口
	    this.rabbitTemplate.convertAndSend("hello", sendMsg);
	 }
}
