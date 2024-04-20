package com.management.hostelease.controllers;

import com.management.hostelease.model.Block;
import com.management.hostelease.model.Room;
import com.management.hostelease.model.RoomType;
import com.management.hostelease.services.HostelFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api")
public class HostelController {

    private final HostelFacade hostelFacade;

    @Autowired
    public HostelController(HostelFacade hostelFacade) {
        this.hostelFacade = hostelFacade;
    }

    @PostMapping("/block")
    public Block addBlock(@RequestParam String blockName, @RequestParam int price) {
        return hostelFacade.addBlock(blockName, price);
    }
    @GetMapping("/blocks")
    public List<Block> getAllBlocks() {
        return hostelFacade.getAllBlocks();
    }
    @PostMapping("/room")
    public Room addRoom(@RequestParam String blockName, @RequestParam RoomType roomType, @RequestParam int roomNumber, @RequestParam int capacity) {
        return hostelFacade.addRoom(blockName, roomType, roomNumber, capacity);
    }

    @PostMapping("/room/addStudent")
    public void addStudent(@RequestBody Room room, @RequestParam String student) {
        hostelFacade.addStudent(room, student);
    }

    @PostMapping("/room/removeStudent")
    public void removeStudent(@RequestBody Room room, @RequestParam String student) {
        hostelFacade.removeStudent(room, student);
    }

    @PostMapping("/room/book")
    public void bookRoom(@RequestBody Room room, @RequestParam String student) {
        hostelFacade.bookRoom(room, student);
    }

    @GetMapping("/room/show")
    public List<Room> showAllRooms() {
        return hostelFacade.showAllRooms();
    }
    @GetMapping("/room/showAvailabe")
    public List<Room>showAvailableRooms() {
        return hostelFacade.showAvailableRooms();
    }



}

