package com.example.fastrestowner.controllers;

import com.example.fastrestowner.controllers.entities.Menu;
import com.example.fastrestowner.controllers.entities.Order;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class OrderProvider {
    private ArrayList<Order> orders;

    private OrderProvider() {
        orders = new ArrayList<>();
        orders.add(new Order(Arrays.asList("Чикен блю чиз - 2шт", "Альфредо блю чиз - 1 шт"), "", "12:40"));
        orders.add(new Order(Arrays.asList("Чикен блю чиз - 2шт", "Альфредо блю чиз - 1 шт"), "", "12:40"));
        orders.add(new Order(Arrays.asList("Чикен блю чиз - 2шт", "Альфредо блю чиз - 1 шт"), "", "12:40"));
        orders.add(new Order(Arrays.asList("Чикен блю чиз - 2шт", "Альфредо блю чиз - 1 шт"), "", "12:40"));
        orders.add(new Order(Arrays.asList("Чикен блю чиз - 2шт", "Альфредо блю чиз - 1 шт"), "", "12:40"));
    }

    public List<Order> getOrders() {
        return orders;
    }

    private static OrderProvider instance;

    public static OrderProvider getInstance() {
        if (instance == null)
            instance = new OrderProvider();
        return instance;
    }
}
