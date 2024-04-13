package com.management.hostelease.controllers;

import com.management.hostelease.model.Room;
import com.management.hostelease.services.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class RoomController {

    @Autowired
    private RoomService roomService;

    @GetMapping("/room")
    public List<Room> getAllRooms() {
        return roomService.getAllRooms();
    }
    @PostMapping("/room")
    public Room addRoom(@RequestBody Room room) {
        return roomService.addRoom(room);

    }
}
