package com.management.hostelease.model;

public interface StudentBuilder {
    StudentBuilder setName(String name);
    StudentBuilder setSrn(int SRN);
    StudentBuilder setDepartment(String department);
    StudentBuilder setHostelName(String hostelName);
    StudentBuilder setRoomNumber(int roomNumber);
    Student build();
}
