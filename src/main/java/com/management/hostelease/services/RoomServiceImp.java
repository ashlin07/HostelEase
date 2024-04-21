package com.management.hostelease.services;

import com.management.hostelease.model.ConcreteStudent;
import com.management.hostelease.model.Room;
import com.management.hostelease.repository.RoomRepository;
import com.management.hostelease.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoomServiceImp implements RoomService {
    @Autowired
    private RoomRepository roomRepository;
    @Autowired
    private StudentRepository studentRepository;
    @Override
    public void addStudent(Room room, String student) {
        // Implementation goes here
        if (room.getStudents().size() < room.getCapacity()) {
            room.getStudents().add(student);
            room.getAttendanceMap().put(student, new boolean[30]);
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
    public Room bookRoom(Room room, String studentName) {
        ConcreteStudent student = studentRepository.findByName(studentName);

        // Set the student's room number
        student.setRoom(room);
        // Implementation goes here
        addStudent(room, studentName);

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
    @Override
    public Room getRoomById(int id) {
        // Implementation goes here
        return roomRepository.findById(id).orElse(null);
    }
}