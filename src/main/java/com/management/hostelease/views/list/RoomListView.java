package com.management.hostelease.views.list;
import com.management.hostelease.model.Room;
import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.router.PageTitle;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Route(value = "rooms")
@PageTitle("Rooms | Hostel Management System")
public class RoomListView extends VerticalLayout {

    public RoomListView() {
        RestTemplate restTemplate = new RestTemplate();
        List<Room> rooms = Arrays.asList(Objects.requireNonNull(restTemplate.getForObject("http://localhost:8080/api/room", Room[].class)));
        Grid<Room> grid = new Grid<>();
        grid.setItems(rooms);

        grid.addColumn(Room::getId).setHeader("ID");
        grid.addColumn(Room::getRoomNumber).setHeader("Room Number");
        grid.addColumn(Room::getRoomType).setHeader("Room Type");
        grid.addColumn(Room::getRoomCapacity).setHeader("Room Capacity");
        grid.addColumn(room -> room.getBlock().getName()).setHeader("Block");
        grid.addColumn(room -> room.getBlock().getPrice()).setHeader("Price");
        grid.addColumn(room -> room.isBooked() ? "Not Available" : "Available").setHeader("Availability");
        grid.addColumn(room -> room.getStudents() != null ? String.join(", ", room.getStudents()) : "Not Booked").setHeader("Student Names");
        Button addRoomButton = new Button("Add Rooms", event -> {
            UI.getCurrent().navigate(AddRoomView.class);// Navigate to Room Management Page
        });
        add(grid,addRoomButton);
    }
}
