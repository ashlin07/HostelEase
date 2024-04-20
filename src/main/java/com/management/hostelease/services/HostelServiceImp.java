package com.management.hostelease.services;

import com.management.hostelease.model.Block;
import com.management.hostelease.model.Hostel;
import com.management.hostelease.repository.HostelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class HostelServiceImp implements HostelService{
    @Autowired
    private HostelRepository hostelRepository;
    public Hostel addBlock(Hostel hostel, Block block) {
        // Implementation goes here
        hostel.addBlock(block);
        return hostelRepository.save(hostel);
    }

    public Hostel removeBlock(Hostel hostel, Block block) {
        // Implementation goes here
        hostel.removeBlock(block);
        return hostelRepository.save(hostel);
    }
}
