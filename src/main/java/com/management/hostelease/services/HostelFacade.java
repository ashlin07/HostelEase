package com.management.hostelease.services;

import com.management.hostelease.model.*;
import org.springframework.stereotype.Service;

@Service
class HostelFacade {
    private final RoomService roomService;
    private final BlockService blockService;
    private final HostelService hostelService;
    private final RoomFactoryProvider roomFactoryProvider;

    public HostelFacade(RoomService roomService, BlockService blockService, HostelService hostelService, RoomFactoryProvider roomFactoryProvider) {
        this.roomService = roomService;
        this.blockService = blockService;
        this.hostelService = hostelService;
        this.roomFactoryProvider = roomFactoryProvider;
    }

    public Room addRoom(Block block, RoomType roomType, int roomNumber, int capacity) {
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

    public void bookRoom(Room room) {
        roomService.bookRoom(room);
    }

    public Block addBlock(String blockName) {
        Block block = new Block(blockName);
        Hostel hostel = new Hostel(); // Or get the existing hostel instance
        hostelService.addBlock(hostel, block);
        return block;
    }
}