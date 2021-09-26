package com.example.microservice.database;

import com.example.microservice.entities.Order;
import com.example.microservice.entities.Payment;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class DataBase {
    static private DataBase dataBase;

    private List<Payment> payments = new ArrayList<Payment>();


    private DataBase() {
    }

    static public DataBase getDataBase(){
        if (dataBase == null)
            dataBase = new DataBase();
        return dataBase;
    }
    public List<Payment> getPayments() {
        return payments;
    }
}
