package com.management.hostelease.model;

public interface StudentBuilder {
    StudentBuilder setName(String name);
    StudentBuilder setSrn(int SRN);
    StudentBuilder setDepartment(String department);

    String getName();
    int getSrn();
    String getDepartment();

    Student build();
}
