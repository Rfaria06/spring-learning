package ch.raulfaria.eazybank.repository;

import ch.raulfaria.eazybank.model.Customer;
import org.springframework.data.repository.ListCrudRepository;

import java.util.Optional;

public interface CustomerRepository extends ListCrudRepository<Customer, Long> {
    Optional<Customer> findByEmail(String email);
}
