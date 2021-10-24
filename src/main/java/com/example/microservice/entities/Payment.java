package com.example.microservice.entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name="payments")
@Getter
@Setter
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
}
