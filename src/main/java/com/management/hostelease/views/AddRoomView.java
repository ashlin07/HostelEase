package com.management.hostelease.views;

import com.management.hostelease.model.Block;
import com.management.hostelease.model.Room;
import com.management.hostelease.model.RoomType;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.combobox.ComboBox;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.select.Select;
import com.vaadin.flow.component.textfield.NumberField;
import com.vaadin.flow.data.renderer.TextRenderer;
import com.vaadin.flow.router.Route;
import org.springframework.web.client.RestTemplate;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;

import java.util.List;

@Route("addRoom")
public class AddRoomView extends FormLayout {

    private ComboBox<Block> blockNameField;
    private Select<RoomType> roomTypeSelect;
    private NumberField roomNumberField;
    private NumberField capacityField;
    private Button addButton;

    public AddRoomView() {
        blockNameField = new ComboBox<>("Block Name");
        blockNameField.setItemLabelGenerator(Block::getName); // Assuming Block has a getName method
        blockNameField.setItems(getAllBlocks());

        roomTypeSelect = new Select<>();
        roomTypeSelect.setLabel("Room Type");
        roomTypeSelect.setItems(RoomType.values());

        roomNumberField = new NumberField("Room Number");

        addButton = new Button("Add Room");

        addButton.addClickListener(event -> {
            String blockName = blockNameField.getValue().getName();
            RoomType roomType = roomTypeSelect.getValue();
            int roomNumber = roomNumberField.getValue().intValue();

            RestTemplate restTemplate = new RestTemplate();
            String url = "http://localhost:8080/api/room?blockName=" + blockName + "&roomType=" + roomType + "&roomNumber=" + roomNumber;
            restTemplate.postForObject(url, null, Room.class);



            Notification.show("Room added successfully");
        });

        add(blockNameField, roomTypeSelect, roomNumberField,  addButton);
    }

    private List<Block> getAllBlocks() {
        RestTemplate restTemplate = new RestTemplate();
        String url = "http://localhost:8080/api/blocks"; // Replace with your actual URL
        ResponseEntity<List<Block>> response = restTemplate.exchange(
                url,
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<List<Block>>() {}
        );
        return response.getBody();
    }
}