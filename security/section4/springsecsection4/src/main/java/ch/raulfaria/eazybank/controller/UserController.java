package ch.raulfaria.eazybank.controller;

import ch.raulfaria.eazybank.model.Customer;
import ch.raulfaria.eazybank.repository.CustomerRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    
    private final CustomerRepository repository;
    private final PasswordEncoder passwordEncoder;

    public UserController(final CustomerRepository repository, final PasswordEncoder passwordEncoder) {
        this.repository = repository;
        this.passwordEncoder = passwordEncoder;
    }

    @PostMapping("/register")
    public ResponseEntity<String> registerUser(final @RequestBody Customer customer) {
        try {
            final String hashedPassword = passwordEncoder.encode(customer.getPassword());
            customer.setPassword(hashedPassword);
            
            final Customer persistentCustomer = repository.save(customer);
            
            if (!(persistentCustomer.getId() > 0)) {
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Registration failed.");
            }
            
            return ResponseEntity.status(HttpStatus.CREATED).body("Successfully registered.");
        } catch (Exception exception) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("An exception ocurred: " + exception.getMessage());
        }
    }
}
