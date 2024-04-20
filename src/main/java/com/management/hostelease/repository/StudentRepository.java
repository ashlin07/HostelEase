package com.management.hostelease.repository;

import com.management.hostelease.model.ConcreteStudent;
import com.management.hostelease.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<ConcreteStudent, Integer> {
    ConcreteStudent findByName(String studentName);
}
