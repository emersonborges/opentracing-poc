package br.com.poc.opentracing.rootservice.controller;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;

@FeignClient(value = "customers", url = "${customers.url}")
public interface CustomerApi {
    @PostMapping("/customers")
    void create();
}
