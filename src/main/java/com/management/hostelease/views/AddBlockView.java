package com.management.hostelease.views;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.textfield.NumberField;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.Route;

@Route("addBlock")
public class AddBlockView extends FormLayout {

    private TextField blockNameField;
    private NumberField priceField;
    private Button addButton;

    public AddBlockView() {
        blockNameField = new TextField("Block Name");
        priceField = new NumberField("Price");
        addButton = new Button("Add Block");

        addButton.addClickListener(event -> {
            String blockName = blockNameField.getValue();
            int price = priceField.getValue().intValue();

            // Call the method to add the block here
            // addBlock(blockName, price);

            Notification.show("Block added successfully");
        });

        add(blockNameField, priceField, addButton);
    }
}