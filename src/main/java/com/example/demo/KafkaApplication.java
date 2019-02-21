package com.example.demo;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;

import java.util.logging.Logger;

@SpringBootApplication
public class KafkaApplication {
    //Define the logger class for logging purposes
    private static  final Logger LOG = Logger.getLogger("KafkaApplication");

    @Value("${message.topic.name}")
    private String topicName;

    private final KafkaTemplate<String, String>kafkaTemplate;

    @Autowired
    public KafkaApplication(KafkaTemplate<String, String> kafkaTemplate){
        this.kafkaTemplate = kafkaTemplate;
    }

    public static void main(String[] args) {
        SpringApplication.run(KafkaApplication.class, args);
    }

    @Override
    public void run(String... strings){
        kafkaTemplate.send(topicName, "Hello Dennis");
        LOG.info("Received Message to topic: "+topicName);
    }

    @KafkaListener(topics = "my-replicated-topic", groupId= "jcq-group")
    public void listen(String message){
        LOG.info("Received message in JCG group: "+message);
    }

}
