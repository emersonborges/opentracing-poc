package br.com.poc.opentracing.rootservice.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RootController {

    private final CustomerApi customerApi;

    public RootController(CustomerApi customerApi) {
        this.customerApi = customerApi;
    }

    @PostMapping("/start")
    public void start() {
        customerApi.create();
    }
}
