package com.management.hostelease.services;
import com.management.hostelease.model.Block;
import com.management.hostelease.repository.BlockRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BlockServiceImp implements BlockService {
    @Autowired
    private BlockRepository blockRepository;

    @Override
    public List<Block> getAllBlocks() {
        return blockRepository.findAll();
    }

    @Override
    public Block addBlock(Block block) {
        return blockRepository.save(block);
    }

    @Override
    public Block updateBlock(Block block) {
        Optional<Block> existingBlock = blockRepository.findById(block.getId());
        if (existingBlock.isPresent()) {
            return blockRepository.save(block);
        } else {
            throw new RuntimeException("Block not found with id: " + block.getId());
        }
    }

    @Override
    public void deleteBlock(int id) {
        blockRepository.deleteById(id);
    }
}