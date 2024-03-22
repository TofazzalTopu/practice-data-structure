package com.example.practice.OnlineTest.PolySurance;

import java.util.List;

public class Order {

    public Long orderId;
    public String discount;
    public List<Item> items;

    public Order(Long orderId, String discount, List<Item> items) {
        this.orderId = orderId;
        this.discount = discount;
        this.items = items;
    }

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public String getDiscount() {
        return discount;
    }

    public void setDiscount(String discount) {
        this.discount = discount;
    }

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }

}
