package com.example.fastrestowner.controllers.entities;

public class Personal {
    public enum Status {
        PENDING,
        REJECTED,
        CONNECTED,
    }
    private int id;
    private String email;
    private String name;
    private String surname;
    private Status status;

    public Personal() {
    }

    public Personal(String email, String name, String surname, Status status) {
        this.email = email;
        this.name = name;
        this.surname = surname;
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }
}
