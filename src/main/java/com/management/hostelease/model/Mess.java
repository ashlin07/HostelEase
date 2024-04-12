package com.management.hostelease.model;

public class Mess {
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