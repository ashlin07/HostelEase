package com.management.hostelease.model;

import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
public class Attendance {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Temporal(TemporalType.DATE)
    private Date date;
    @OneToMany
    private List<Student> students;

    public Attendance() {
        this.students = new ArrayList<>();
        this.date = new Date(); // Default to current date
    }

    public Attendance(Date date, List<Student> students) {
        this.date = date;
        this.students = students;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    public void markAttendance(Student student) {
        this.students.add(student);
    }
}
