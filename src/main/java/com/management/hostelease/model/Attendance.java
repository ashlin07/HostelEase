package com.management.hostelease.model;

import com.management.hostelease.services.RoomServiceImp;
import jakarta.persistence.*;

@Entity
public class Attendance {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "room_id")
    private Room room;

    private String studentName;

    @Column(columnDefinition = "BOOLEAN[]")
    private boolean[] attendanceArray;

    public Attendance() {
    }


    public void setRoom(Room room) {
        this.room = room;

    }
    public void setStudentName(String studentName){
        this.studentName=studentName;
    }

    public String getStudentName() {
        return studentName;
    }

    public boolean[] getAttendanceArray() {
        return attendanceArray;
    }

    public void setAttendanceArray(boolean[] booleans) {
        this.attendanceArray=booleans;
    }
}
