package com.example.microservice.services;

import com.example.microservice.entities.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class MainService {
    @Autowired
    private  RestTemplate restTemplate;

    public MainService() {
    }

    public Order GetOrderInfo(int id){
        String url = "http://subscription-service/orders/" + id;
        return this.restTemplate.getForObject(url, Order.class);
    }
}
