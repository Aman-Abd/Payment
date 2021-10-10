package com.example.microservice.entities;

import java.util.Date;
import java.util.List;
import java.util.TimeZone;

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

    public boolean isValid() {
        return valid;
    }

    public void setValid(boolean valid) {
        this.valid = valid;
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getSubscriptionType() {
        return subscriptionType;
    }

    public void setSubscriptionType(String subscriptionType) {
        this.subscriptionType = subscriptionType;
    }
}
