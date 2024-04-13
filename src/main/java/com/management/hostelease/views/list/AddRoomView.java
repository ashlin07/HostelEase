package com.management.hostelease.views.list;


import com.management.hostelease.model.Room;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.NumberField;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.router.PageTitle;
import org.springframework.web.client.RestTemplate;

@Route(value = "add-room")
@PageTitle("Add Room | Hostel Management System")
public class AddRoomView extends VerticalLayout {
    public AddRoomView() {
        FormLayout formLayout = new FormLayout();

        TextField roomNameField = new TextField("Room Name");
        TextField roomTypeField = new TextField("Room Type");
        NumberField roomPriceField = new NumberField("Room Price");
        NumberField roomCapacityField = new NumberField("Room Capacity");

        formLayout.add(roomNameField, roomTypeField, roomPriceField,roomCapacityField);

        Button addButton = new Button("Add Room", clickEvent -> {
            Room room = new Room();
            room.setRoomNumber(roomNameField.getValue());
            room.setRoomType(roomTypeField.getValue());
            room.setRoomPrice(roomPriceField.getValue().intValue());
            room.setBooked(false);
            room.setRoomCapacity(roomCapacityField.getValue().intValue());
            RestTemplate restTemplate = new RestTemplate();
            restTemplate.postForObject("http://localhost:8080/api/room", room, Room.class);

            Notification.show("Room added successfully");
        });

        formLayout.add(addButton);

        add(formLayout);
    }
}
