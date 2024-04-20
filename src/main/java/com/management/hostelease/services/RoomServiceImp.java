package com.management.hostelease.services;

import com.management.hostelease.model.Room;
import com.management.hostelease.repository.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoomServiceImp implements RoomService {
    @Autowired
    private RoomRepository roomRepository;
    @Override
    public void addStudent(Room room, String student) {
        // Implementation goes here
        if (room.getStudents().size() < room.getCapacity()) {
            room.getStudents().add(student);
        } else {
            System.out.println("Room is already at full capacity.");
        }



    }

    @Override
    public Room removeStudent(Room room, String student) {
        // Implementation goes here
        room.getStudents().remove(student);
        return roomRepository.save(room);

    }

    @Override
    public Room bookRoom(Room room, String student) {
        // Implementation goes here
        addStudent(room, student);

        // Reduce the capacity by 1
        room.setCapacity(room.getCapacity() - 1);

        // If the new capacity is 0, set isBooked to true
        if (room.getCapacity() == 0) {
            room.setBooked(true);
        }

        // Save the updated room
        return roomRepository.save(room);

    }
    @Override
    public List<Room> showAllRooms() {
        // Implementation goes here
        return roomRepository.findAll();
    }
    @Override
    public List<Room> showAllAvailableRooms() {
        // Implementation goes here
        return roomRepository.findByIsBooked(false);
    }
}