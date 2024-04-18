
package com.management.hostelease.model;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Hostel {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Block> blocks;

    public Hostel() {
        this.blocks = new ArrayList<>();
    }

    // getters and setters

    public void addBlock(Block block) {
        this.blocks.add(block);
    }

    public void removeBlock(Block block) {
        this.blocks.remove(block);
    }
}