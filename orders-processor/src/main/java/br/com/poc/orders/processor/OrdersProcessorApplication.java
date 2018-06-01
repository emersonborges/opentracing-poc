package br.com.poc.orders.processor;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.feign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class OrdersProcessorApplication {

	public static void main(String[] args) {
		SpringApplication.run(OrdersProcessorApplication.class, args);
	}
}
