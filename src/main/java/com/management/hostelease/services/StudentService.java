package com.management.hostelease.services;

import com.management.hostelease.model.ConcreteStudent;
import com.management.hostelease.model.Student;

import java.util.List;
import java.util.Optional;

public interface StudentService {
    public ConcreteStudent addStudent(String name, int srn, String department);

    public List<ConcreteStudent> getAllStudents() ;

    public Optional<ConcreteStudent> getStudentById(int id);
    public String getStudentNameById(int id);
}
