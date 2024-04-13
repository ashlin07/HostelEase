package com.management.hostelease.services;

import com.management.hostelease.model.Room;
import com.management.hostelease.repository.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;
import com.management.hostelease.model.Room;
import com.management.hostelease.repository.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoomServiceImp implements RoomService{
        @Autowired
        private RoomRepository roomRepository;

        public Room addRoom(Room room) {
            return roomRepository.save(room);
        }

        public Room bookRoom(int id) {
            Room room = roomRepository.findById(id).orElseThrow(() -> new RuntimeException("Room not found"));
            room.setBooked(true);
            return roomRepository.save(room);
        }

        public List<Room> getAllRooms() {
            return roomRepository.findAll();
        }

        public List<Room> getAvailableRooms() {
            return roomRepository.findByIsBooked(false);
        }

        public void deleteRoom(int id) {
            roomRepository.deleteById(id);
        }
    }

