package com.management.hostelease.views.list;


import com.management.hostelease.model.Block;
import com.management.hostelease.model.Room;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.combobox.ComboBox;
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

        TextField roomNumberField = new TextField("Room Number");
        ComboBox<String> roomTypeField = new ComboBox<>("Room Type");
        roomTypeField.setItems("3 sharing", "2 sharing", "single");
        NumberField roomCapacityField = new NumberField("Room Capacity");

        RestTemplate restTemplate = new RestTemplate();
        Block[] blocks = restTemplate.getForObject("http://localhost:8080/api/block", Block[].class);
        ComboBox<Block> blockField = new ComboBox<>("Block");
        blockField.setItems(blocks);
        blockField.setItemLabelGenerator(Block::getName); // Assuming Block has a getName method

        formLayout.add(roomNumberField, roomTypeField, roomCapacityField, blockField);

        Button addButton = new Button("Add Room", clickEvent -> {
            Room room = new Room();
            room.setRoomNumber(roomNumberField.getValue());
            room.setRoomType(roomTypeField.getValue());
            room.setRoomCapacity(roomCapacityField.getValue().intValue());
            room.setBlock(blockField.getValue());

            restTemplate.postForObject("http://localhost:8080/api/room", room, Room.class);

            Notification.show("Room added successfully");
        });

        formLayout.add(addButton);

        add(formLayout);
    }
}
