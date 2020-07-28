package com.example.demo.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import com.example.demo.model.Employee;

@Service
public class Consumer {
private final Logger logger = LoggerFactory.getLogger(Consumer.class);

@KafkaListener(topics = "${emp.topic.name}", groupId = "group_id")
public void consume(String message){
logger.info(String.format("$$ -> Consumed Message -> %s",message));
}

}