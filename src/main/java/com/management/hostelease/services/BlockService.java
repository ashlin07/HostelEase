package com.management.hostelease.services;

import com.management.hostelease.model.Block;

import java.util.List;

public interface BlockService {
    public List<Block> getAllBlocks();
    public Block addBlock(Block block);

    public Block updateBlock(Block block);
    public void deleteBlock(int id);
}
