package com.management.hostelease.services;

import com.management.hostelease.model.Room;

public interface RoomService {
    void addStudent(Room room, String student);
    void removeStudent(Room room, String student);
    void bookRoom(Room room);
}