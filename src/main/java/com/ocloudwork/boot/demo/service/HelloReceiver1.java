package com.ocloudwork.boot.demo.service;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
@RabbitListener(queues = "hello")
public class HelloReceiver1 {
	Logger logger = LoggerFactory.getLogger(getClass());
    @RabbitHandler
    public void process(String msg) {
    	logger.info("Receiver1  : " + msg);
    }

}
