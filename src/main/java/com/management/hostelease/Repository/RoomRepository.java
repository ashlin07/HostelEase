package com.management.hostelease.Repository;

import com.management.hostelease.Model.Room;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoomRepository extends JpaRepository <Room,Integer> {
}
