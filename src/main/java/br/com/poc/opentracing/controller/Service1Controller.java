package br.com.poc.opentracing.controller;

import br.com.poc.opentracing.model.Customer;
import br.com.poc.opentracing.repository.CustomerRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class Service1Controller {

    private CustomerRepository customerRepository;

    public Service1Controller(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @GetMapping("/action")
    public void action() {
        log.debug("Action from service1");
        customerRepository.save(Customer.builder().name("Customer").build());
    }
}
