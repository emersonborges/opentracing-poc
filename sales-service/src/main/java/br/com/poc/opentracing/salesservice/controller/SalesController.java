package br.com.poc.opentracing.salesservice.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class SalesController {

//    private final OrdersApi ordersApi;
    private final CustomersApi customersApi;

    public SalesController(CustomersApi customersApi) {
        this.customersApi = customersApi;
    }

    @PostMapping("/sales")
    public void create() {
        log.info("Create Sale");
        customersApi.createCustomer(CustomerTO.builder().name("bla").fullName("foo").build());
//        ordersApi.create();
    }
}
