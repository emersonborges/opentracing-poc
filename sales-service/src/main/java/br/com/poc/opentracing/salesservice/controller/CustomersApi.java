package br.com.poc.opentracing.salesservice.controller;

import br.com.poc.opentracing.salesservice.configuration.TracerContextFeignConfiguration;
import com.fasterxml.jackson.annotation.JsonAutoDetect;
import feign.RequestLine;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import static com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility.*;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;
import static org.springframework.web.bind.annotation.RequestMethod.GET;

//@FeignClient(value = "customers", url = "${customers.url}", configuration = TracerContextFeignConfiguration.class)
public interface CustomersApi {
    @PostMapping(value = "/customers", consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
    void createCustomer(CustomerTO customerTO);
}

