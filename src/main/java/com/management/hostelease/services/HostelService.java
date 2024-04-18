package com.management.hostelease.services;

import com.management.hostelease.model.Block;
import com.management.hostelease.model.Hostel;

public interface HostelService {
    void addBlock(Hostel hostel, Block block);
    void removeBlock(Hostel hostel, Block block);
}
