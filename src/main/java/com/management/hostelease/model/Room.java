package com.management.hostelease.model;
import jakarta.persistence.*;

@Entity
public class Room {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String roomNumber;
    private String roomType;

    private int roomCapacity;
    private boolean isBooked;
    @ManyToOne
    private Block block;


    public Room(int id, String roomNumber, String roomType,Block block, boolean isBooked, int roomCapacity){
        this.id = id;
        this.roomNumber = roomNumber;
        this.roomType = roomType;
        this.isBooked = isBooked;
        this.block=block;
        this.roomCapacity = roomCapacity;

    }

    public Room(String roomNumber, String roomType,Block block,boolean isBooked, int roomCapacity) {
        this.roomNumber = roomNumber;
        this.roomType = roomType;
        this.isBooked = isBooked;
        this.block=block;
        this.roomCapacity = roomCapacity;


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

    public int getRoomPrice() {
        return block.getPrice();
    }
    public int getRoomCapacity() {
        return roomCapacity;
    }
    public void setRoomCapacity(int roomCapacity) {
        this.roomCapacity = roomCapacity;
    }

    public void setRoomPrice(int i) {
    }
}
