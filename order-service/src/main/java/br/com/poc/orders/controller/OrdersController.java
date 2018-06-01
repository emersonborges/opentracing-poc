package br.com.poc.orders.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrdersController {

    private final KafkaTemplate<String, String> kafkaTemplate;
    private final String topic;

    public OrdersController(@Value("${kafka.topic}") String topic, KafkaTemplate<String, String> kafkaTemplate) {
        this.topic = topic;
        this.kafkaTemplate = kafkaTemplate;
    }

    @PostMapping("/orders")
    public void create() {
        kafkaTemplate.send(topic, "OrderCreated");
    }
}
