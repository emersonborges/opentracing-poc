package br.com.poc.opentracing.salesservice.configuration;

import br.com.poc.opentracing.salesservice.TracerContextFeignDecorator;
import br.com.poc.opentracing.salesservice.controller.CustomersApi;
import com.fasterxml.jackson.databind.ObjectMapper;
import feign.Client;
import feign.Feign;
import feign.jackson.JacksonDecoder;
import feign.jackson.JacksonEncoder;
import feign.okhttp.OkHttpClient;
import feign.opentracing.FeignSpanDecorator;
import feign.opentracing.TracingClient;
import io.opentracing.Tracer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.netflix.feign.support.SpringMvcContract;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;
import java.util.List;

@Configuration
public class TracerContextFeignConfiguration {

    @Bean
    public CustomersApi customerClient(Tracer tracer, @Value("${customers.url}") String customersUrl, ObjectMapper objectMapper) {
        return Feign.builder()
                .client(tracingClient(new OkHttpClient(), tracer, objectMapper))
                .encoder(new JacksonEncoder())
                .decoder(new JacksonDecoder())
                .contract(new SpringMvcContract())
                .target(CustomersApi.class, customersUrl);
    }

    @Bean
    public TracingClient tracingClient(Client client, Tracer tracer, ObjectMapper objectMapper) {
        List<FeignSpanDecorator> spanDecorators = Arrays.asList(new TracerContextFeignDecorator(tracer, objectMapper), new FeignSpanDecorator.StandardTags());
        return new TracingClient(client, tracer, spanDecorators);
    }
}
