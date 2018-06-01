package br.com.poc.opentracing.customer.repository;


import br.com.poc.opentracing.customer.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, String> {
}
