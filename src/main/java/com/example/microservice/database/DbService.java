package com.example.microservice.database;

import com.example.microservice.entities.Order;
import com.example.microservice.entities.Payment;

import java.util.List;

public class DbService {
    private DataBase dataBase = DataBase.getDataBase();

    public boolean addPayment(Payment payment){
        try{
            dataBase.getPayments().add(payment);
            return true;
        }catch (Exception exception){
            return false;
        }
    }

    public List<Payment> getPayments(){
        return dataBase.getPayments();
    }

    public Payment getPaymentById(int id){
        return dataBase.getPayments().stream().filter(payment -> payment.getId() == id).findFirst().orElseThrow();
    }

    public boolean deletePayment(int id){
        try {
            dataBase.getPayments().remove(getPaymentById(id));
            return true;
        }catch (Exception exception){
            return false;
        }
    }
}
