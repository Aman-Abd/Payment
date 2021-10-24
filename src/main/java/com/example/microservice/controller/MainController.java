package com.example.microservice.controller;

import com.example.microservice.entities.Order;
import com.example.microservice.entities.Payment;
import com.example.microservice.repository.PaymentRepository;
import com.example.microservice.services.MainService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("payment")
@Api(value = "Payment Controller class", description = "This class allows to interact with Payment object")
public class MainController {
    @Autowired
    private PaymentRepository paymentRepository;

    @Autowired
    MainService mainService;

    @GetMapping("{id}")
    @ApiOperation(value = "Method to get payment info", response = List.class)
    public Order getPaymentInfo (@PathVariable String id){
        return mainService.GetOrderInfo(Integer.parseInt(id));
    }

    @PostMapping("{id}")
    @ApiOperation(value = "Method to pay for order", response = List.class)
    public boolean pay(@PathVariable String id, @RequestBody String amount){
        try{
            Order order = mainService.GetOrderInfo(Integer.parseInt(id));

            Payment payment = new Payment(order.getId(), false);
            if(order.getAmount() == Integer.parseInt(amount)){
                payment.setPaid(true);
                paymentRepository.save(payment);
                return true;
            }
            return false;

        }catch (Exception exception){
            return false;
        }
    }
}
