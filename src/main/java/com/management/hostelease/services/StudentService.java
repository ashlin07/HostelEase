package com.management.hostelease.services;

import com.management.hostelease.model.Student;

import java.util.List;
import java.util.Optional;

public interface StudentService {
    public Student addStudent(Student student);

    public List<Student> getAllStudents() ;

    public Optional<Student> getStudentById(int id);
}
