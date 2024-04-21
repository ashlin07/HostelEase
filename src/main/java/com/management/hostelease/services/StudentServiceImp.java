package com.management.hostelease.services;

import com.management.hostelease.model.ConcreteStudent;
import com.management.hostelease.model.Student;
import com.management.hostelease.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentServiceImp implements StudentService {
    @Autowired
    private StudentRepository studentRepository;

    public ConcreteStudent addStudent(String name, int srn, String department) {
        ConcreteStudent student = (ConcreteStudent) new ConcreteStudent.ConcreteStudentBuilder()
                .setName(name)
                .setSrn(srn)
                .setDepartment(department)

                .build();
        return studentRepository.save(student);
    }

    public List<ConcreteStudent> getAllStudents() {
        return studentRepository.findAll();
    }

    public Optional<ConcreteStudent> getStudentById(int id) {
        return studentRepository.findById(id);
    }
    public String getStudentNameById(int id) {
        Optional<ConcreteStudent> student = studentRepository.findById(id);
        return student.get().getName();
    }

}
