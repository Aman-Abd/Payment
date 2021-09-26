package com.example.microservice.entities;

public class Payment {

    private int Id;
    private Order order;
    private boolean paid;

    public Payment(Order order, int Id, boolean paid) {
        this.Id = Id;
        this.order = order;
        this.paid = paid;
    }

    public boolean checkPay(double paidAmount){
        return paidAmount == order.getAmount();
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public boolean isPaid() {
        return paid;
    }

    public void setPaid(boolean paid) {
        this.paid = paid;
    }
}
