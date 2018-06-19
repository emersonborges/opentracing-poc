package br.com.poc.opentracing.salesservice.controller;

import br.com.poc.opentracing.salesservice.configuration.TracerContextFeignConfiguration;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;

//@FeignClient(value = "orders", url = "${orders.url}", configuration = TracerContextFeignConfiguration.class)
public interface OrdersApi {
    @PostMapping("/orders")
    void create();
}
