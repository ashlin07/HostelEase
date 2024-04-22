package com.management.hostelease.model;

public class NonVegMess extends Mess {
    public NonVegMess(String messName) {
        this.messName = messName;
    }

    @Override
    public void serveFood() {
        System.out.println("Serving non-vegetarian food...");
    }
}

