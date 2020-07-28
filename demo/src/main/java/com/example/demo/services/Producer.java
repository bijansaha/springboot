package com.example.demo.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import com.example.demo.model.Employee;
@Service
public class Producer {
private static final Logger logger = LoggerFactory.getLogger(Producer.class);

@Value("${emp.topic.name}")
private String TOPIC;

@Autowired
private KafkaTemplate<String,Employee> kafkaTemplate;

public void sendMessage(Employee message){
logger.info(String.format("$$ -> Producing message --> %s",message));
this.kafkaTemplate.send(TOPIC,message);
}

}
