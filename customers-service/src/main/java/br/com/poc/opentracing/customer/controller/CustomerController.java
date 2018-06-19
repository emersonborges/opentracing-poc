package br.com.poc.opentracing.customer.controller;

import br.com.poc.opentracing.customer.model.Customer;
import br.com.poc.opentracing.customer.model.Offer;
import br.com.poc.opentracing.customer.repository.CustomerRepository;
import br.com.poc.opentracing.customer.repository.OfferRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class CustomerController {

    private CustomerRepository customerRepository;
    private OfferRepository offerRepository;

    public CustomerController(CustomerRepository customerRepository, OfferRepository offerRepository) {
        this.customerRepository = customerRepository;
        this.offerRepository = offerRepository;
    }

    @PostMapping("/customers")
    public void create() {
        log.debug("Create customer from customers-service");
        Customer customer = Customer.builder()
                .name("Customer")
                .build();
        customerRepository.save(customer);
    }

    @PostMapping("/customers/offers")
    public void createOffer(String customerId) {
        log.debug("Create offer from customers-service");
        Customer customer = customerRepository.findAll().get(0);
        Offer offer = Offer.builder()
                .name("Offer")
                .customer(customer)
                .build();
        offerRepository.save(offer);
    }

    @GetMapping("/oi")
    public String oi() {
        return "OI";
    }
}
