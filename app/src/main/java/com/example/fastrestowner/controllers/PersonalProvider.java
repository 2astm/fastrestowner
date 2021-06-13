package com.example.fastrestowner.controllers;

import com.example.fastrestowner.controllers.entities.Personal;
import com.example.fastrestowner.controllers.entities.Restaurant;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class PersonalProvider {
    private ArrayList<Personal> personalList;

    private PersonalProvider() {
        personalList = new ArrayList<>();
        personalList.add(new Personal("jekajakorev@gmail.com", "Yevhen", "Molchaniuk", Personal.Status.CONNECTED));
        personalList.add(new Personal("someemail@gmail.com", "John", "Snow", Personal.Status.REJECTED));
        personalList.add(new Personal("jacksparrow@gmail.com", "Jack", "Sparrow", Personal.Status.CONNECTED));
        personalList.add(new Personal("leonardoDiCaprio@gmail.com", "Leonardo", "DiCaprio", Personal.Status.PENDING));
    }

    public List<Personal> getRestaurants() {
        return personalList;
    }

    public void addPersonalWithName(String email) {
        Personal personal = new Personal();
        personal.setEmail(email);
        switch((new Random()).nextInt()) {
            case 1: personal.setStatus(Personal.Status.CONNECTED); break;
            case 2: personal.setStatus(Personal.Status.PENDING); break;
            default: personal.setStatus(Personal.Status.REJECTED); break;
        }
        personalList.add(personal);
    }

    private static PersonalProvider instance;

    public static PersonalProvider getInstance() {
        if (instance == null)
            instance = new PersonalProvider();
        return instance;
    }
}
