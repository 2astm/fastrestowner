package com.example.fastrestowner.controllers.entities;

import java.util.List;

public class Order {
    private List<String> items;
    private String comment;
    private String time;
    private boolean accepted;

    public Order(List<String> items, String comment, String time) {
        this.items = items;
        this.comment = comment;
        this.time = time;
    }

    public Order() {
    }

    public boolean isAccepted() {
        return accepted;
    }

    public void setAccepted(boolean accepted) {
        this.accepted = accepted;
    }

    public List<String> getItems() {
        return items;
    }

    public void setItems(List<String> items) {
        this.items = items;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
}
