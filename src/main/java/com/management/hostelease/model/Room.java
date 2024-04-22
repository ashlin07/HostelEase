package com.management.hostelease.model;


import jakarta.persistence.*;


import java.util.*;

@Entity
public class Room implements Observer{
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

    @OneToMany(mappedBy = "room", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Attendance> attendances;

    public Room() {
        this.students = new ArrayList<>();
        this.attendances = new ArrayList<>();

    }
    public Room(int roomNumber,Block block,String roomType,int capacity) {
        this.roomNumber = roomNumber;
        this.block = block;
        this.roomType = roomType;
        this.capacity = capacity;
        this.students = new ArrayList<>();
    }
    private Attendance findAttendanceByStudentName(String studentName) {
        return attendances.stream()
                .filter(a -> a.getStudentName().equals(studentName))
                .findFirst()
                .orElse(null);
    }
    @Override
    public void update(String studentName, int day, boolean present) {
        Attendance attendance = findAttendanceByStudentName(studentName);
        if (attendance != null && day >= 0 && day < attendance.getAttendanceArray().length) {
            attendance.getAttendanceArray()[day] = present;
        }
    }









    // Getters and setters
    public List<Attendance> getAttendances(){
        return attendances;
    }
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