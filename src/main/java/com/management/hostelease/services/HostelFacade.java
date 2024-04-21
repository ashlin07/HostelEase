package com.management.hostelease.services;

import com.management.hostelease.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class HostelFacade {
    @Autowired
    private  RoomService roomService;
    @Autowired
    private StudentService studentService;
    @Autowired
    private BlockService blockService;
    @Autowired
    private  HostelService hostelService;
    @Autowired
    private RoomFactoryProvider roomFactoryProvider;



    public Room addRoom(String blockName, RoomType roomType, int roomNumber) {
        Block block = blockService.getBlockByName(blockName);
        RoomFactory roomFactory = roomFactoryProvider.getRoomFactory(roomType);
        Room room = roomFactory.createRoom(roomType, roomNumber, block);
        blockService.addRoom(blockName, room);
        return room;
    }

    public void addStudentToRoom(Room room, String student) {
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
    public List<Block> getAllBlocks() {
        return blockService.getAllBlocks();
    }
    public Room getRoomById(int id) {
        return roomService.getRoomById(id);
    }
    public String getStudentNameById(int id) {
        return studentService.getStudentNameById(id);
    }

    public void addStudent(String name, int srn, String department) {
        studentService.addStudent(name, srn, department);
    }
}