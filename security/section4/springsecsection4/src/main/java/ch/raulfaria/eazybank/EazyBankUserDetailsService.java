package ch.raulfaria.eazybank;

import ch.raulfaria.eazybank.model.Customer;
import ch.raulfaria.eazybank.repository.CustomerRepository;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EazyBankUserDetailsService implements UserDetailsService {
    
    private final CustomerRepository repository;

    public EazyBankUserDetailsService(final CustomerRepository repository) {
        this.repository = repository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        final Customer customer = repository
                .findByEmail(username)
                .orElseThrow(() -> new UsernameNotFoundException("User details for not found for the user: " + username));
        final List<GrantedAuthority> authorities = List.of(new SimpleGrantedAuthority(customer.getRole()));
        
        return new User(customer.getEmail(), customer.getPassword(), authorities);
    }
}
