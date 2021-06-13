package com.example.fastrestowner.controllers.entities;

import java.util.List;

public class Menu {

    private int id;

    private String title;
    private boolean isTitleChanging;

    private String logo;

    private String ingredients;
    private boolean isIngredientsChanging;

    private String price;
    private boolean isPriceChanging;

    private float count;

    public Menu(int id, String title, String logo, String ingredients, String price) {
        this.id = id;
        this.title = title;
        this.logo = logo;
        this.ingredients = ingredients;
        this.price = price;
    }

    public Menu() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public boolean isTitleChanging() {
        return isTitleChanging;
    }

    public void setTitleChanging(boolean titleChanging) {
        isTitleChanging = titleChanging;
    }

    public String getIngredients() {
        return ingredients;
    }

    public void setIngredients(String ingredients) {
        this.ingredients = ingredients;
    }

    public boolean isIngredientsChanging() {
        return isIngredientsChanging;
    }

    public void setIngredientsChanging(boolean ingredientsChanging) {
        isIngredientsChanging = ingredientsChanging;
    }

    public boolean isPriceChanging() {
        return isPriceChanging;
    }

    public void setIsPriceChanging(boolean isPriceChanging) {
        this.isPriceChanging = isPriceChanging;
    }

    public float getCount() {
        return count;
    }

    public void setCount(float count) {
        this.count = count;
    }

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public void increment() {
        count++;
    }

    public void decrement() {
        count--;
    }
}
