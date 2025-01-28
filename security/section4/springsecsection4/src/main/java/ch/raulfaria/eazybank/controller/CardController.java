package ch.raulfaria.eazybank.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/cards")
public class CardController {

    @GetMapping
    public ResponseEntity<String> getCards() {
        return ResponseEntity.ok("Here are all your cards");
    }
}
