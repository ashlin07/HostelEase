package com.management.hostelease.services;

import com.management.hostelease.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HostelFacade {
    @Autowired
    private  RoomService roomService;
    @Autowired
    private BlockService blockService;
    @Autowired
    private  HostelService hostelService;
    @Autowired
    private RoomFactoryProvider roomFactoryProvider;



    public Room addRoom(String blockName, RoomType roomType, int roomNumber, int capacity) {
        Block block = blockService.getBlockByName(blockName);
        RoomFactory roomFactory = roomFactoryProvider.getRoomFactory(roomType);
        Room room = roomFactory.createRoom(roomType, roomNumber, block);
        blockService.addRoom(block, room);
        return room;
    }

    public void addStudent(Room room, String student) {
        roomService.addStudent(room, student);
    }

    public void removeStudent(Room room, String student) {
        roomService.removeStudent(room, student);
    }

    public void bookRoom(Room room,String student) {
        roomService.bookRoom(room,student);
    }

    public Block addBlock(String blockName,int price) {
        Block block = new Block(blockName,price);
        Hostel hostel = new Hostel(); // Or get the existing hostel instance
        hostelService.addBlock(hostel, block);
        return block;
    }
    public List<Room> showAllRooms() {
        return roomService.showAllRooms();
    }

    public List<Room> showAvailableRooms() {
        return roomService.showAllAvailableRooms();
    }
}