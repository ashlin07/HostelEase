package com.management.hostelease.services;

import com.management.hostelease.model.Room;

import java.util.List;

public interface RoomService {
    void addStudent(Room room, String student);
    Room removeStudent(Room room, String student);
    Room bookRoom(Room room, String student);
    List<Room>showAllRooms();
    List<Room> showAllAvailableRooms();

    Room getRoomById(int id);
}