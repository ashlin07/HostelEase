package com.management.hostelease.repository;

import com.management.hostelease.model.Room;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoomRepository extends JpaRepository<Room,Integer> {
    
}
