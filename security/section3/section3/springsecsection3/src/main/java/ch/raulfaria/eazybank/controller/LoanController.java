package ch.raulfaria.eazybank.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/loans")
public class LoanController {

    @GetMapping
    public ResponseEntity<String> getLoans() {
        return ResponseEntity.ok("Here are all your loans");
    }
}
