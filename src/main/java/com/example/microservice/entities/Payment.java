package com.example.microservice.entities;

import javax.persistence.*;

@Entity
@Table(name="payments")
public class Payment {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private int Id;
    private int orderId;
    private boolean paid;

    public Payment() {
    }

    public Payment(int orderId, boolean paid) {
        this.orderId = orderId;
        this.paid = paid;
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public int getOrder() {
        return orderId;
    }

    public void setOrder(int orderId) {
        this.orderId = orderId;
    }

    public boolean isPaid() {
        return paid;
    }

    public void setPaid(boolean paid) {
        this.paid = paid;
    }
}
