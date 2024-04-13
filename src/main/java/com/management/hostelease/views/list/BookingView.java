package com.management.hostelease.views.list;

import com.management.hostelease.model.Room;
import com.management.hostelease.services.RoomService;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.router.PageTitle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
/* private Button createBookButton(Room room) {
    return new Button("Book", clickEvent -> {
        restTemplate.postForObject("http://localhost:8080/api/bookRoom", room.getId(), Void.class);
    });
} */
@Route(value = "booking")
@PageTitle("Booking | Hostel Management System")
public class BookingView extends VerticalLayout {

    private final RoomService roomService;
    private final Grid<Room> grid;
    private final RestTemplate restTemplate;

    @Autowired
    public BookingView(RoomService roomService, RestTemplate restTemplate) {
        this.roomService = roomService;
        this.restTemplate = restTemplate;
        this.grid = new Grid<>(Room.class);
        add(grid);
        listAvailableRooms();
    }

    private void listAvailableRooms() {
        Room[] rooms = restTemplate.getForObject("http://localhost:8080/api/availableRooms", Room[].class);
        List<Room> availableRooms = Arrays.asList(rooms != null ? rooms : new Room[0]);
        grid.setItems(availableRooms);
        grid.addComponentColumn(this::createBookButton);
    }
    private Button createBookButton(Room room) {
        return new Button("Book", clickEvent -> {
            restTemplate.postForObject("http://localhost:8080/api/bookRoom", room.getId(), Void.class);
        });
    }

}