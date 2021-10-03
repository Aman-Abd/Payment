package com.example.microservice.services;

import com.example.microservice.entities.Order;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class MainService {
    private final RestTemplate restTemplate;

    public MainService(RestTemplateBuilder restTemplateBuilder) {
        this.restTemplate = restTemplateBuilder.build();
    }

    public Order GetOrderInfo(int id){
        String url = "http://subscription-service/orders/" + id;
        return this.restTemplate.getForObject(url, Order.class);
    }
}
