package com.management.hostelease.services;

import com.management.hostelease.model.Room;

import java.util.List;
import java.util.Optional;

public interface RoomService {
    Room addRoom(Room room);
    Room bookRoom(int id);
    List<Room> getAllRooms();

    void deleteRoom(int id);
    List<Room> getAvailableRooms();
}
