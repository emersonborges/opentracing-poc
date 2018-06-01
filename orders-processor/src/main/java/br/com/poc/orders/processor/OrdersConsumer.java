package br.com.poc.orders.processor;

import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class OrdersConsumer {

    private final CustomerApi customerApi;

    public OrdersConsumer(CustomerApi customerApi) {
        this.customerApi = customerApi;
    }

    @KafkaListener(topics = "${kafka.topic}")
    public void consume(String message) throws InterruptedException {
        Thread.sleep(2000);
        log.info("Orders processed: {}", message);
        customerApi.create();
    }
}
