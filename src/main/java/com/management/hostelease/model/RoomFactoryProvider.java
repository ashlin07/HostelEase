package com.management.hostelease.model;

import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

@Component
public class RoomFactoryProvider {
    private final Map<RoomType, RoomFactory> roomFactories;

    public RoomFactoryProvider(List<RoomFactory> roomFactories) {
        this.roomFactories = roomFactories.stream()
                .collect(Collectors.toMap(RoomFactory::getRoomType, Function.identity()));
    }

    public RoomFactory getRoomFactory(RoomType roomType) {
        return roomFactories.get(roomType);
    }
}