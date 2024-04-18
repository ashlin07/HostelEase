package com.management.hostelease.model;

public interface StudentBuilder {
    StudentBuilder setName(String name);
    StudentBuilder setSrn(int SRN);
    StudentBuilder setDepartment(String department);
    StudentBuilder setRoomNumber(int roomNumber);
    String getName();
    int getSrn();
    String getDepartment();
    int getRoomNumber();
    Student build();
}
