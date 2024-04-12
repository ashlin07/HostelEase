package com.management.hostelease.services;

import com.management.hostelease.repository.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class RoomServiceImp implements RoomService{
    @Autowired
    private RoomRepository RoomRepository;
}
