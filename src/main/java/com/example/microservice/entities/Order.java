package com.example.microservice.entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.List;
import java.util.TimeZone;

@Getter
@Setter
public class Order {

    private int Id;
    private int amount;
    private int userId;
    private boolean valid;
    private String subscriptionType;

    public Order(){}
    public Order(int id, int amount, int userId, boolean valid, String subscriptionType) {
        Id = id;
        this.amount = amount;
        this.userId = userId;
        this.valid = valid;
        this.subscriptionType = subscriptionType;
    }
}
