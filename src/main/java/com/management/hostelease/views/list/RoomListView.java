package com.management.hostelease.views.list;
import com.management.hostelease.model.Room;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.router.PageTitle;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

@Route(value = "rooms")
@PageTitle("Rooms | Hostel Management System")
public class RoomListView extends VerticalLayout {

    public RoomListView() {
        RestTemplate restTemplate = new RestTemplate();
        List<Room> rooms = Arrays.asList(Objects.requireNonNull(restTemplate.getForObject("http://localhost:8080/api/room", Room[].class)));
        Grid<Room> grid = new Grid<>(Room.class);
        grid.setItems(rooms);
        add(grid);
    }
}
