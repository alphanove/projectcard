package com.example.springbootderby.controller;
import com.example.springbootderby.dao.CardRepository;
import com.example.springbootderby.model.ApiError;
import com.example.springbootderby.model.ApiStatus;
import com.example.springbootderby.model.Card;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.example.springbootderby.service.cardService.isValidCreditCardNumber;

@RestController
@RequestMapping("/cardapi/v1")
public class CardController {

    @Autowired
    private CardRepository repository;
    //@PostMapping(path="/addCard",produces= MediaType.APPLICATION_JSON_VALUE)
    @RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> saveCard(@RequestBody Card card) throws Exception {

        if (isValidCreditCardNumber(card.getCardNumber())) {
            card.setBalance(00.00);
            repository.save(card);
            ApiStatus sucesss = new ApiStatus("200", "Card Added Successfully");
            return ResponseEntity.status(HttpStatus.OK).body(sucesss);

        } else {
            ApiError error = new ApiError("400", card.getCardNumber() + " is not valid as per luhn algorithm or card number length is greater than 19");
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);
            //throw new ResponseStatusException(HttpStatus.BAD_REQUEST, error.toString());
        }
    }

        //@GetMapping(path="/getAllCards",produces= MediaType.APPLICATION_JSON_VALUE)
        @RequestMapping(method = RequestMethod.GET, consumes = MediaType.APPLICATION_JSON_VALUE)
        public ResponseEntity<List<Card>> getAllCards() {
            List<Card> cards = (List<Card>) repository.findAll();
            return new ResponseEntity<>(cards, HttpStatus.OK);
    }

}