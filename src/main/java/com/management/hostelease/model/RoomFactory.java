package com.management.hostelease.model;

public interface RoomFactory {
    Room createRoom(RoomType roomType, int roomNumber, Block block);
    RoomType getRoomType();
}
