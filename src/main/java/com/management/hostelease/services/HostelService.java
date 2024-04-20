package com.management.hostelease.services;

import com.management.hostelease.model.Block;
import com.management.hostelease.model.Hostel;

public interface HostelService {
    Hostel addBlock(Hostel hostel, Block block);
    Hostel removeBlock(Hostel hostel, Block block);
}
