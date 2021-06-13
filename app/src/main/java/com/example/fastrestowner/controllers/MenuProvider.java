package com.example.fastrestowner.controllers;

import android.view.MenuItem;

import com.example.fastrestowner.controllers.entities.Menu;
import com.example.fastrestowner.controllers.entities.Restaurant;

import java.util.ArrayList;
import java.util.List;

public class MenuProvider {
    private ArrayList<Menu> menuItems;

    private MenuProvider() {
        menuItems = new ArrayList<>();
    }

    public List<Menu> getRestaurants() {
        return menuItems;
    }

    public void createRestaurant() {
        menuItems.add(new Menu(1, "Example title", "asd", "Example Ingredients, Ingredient 2", "100"));
    }

    private static MenuProvider instance;

    public static MenuProvider getInstance() {
        if (instance == null)
            instance = new MenuProvider();
        return instance;
    }
}
