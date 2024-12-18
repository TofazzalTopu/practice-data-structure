package com.example.practice.datastructure.OnlineTest.PolySurance;

import java.util.*;
import java.util.concurrent.atomic.AtomicReference;
import java.util.function.UnaryOperator;

public class PolySuranceTestPartOne {

    public static void main(String[] args) {
        Map<String, Double> discounts = new HashMap<>();
        discounts.put("SALE10", 0.1);
        discounts.put("SALE20", 0.2);
        discounts.put("SALE30", 0.3);

        Map<String, Double> products = new HashMap<>();
        products.put("1001", 14.99);
        products.put("1002", 156.99);
        products.put("1003", 1099.99);
        products.put("1004", 64.99);

        Order orderOne = new Order(1L, "SALE10", Arrays.asList(new Item("1001", 3), new Item("1004", 1)));
        Order orderTwo = new Order(2L, null, Arrays.asList(new Item("1003", 1)));
        Order orderThree = new Order(3L, "SALE30", Arrays.asList(new Item("1003", 1), new Item("1001", 4), new Item("1002", 2)));
        Order orderFour = new Order(4L, "SALE10", Arrays.asList(new Item("1001", 7)));
        Order orderFive = new Order(5L, "SALE20", Arrays.asList(new Item("1003", 1)));

        List<Order> orderList = new ArrayList<>(Arrays.asList(orderOne, orderTwo, orderThree, orderFour, orderFive));
        AtomicReference<Double> totalSalesWithoutDiscount = new AtomicReference<>(0.0);
        AtomicReference<Double> totalSalesAfterDiscount = new AtomicReference<>(0.0);
        Map<Long, Double> orderWiseTotalDiscountPercentage = new HashMap<>();
        Map<Long, Double> orderWiseTotalDiscount = new HashMap<>();

        orderList.forEach(order -> {
            order.getItems().stream().mapToDouble(e -> (products.get(e.getSku()) * e.getQuantity()))
                    .<UnaryOperator<Double>>mapToObj(v -> v1 -> (double) (v1 + v))
                    .forEach(totalSalesWithoutDiscount::updateAndGet);

            order.getItems()
                    .stream()
                    .mapToDouble(e -> (products.get(e.getSku()) * e.getQuantity()) - (discounts.get(order.getDiscount()) != null ?
                            ((products.get(e.getSku()) * e.getQuantity()) * discounts.get(order.getDiscount())) : 0))
                    .<UnaryOperator<Double>>mapToObj(v -> v1 -> (double) (v1 + v))
                    .forEach(totalSalesAfterDiscount::updateAndGet);

            double orderWiseDiscount = 0.0;
            for (Item item : order.getItems()) {
                orderWiseDiscount += (discounts.get(order.getDiscount()) != null ?
                        ((products.get(item.getSku()) * item.getQuantity()) * discounts.get(order.getDiscount())) : 0);
            }
            orderWiseTotalDiscount.put(order.getOrderId(), orderWiseDiscount);
        });

        double totalAmountOfLossViaDiscount = totalSalesWithoutDiscount.get() - totalSalesAfterDiscount.get();
        orderWiseTotalDiscount.forEach((key, value) -> orderWiseTotalDiscountPercentage.put(key, (value * 100) / totalAmountOfLossViaDiscount));

        double averageDiscountPerCustomerAsPercentage = (orderWiseTotalDiscountPercentage.values().stream().mapToDouble(v -> v).sum() / orderList.size());

        Map<String, Object> result = new LinkedHashMap<>();
        result.put("totalSalesWithoutDiscount:", totalSalesWithoutDiscount);
        result.put("totalSalesAfterDiscount:", totalSalesAfterDiscount);
        result.put("totalAmountOfLossViaDiscount:", totalAmountOfLossViaDiscount);
        result.put("averageDiscountPerCustomerAsPercentage:", averageDiscountPerCustomerAsPercentage);
        System.out.println("Part One Result:");
        result.forEach((key, value) -> System.out.println(key + " " + value));
    }
}