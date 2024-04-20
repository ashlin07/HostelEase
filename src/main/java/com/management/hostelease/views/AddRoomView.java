package com.management.hostelease.views;

import com.management.hostelease.model.RoomType;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.select.Select;
import com.vaadin.flow.component.textfield.NumberField;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.Route;

@Route("addRoom")
public class AddRoomView extends FormLayout {

    private TextField blockNameField;
    private Select<RoomType> roomTypeSelect;
    private NumberField roomNumberField;
    private NumberField capacityField;
    private Button addButton;

    public AddRoomView() {
        blockNameField = new TextField("Block Name");
        roomTypeSelect = new Select<>();
        roomTypeSelect.setItems(RoomType.values());
        roomNumberField = new NumberField("Room Number");
        capacityField = new NumberField("Capacity");
        addButton = new Button("Add Room");

        addButton.addClickListener(event -> {
            String blockName = blockNameField.getValue();
            RoomType roomType = roomTypeSelect.getValue();
            int roomNumber = roomNumberField.getValue().intValue();
            int capacity = capacityField.getValue().intValue();

            // Call the method to add the room here
            // addRoom(blockName, roomType, roomNumber, capacity);

            Notification.show("Room added successfully");
        });

        add(blockNameField, roomTypeSelect, roomNumberField, capacityField, addButton);
    }
}