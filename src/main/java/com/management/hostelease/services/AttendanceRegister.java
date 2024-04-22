package com.management.hostelease.services;

import com.management.hostelease.model.Observer;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AttendanceRegister implements AttendanceService{
    private List<Observer> observers;

    public AttendanceRegister() {
        this.observers = new ArrayList<>();
    }

    public void registerObserver(Observer observer) {
        observers.add(observer);
    }

    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    public void markAttendance(String studentName, int day, boolean present) {
        for (Observer observer : observers) {
            observer.update(studentName, day, present);
        }
    }
}

