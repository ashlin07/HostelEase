package com.management.hostelease.repository;

import com.management.hostelease.model.Room;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RoomRepository extends JpaRepository<Room,Integer> {

    List<Room> findByIsBooked(boolean b);
}
