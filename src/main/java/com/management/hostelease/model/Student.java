package com.management.hostelease.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String SRN;
    private String department;

    private String roomNumber;

    public Student() {
    }

    public Student(String name, String SRN, String department) {
        this.name = name;
        this.SRN = SRN;
        this.department = department;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSRN() {
        return SRN;
    }

    public void setSRN(String SRN) {
        this.SRN = SRN;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }
    public String getRoomNumber(String roomNumber){
        return roomNumber;
    }
    public void setRoomNumber(){
        this.roomNumber = roomNumber;
    }
}

