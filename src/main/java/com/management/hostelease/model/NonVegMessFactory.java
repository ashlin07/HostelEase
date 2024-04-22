package com.management.hostelease.model;

public class NonVegMessFactory extends AbstractFactory {
    @Override
    public Mess createMess(String messName) {
        return new NonVegMess(messName);
    }
}
