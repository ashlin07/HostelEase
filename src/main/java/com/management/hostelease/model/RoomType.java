package com.management.hostelease.model;

public enum RoomType {
    SINGLE,
    DOUBLE,
    TRIPLE;

    private int defaultCapacity;

    static {
        SINGLE.defaultCapacity = 1;
        DOUBLE.defaultCapacity = 2;
        TRIPLE.defaultCapacity = 3;

    }

    public int getDefaultCapacity() {
        return defaultCapacity;
    }
}
