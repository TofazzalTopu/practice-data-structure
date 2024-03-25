package com.example.practice.OnlineTest.PolySurance;

import java.util.List;

public class NewOrder {

    public Long orderId;
    public List<String> discounts;
    public List<Item> items;

    public NewOrder(Long orderId, List<String> discounts, List<Item> items) {
        this.orderId = orderId;
        this.discounts = discounts;
        this.items = items;
    }

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public List<String> getDiscounts() {
        return discounts;
    }

    public void setDiscounts(List<String> discounts) {
        this.discounts = discounts;
    }

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }

}
