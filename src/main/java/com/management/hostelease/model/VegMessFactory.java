package com.management.hostelease.model;

public class VegMessFactory extends AbstractFactory {
    @Override
    public Mess createMess(String messName) {
        return new VegMess(messName);
    }
}

