package br.com.poc.orders.processor;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;

@FeignClient(value = "customers", url = "${customers.url}")
public interface CustomerApi {
    @PostMapping("/customers/offers")
    void createOffer();
}
