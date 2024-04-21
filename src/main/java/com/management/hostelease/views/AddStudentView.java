package com.management.hostelease.views;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.Route;
import org.springframework.web.client.RestTemplate;

@Route("addStudent")
public class AddStudentView extends FormLayout {
    private TextField nameField = new TextField("Name");
    private TextField srnField = new TextField("SRN");
    private TextField departmentField = new TextField("Department");

    private Button submitButton = new Button("Submit");

    public AddStudentView() {
        add(nameField, srnField, departmentField, submitButton);

        submitButton.addClickListener(event -> {
            String name = nameField.getValue();
            int srn = Integer.parseInt(srnField.getValue());
            String department = departmentField.getValue();

            RestTemplate restTemplate = new RestTemplate();
            String url = "http://localhost:8080/api/addStudent?name=" + name + "&srn=" + srn + "&department=" + department;
            restTemplate.postForObject(url, null, Void.class);


            Notification.show("Student added successfully");
        });
    }
}
