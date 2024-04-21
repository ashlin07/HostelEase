package com.management.hostelease.model;

import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Block {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private int price;
    @OneToMany(mappedBy = "block", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Room> rooms;

    public Block() {
        this.rooms = new ArrayList<>();
    }
    public Block(String name,int price) {
        this.name = name;
        this.rooms = new ArrayList<>();
        this.price=price;
    }

    // getters and setters
    public int getPrice() {
        return price;
    }
    public String getName() {
        return name;
    }
    public void addRoom(Room room) {
        this.rooms.add(room);
        room.setBlock(this);
    }

    public void removeRoom(Room room) {
        this.rooms.remove(room);
        room.setBlock(null);
    }
}