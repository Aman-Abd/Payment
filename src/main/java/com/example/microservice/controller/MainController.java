package com.example.microservice.controller;

import com.example.microservice.entities.Order;
import com.example.microservice.entities.Payment;
import com.example.microservice.repository.PaymentRepository;
import com.example.microservice.services.MainService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
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
    @HystrixCommand(
            fallbackMethod = "getPaymentInfoFallBack",
            threadPoolKey = "getPaymentInfo",
            threadPoolProperties = {
                    @HystrixProperty(name="coreSize", value="100"),
                    @HystrixProperty(name="maxQueueSize", value="50"),
            })
    public Order getPaymentInfo (@PathVariable String id){
        return mainService.GetOrderInfo(Integer.parseInt(id));
    }

    public Order getPaymentInfoFallBack(@PathVariable String id){
        Order order = new Order();
        order.setAmount(0);
        order.setSubscriptionType("Non");
        order.setUserId(0);
        order.setValid(false);
        return order;
    }

    @PostMapping("{id}")
    @ApiOperation(value = "Method to pay for order", response = List.class)
    @HystrixCommand(
            fallbackMethod = "payFallBack",
            threadPoolKey = "pay",
            threadPoolProperties = {
                    @HystrixProperty(name="coreSize", value="100"),
                    @HystrixProperty(name="maxQueueSize", value="50"),
            })
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

    public boolean payFallBack(@PathVariable String id, @RequestBody String amount){
        return false;
    }

}
