package com.management.hostelease.services;

import com.management.hostelease.model.Payment;
import com.management.hostelease.model.Room;
import com.management.hostelease.model.Student;
import com.management.hostelease.repository.PaymentRepository;
import com.management.hostelease.repository.RoomRepository;
import com.management.hostelease.repository.StudentRepository;
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
        @Autowired
        private StudentRepository studentRepository;
        @Autowired
        private PaymentRepository paymentRepository;
        public Room addRoom(Room room) {

            return roomRepository.save(room);
        }

    public Room bookRoom(Payment payment) {
        int studentId = payment.getStudentId();
        int roomId = payment.getRoomId();
        Optional<Room> roomOptional = roomRepository.findById(roomId);
        if (!roomOptional.isPresent()) {
            throw new RuntimeException("Room not found");
        }

        Room room = roomOptional.get();
        if (room.isBooked()) {
            throw new RuntimeException("Room is already booked");
        }

        Optional<Student> studentOptional = studentRepository.findById(studentId);
        if (!studentOptional.isPresent()) {
            throw new RuntimeException("Student not found");
        }

        Student student = studentOptional.get();

        room.getStudents().add(student.getName());
        student.setRoom(room);

        room.setRoomCapacity(room.getRoomCapacity() - 1);
        if (room.getRoomCapacity() == 0) {
            room.setBooked(true);
        }

        roomRepository.save(room);
        studentRepository.save(student);
        paymentRepository.save(payment);


        return room;
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

