package com.management.hostelease.model;
import org.springframework.stereotype.Component;

@Component
public class SingleRoomFactory implements RoomFactory {
    @Override
    public Room createRoom(RoomType roomType, int roomNumber, Block block) {
        if (roomType != RoomType.SINGLE) {
            throw new IllegalArgumentException("Invalid room type for SingleRoomFactory");
        }
        int capacity= roomType.getDefaultCapacity();
        return new Room(roomNumber, block, "Single", capacity);
    }
    @Override
    public RoomType getRoomType() {
        return RoomType.SINGLE;
    }
}