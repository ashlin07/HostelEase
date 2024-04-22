package com.management.hostelease.services;

import com.management.hostelease.model.Observer;

public interface AttendanceService {
    public void registerObserver(Observer observer);
    public void removeObserver(Observer observer);
    public void markAttendance(String studentName, int day, boolean present);
}
