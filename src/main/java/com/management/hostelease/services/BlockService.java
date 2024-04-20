package com.management.hostelease.services;

import com.management.hostelease.model.Block;
import com.management.hostelease.model.Room;

import java.util.List;

public interface BlockService {
    void addRoom(Block block, Room room);
    Block getBlockByName(String blockName);
}
