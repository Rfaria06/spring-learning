package ch.raulfaria.eazybank.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/balance")
public class BalanceController {

    @GetMapping
    public ResponseEntity<String> getBalanceDetails() {
        return ResponseEntity.ok("Here are the balance details");
    }
}
