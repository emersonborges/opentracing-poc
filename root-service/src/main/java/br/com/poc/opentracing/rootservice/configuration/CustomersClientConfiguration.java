package br.com.poc.opentracing.rootservice.configuration;

import br.com.poc.opentracing.rootservice.controller.CustomerApi;
import feign.Feign;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CustomersClientConfiguration {

//    @Bean
    public CustomerApi customerClient(@Value("${customer.url}") String customerUrl) {
        return Feign.builder()
                .target(CustomerApi.class, customerUrl);
    }
}
