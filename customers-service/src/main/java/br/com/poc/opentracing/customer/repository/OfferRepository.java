package br.com.poc.opentracing.customer.repository;


import br.com.poc.opentracing.customer.model.Offer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OfferRepository extends JpaRepository<Offer, String> {
}
