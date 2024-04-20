package com.management.hostelease.services;

import com.management.hostelease.model.Block;
import com.management.hostelease.model.Room;
import com.management.hostelease.repository.BlockRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BlockServiceImp implements BlockService {
    @Autowired
    private  BlockRepository blockRepository;

    @Override
    public void addRoom(Block block, Room room) {
        // Implementation goes here
        block.addRoom(room);
        blockRepository.save(block);
    }
    public Block getBlockByName(String blockName) {

        return blockRepository.findByName(blockName);
    }
}