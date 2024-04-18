package com.management.hostelease.views.list;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.NumberField;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.router.PageTitle;
import org.springframework.web.client.RestTemplate;

@Route(value = "add-block")
@PageTitle("Add Block | Hostel Management System")
public class AddBlockView extends VerticalLayout {
    public AddBlockView() {
        FormLayout formLayout = new FormLayout();

        TextField blockNameField = new TextField("Block Name");
        NumberField blockPriceField = new NumberField("Block Price");

        formLayout.add(blockNameField, blockPriceField);

        Button addButton = new Button("Add Block", clickEvent -> {
            Block block = new Block();
            block.setName(blockNameField.getValue());
            block.setPrice(blockPriceField.getValue().intValue());
            RestTemplate restTemplate = new RestTemplate();
            restTemplate.postForObject("http://localhost:8080/api/block", block, Block.class);

            Notification.show("Block added successfully");
        });

        formLayout.add(addButton);

        add(formLayout);
    }
}
