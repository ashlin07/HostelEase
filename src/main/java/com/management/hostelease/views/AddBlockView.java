package com.management.hostelease.views;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.textfield.NumberField;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.Route;
import org.springframework.web.client.RestTemplate;

@Route("addBlock")
public class AddBlockView extends FormLayout {

    private TextField blockNameField;
    private NumberField priceField;
    private Button addButton;
    private final RestTemplate restTemplate;

    public AddBlockView() {
        blockNameField = new TextField("Block Name");
        priceField = new NumberField("Price");
        addButton = new Button("Add Block");
        this.restTemplate=new RestTemplate();

        addButton.addClickListener(event -> {
            String blockName = blockNameField.getValue();
            int price = priceField.getValue().intValue();

            restTemplate.postForObject("http://localhost:8080/api/block?blockName="+blockName+"&price="+price, null, String.class);

            Notification.show("Block added successfully");
        });

        add(blockNameField, priceField, addButton);
    }
}