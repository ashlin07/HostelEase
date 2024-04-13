package com.management.hostelease.controllers;

import com.management.hostelease.model.Block;
import com.management.hostelease.services.BlockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class BlockController {

    @Autowired
    private BlockService blockService;

    @GetMapping("/block")
    public List<Block> getAllBlocks() {
        return blockService.getAllBlocks();
    }

    @PostMapping("/block")
    public Block addBlock(@RequestBody Block block) {
        return blockService.addBlock(block);
    }
}