package br.com.poc.orders.processor;

import io.opentracing.Scope;
import io.opentracing.SpanContext;
import io.opentracing.Tracer;
import io.opentracing.contrib.kafka.TracingKafkaUtils;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class OrdersConsumer {

    private final CustomerApi customerApi;
    private final Tracer tracer;

    public OrdersConsumer(CustomerApi customerApi, Tracer tracer) {
        this.customerApi = customerApi;
        this.tracer = tracer;
    }

    @KafkaListener(topics = "${kafka.topic}")
    public void consume(ConsumerRecord<String, String> message) throws InterruptedException {
        SpanContext context = TracingKafkaUtils.extractSpanContext(message.headers(), tracer);
        try (Scope scope = tracer.buildSpan("process").asChildOf(context).startActive(true)) {
            Thread.sleep(2000);
            log.info("Orders processed: {}", message);
            customerApi.createOffer();
        }
    }
}
