package com.example.microservice.controller;

import com.example.microservice.database.DbService;
import com.example.microservice.entities.Order;
import com.example.microservice.entities.Payment;
import com.example.microservice.services.MainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("payment")
public class MainController {
    DbService dbService = new DbService();
    @Autowired
    MainService mainService;

    @GetMapping("{id}")
    public Order getPaymentInfo (@PathVariable String id){
        MainService mainService = new MainService(new RestTemplateBuilder());
        return mainService.GetOrderInfo(Integer.parseInt(id));
    }

    @PostMapping("{id}")
    public boolean pay(@PathVariable String id, @RequestBody String amount){
        try{
            Order order = mainService.GetOrderInfo(Integer.parseInt(id));

            Payment payment = new Payment(order,1, false);
            if(payment.checkPay(Integer.parseInt(amount))){
                payment.setPaid(true);
                dbService.addPayment(payment);
                return true;
            }
            return false;

        }catch (Exception exception){
            return false;
        }
    }
}
