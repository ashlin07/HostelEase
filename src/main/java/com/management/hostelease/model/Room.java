package com.management.hostelease.model;


import jakarta.persistence.*;


import java.util.ArrayList;
import java.util.List;

@Entity
public class Room {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private int roomNumber;
    @ManyToOne
    @JoinColumn(name = "block_id")
    private Block block;
    private String roomType;
    private int capacity;
    private boolean isBooked;

    @ElementCollection
    private List<String> students;

    public Room() {
        this.students = new ArrayList<>();
    }
    public Room(int roomNumber,Block block,String roomType,int capacity) {
        this.roomNumber = roomNumber;
        this.block = block;
        this.roomType = roomType;
        this.capacity = capacity;
        this.students = new ArrayList<>();

    }





    // Getters and setters

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(int roomNumber) {
        this.roomNumber = roomNumber;
    }

    public Block getBlock() {
        return block;
    }

    public void setBlock(Block block) {
        this.block = block;
    }

    public String getRoomType() {
        return roomType;
    }

    public void setRoomType(String roomType) {
        this.roomType = roomType;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public boolean getIsBooked() {
        return isBooked;
    }

    public void setBooked(boolean booked) {
        isBooked = booked;
    }

    public List<String> getStudents() {
        return students;
    }

    public void setStudents(List<String> students) {
        this.students = students;
    }
}