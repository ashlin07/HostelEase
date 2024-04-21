package com.management.hostelease.model;

public class VegMess extends Mess {
    public VegMess(String messName) {
        this.messName = messName;
    }

    @Override
    public void serveFood() {
        System.out.println("Serving vegetarian food...");
    }
}

