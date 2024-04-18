package com.management.hostelease.model;

import org.springframework.stereotype.Component;

@Component
public class TripleRoomFactory implements RoomFactory {
    @Override
    public Room createRoom(RoomType roomType, int roomNumber, Block block) {
        if (roomType != RoomType.TRIPLE) {
            throw new IllegalArgumentException("Invalid room type for TripleRoomFactory");
        }
        int capacity = roomType.getDefaultCapacity();
        return new Room(roomNumber, block, "Triple", capacity);
    }
    @Override
    public RoomType getRoomType() {
        return RoomType.TRIPLE;
    }
}
