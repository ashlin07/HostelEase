package com.management.hostelease.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Mess {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String messName;
    private String messType;

    // Factory method to create different types of Mess objects
    public static Mess createMess(String messName, String messType) {
        if (messType.equalsIgnoreCase("veg")) {
            return new VegMess(messName, messType);
        } else if (messType.equalsIgnoreCase("nonveg")) {
            return new NonVegMess(messName, messType);
        }
        return null;
    }

    public Mess(String messName, String messType) {
        this.messName = messName;
        this.messType = messType;
    }

    public Mess() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMessName() {
        return messName;
    }

    public void setMessName(String messName) {
        this.messName = messName;
    }

    public String getMessType() {
        return messType;
    }

    public void setMessType(String messType) {
        this.messType = messType;
    }

    // Abstract method to serve food
    public void serveFood() {}
}

class VegMess extends Mess {
    public VegMess(String messName, String messType) {
        super(messName, messType);
    }

    @Override
    public void serveFood() {
        System.out.println("Serving vegetarian food...");
    }
}

class NonVegMess extends Mess {
    public NonVegMess(String messName, String messType) {
        super(messName, messType);
    }

    @Override
    public void serveFood() {
        System.out.println("Serving non-vegetarian food...");
    }
}