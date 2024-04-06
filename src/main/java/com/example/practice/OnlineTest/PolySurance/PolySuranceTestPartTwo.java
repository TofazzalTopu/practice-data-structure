package com.example.practice.OnlineTest.PolySurance;

import java.util.*;
import java.util.concurrent.atomic.AtomicReference;
import java.util.function.UnaryOperator;
import java.util.stream.Collectors;

public class PolySuranceTestPartTwo {

    public static void main(String[] args) {
        Map<String, Double> discounts = new HashMap<>();
        discounts.put("SALE10", 0.1);
        discounts.put("SALE20", 0.2);
        discounts.put("SALE30", 0.3);
        discounts.put("WINTERMADNESS", 0.1);

        Map<String, Double> products = new HashMap<>();
        products.put("1001", 14.99);
        products.put("1002", 156.99);
        products.put("1003", 1099.99);
        products.put("1004", 64.99);

        NewOrder orderSix = new NewOrder(6L, List.of("SALE10", "WINTERMADNESS"), List.of(new Item("1001", 2), new Item("1003", 2)));
        NewOrder orderSeven = new NewOrder(7L, List.of("SALE30"), List.of(new Item("1001", 3), new Item("1002", 4)));
        NewOrder orderEight = new NewOrder(8L, List.of(), List.of(new Item("1003", 1), new Item("1001", 7), new Item("1002", 2)));
        NewOrder orderNine = new NewOrder(9L, List.of("WINTERMADNESS"), List.of(new Item("1001", 12), new Item("1003", 1)));
        NewOrder orderTen = new NewOrder(10L, List.of("SALE20"), List.of(new Item("1003", 1)));
        NewOrder orderEleven = new NewOrder(11L, List.of("SALE20", "WINTERMADNESS"), List.of(new Item("1004", 5)));

        List<NewOrder> orderList = new ArrayList<>(List.of(orderSix, orderSeven, orderEight, orderNine, orderTen, orderEleven));
        AtomicReference<Double> totalSalesWithoutDiscount = new AtomicReference<>(0.0);
        Double totalAmountOfLossViaDiscount = 0.0;
        Map<Long, Double> orderWiseTotalDiscountPercentage = new HashMap<>();
        Map<Long, Double> orderWiseTotalDiscount = new HashMap<>();

        orderList.forEach(order -> {
            order.getItems().stream().mapToDouble(e -> (products.get(e.getSku()) * e.getQuantity()))
                    .<UnaryOperator<Double>>mapToObj(v -> v1 -> (double) (v1 + v))
                    .forEach(totalSalesWithoutDiscount::updateAndGet);
        });

        for (NewOrder order : orderList) {
            double orderWiseDiscount = 0.0;
            for (Item item : order.getItems()) {
                double totalDiscountPercentage = order.getDiscounts().stream().mapToDouble(discounts::get).sum();
                orderWiseDiscount += ((products.get(item.getSku()) * item.getQuantity()) * totalDiscountPercentage);
            }
            totalAmountOfLossViaDiscount += orderWiseDiscount;
            orderWiseTotalDiscount.put(order.getOrderId(), orderWiseDiscount);
        }

        Double totalSalesAfterDiscount = totalSalesWithoutDiscount.get() - totalAmountOfLossViaDiscount;

        Double finalTotalAmountOfLossViaDiscount = totalAmountOfLossViaDiscount;
        orderWiseTotalDiscount.forEach((key, value) -> orderWiseTotalDiscountPercentage.put(key, (value * 100) / finalTotalAmountOfLossViaDiscount));

        double averageDiscountPerCustomerAsPercentage = (orderWiseTotalDiscountPercentage.values().stream().mapToDouble(v -> v).sum() / orderList.size());

        Map<String, Object> result = new LinkedHashMap<>();
        result.put("totalSalesWithoutDiscount:", totalSalesWithoutDiscount);
        result.put("totalSalesAfterDiscount:", totalSalesAfterDiscount);
        result.put("totalAmountOfLossViaDiscount:", totalAmountOfLossViaDiscount);
        result.put("averageDiscountPerCustomerAsPercentage:", averageDiscountPerCustomerAsPercentage);
        System.out.println("Part Two Result:");
        result.forEach((key, value) -> System.out.println(key + " " + value));
    }
}