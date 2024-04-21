package com.management.hostelease.model;

public abstract class Mess {
    protected int id;
    protected String messName;

    public abstract void serveFood();

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

    public static Mess createMess(AbstractFactory factory, String messName) {
        return factory.createMess(messName);
    }
}
