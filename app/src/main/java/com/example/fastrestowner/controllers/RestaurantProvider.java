package com.example.fastrestowner.controllers;

import com.example.fastrestowner.controllers.entities.Restaurant;
import com.google.android.gms.maps.model.LatLng;

import java.util.ArrayList;
import java.util.List;

public class RestaurantProvider {
    private ArrayList<Restaurant> restaurants;

    private RestaurantProvider() {
        restaurants = new ArrayList<>();
        restaurants.add(new Restaurant("Burgers", "https://i.imgur.com/A17woOs.jpg"));
    }

    public List<Restaurant> getRestaurants() {
        return restaurants;
    }

    public void createRestaurant() {
        restaurants.add(new Restaurant());
    }

    private static RestaurantProvider instance;

    public static RestaurantProvider getInstance() {
        if (instance == null)
            instance = new RestaurantProvider();
        return instance;
    }
}
