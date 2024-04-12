package com.management.hostelease.repository;

import com.management.hostelease.model.Mess;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MessRepository extends JpaRepository<Mess,Integer> {

}