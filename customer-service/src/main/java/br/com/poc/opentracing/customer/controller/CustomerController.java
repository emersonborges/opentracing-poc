package br.com.poc.opentracing.customer.controller;

import br.com.poc.opentracing.customer.model.Customer;
import br.com.poc.opentracing.customer.repository.CustomerRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class CustomerController {

    private CustomerRepository customerRepository;

    public CustomerController(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @PostMapping("/customers")
    public void create() {
        log.debug("Create customer from customer-service");
        Customer customer = Customer.builder().name("Customer").build();
        customerRepository.save(customer);
    }
}
