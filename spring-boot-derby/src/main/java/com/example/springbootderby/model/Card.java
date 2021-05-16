package com.example.springbootderby.model;
import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity(name="CARD_DB")
@Data
//@AllArgsConstructor
@NoArgsConstructor
public class Card {

    public Card(String cardNumber, String name, int limit, Double balance) {
        this.cardNumber = cardNumber;
        this.name = name;
        this.limit = limit;
        this.balance = balance;
    }

    public String getCardNumber() {
        return cardNumber;
    }


    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getLimit() {
        return limit;
    }

    public void setLimit(int limit) {
        this.limit = limit;
    }

    @Id
    private String cardNumber;

    private String name;

    private int limit;



    public Double getBalance() {
        return balance;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
    }

    private Double balance;

}
