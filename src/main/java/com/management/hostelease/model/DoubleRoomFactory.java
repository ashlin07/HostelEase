package com.management.hostelease.model;

import org.springframework.stereotype.Component;

@Component
public class DoubleRoomFactory implements RoomFactory {
    @Override
    public Room createRoom(RoomType roomType, int roomNumber, Block block) {
        if (roomType != RoomType.DOUBLE) {
            throw new IllegalArgumentException("Invalid room type for DoubleRoomFactory");
        }
        int capacity = roomType.getDefaultCapacity();
        return new Room(roomNumber, block, "Double", capacity);
    }
    @Override
    public RoomType getRoomType() {
        return RoomType.DOUBLE;
    }
}
