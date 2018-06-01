package br.com.poc.opentracing.rootservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.feign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class RootServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(RootServiceApplication.class, args);
	}
}
