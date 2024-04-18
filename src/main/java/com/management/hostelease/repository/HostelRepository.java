package com.management.hostelease.repository;

import com.management.hostelease.model.Hostel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HostelRepository extends JpaRepository<Hostel,Integer> {
}
