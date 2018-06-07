package br.com.poc.opentracing.salesservice.controller;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;

@FeignClient(value = "customers", url = "${customers.url}")
public interface CustomersApi {
    @PostMapping("/customers")
    void createCustomer();
}
