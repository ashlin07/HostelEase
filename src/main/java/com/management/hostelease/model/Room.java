package com.management.hostelease.model;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Room {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String roomNumber;
    private String roomType;
    private String roomPrice;
    private boolean isBooked;


    public Room(int id, String roomNumber, String roomType,String roomPrice, boolean isBooked) {
        this.id = id;
        this.roomNumber = roomNumber;
        this.roomType = roomType;
        this.isBooked = isBooked;
        this.roomPrice = roomPrice;

    }

    public Room(String roomNumber, String roomType,String roomPrice,boolean isBooked) {
        this.roomNumber = roomNumber;
        this.roomType = roomType;
        this.isBooked = isBooked;
        this.roomPrice = roomPrice;

    }

    public Room() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(String roomNumber) {
        this.roomNumber = roomNumber;
    }

    public String getRoomType() {
        return roomType;
    }

    public void setRoomType(String roomType) {
        this.roomType = roomType;
    }

    public boolean isBooked() {
        return isBooked;
    }
    public void setBooked(boolean booked) {
        isBooked = booked;
    }

    public String getRoomPrice() {
        return roomPrice;
    }

    public void setRoomPrice(String roomPrice) {
        this.roomPrice = roomPrice;
    }






}
