package br.com.poc.opentracing.rootservice.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RootController {

    private final OrdersApi ordersApi;

    public RootController(OrdersApi ordersApi) {
        this.ordersApi = ordersApi;
    }

    @PostMapping("/start")
    public void start() {
        ordersApi.create();
    }
}
