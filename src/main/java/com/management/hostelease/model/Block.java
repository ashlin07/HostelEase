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

    @OneToMany(mappedBy = "block", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Room> rooms;

    public Block() {
        this.rooms = new ArrayList<>();
    }
    public Block(String name) {
        this.name = name;
        this.rooms = new ArrayList<>();
    }

    // getters and setters

    public void addRoom(Room room) {
        this.rooms.add(room);
        room.setBlock(this);
    }

    public void removeRoom(Room room) {
        this.rooms.remove(room);
        room.setBlock(null);
    }
}