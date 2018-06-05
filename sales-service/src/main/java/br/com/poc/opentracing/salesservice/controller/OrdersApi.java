package br.com.poc.opentracing.salesservice.controller;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;

@FeignClient(value = "orders", url = "${orders.url}")
public interface OrdersApi {
    @PostMapping("/orders")
    void create();
}
