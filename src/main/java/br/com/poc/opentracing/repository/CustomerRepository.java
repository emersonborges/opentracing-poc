package br.com.poc.opentracing.repository;

import br.com.poc.opentracing.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, String> {
}
