package com.management.hostelease.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import java.util.Date;

@Entity
public class Booking {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private int studentId;
    private Date startDate;
    private Date endDate;
    private String messOption;
    private int roomId;
    // Add other relevant attributes and associations

    public Booking() {
    }

    public Booking(int studentId, Date startDate, Date endDate, String messOption, int roomId) {
        this.studentId = studentId;
        this.startDate = startDate;
        this.endDate = endDate;
        this.messOption = messOption;
        this.roomId = roomId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public String getMessOption() {
        return messOption;
    }

    public void setMessOption(String messOption) {
        this.messOption = messOption;
    }

    public int getRoomId() {
        return roomId;
    }

    public void setRoomId(int roomId) {
        this.roomId = roomId;
    }
}
