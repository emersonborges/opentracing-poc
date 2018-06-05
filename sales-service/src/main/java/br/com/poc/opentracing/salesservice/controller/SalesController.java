package br.com.poc.opentracing.salesservice.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SalesController {

    private final OrdersApi ordersApi;
    private final CustomersApi customersApi;

    public SalesController(OrdersApi ordersApi, CustomersApi customersApi) {
        this.ordersApi = ordersApi;
        this.customersApi = customersApi;
    }

    @PostMapping("/sales")
    public void create() {
        customersApi.createOffer();
        ordersApi.create();
    }
}
