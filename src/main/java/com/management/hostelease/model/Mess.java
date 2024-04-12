package com.management.hostelease.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Mess {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String messName;
    private String messType;

    public Mess(int id, String messName, String messType) {
        this.id = id;
        this.messName = messName;
        this.messType = messType;
    }

    public Mess(String messName, String messType) {
        this.messName = messName;
        this.messType = messType;
    }

    public Mess() {
    }

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

    public String getMessType() {
        return messType;
    }

    public void setMessType(String messType) {
        this.messType = messType;
    }

}