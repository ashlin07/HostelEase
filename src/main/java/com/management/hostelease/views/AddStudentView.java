package com.management.hostelease.views;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.Route;

@Route("addStudent")
public class AddStudentView extends FormLayout {

    private TextField roomDetailsField;
    private TextField studentNameField;
    private Button addButton;

    public AddStudentView() {
        roomDetailsField = new TextField("Room Details");
        studentNameField = new TextField("Student Name");
        addButton = new Button("Add Student");

        addButton.addClickListener(event -> {
            String roomDetails = roomDetailsField.getValue();
            String studentName = studentNameField.getValue();

            // Call the method to add the student here
            // addStudent(roomDetails, studentName);

            Notification.show("Student added successfully");
        });

        add(roomDetailsField, studentNameField, addButton);
    }
}
