package com.management.hostelease.views.list;

import com.management.hostelease.model.Student;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.router.PageTitle;
import org.springframework.web.client.RestTemplate;

@Route(value = "addStudent")
@PageTitle("Add Student | Hostel Management System")
public class AddStudentView extends FormLayout {

    private TextField nameField;
    private TextField srnField;
    private TextField departmentField;
    private Button saveButton;
    private RestTemplate restTemplate;

    public AddStudentView() {
        restTemplate = new RestTemplate();
        nameField = new TextField("Name");
        srnField = new TextField("SRN");
        departmentField = new TextField("Department");
        saveButton = new Button("Save", clickEvent -> saveStudent());

        add(nameField, srnField, departmentField, saveButton);
    }

    private void saveStudent() {
        Student student = new Student();
        student.setName(nameField.getValue());
        student.setSRN(srnField.getValue());
        student.setDepartment(departmentField.getValue());
        restTemplate.postForObject("http://localhost:8080/api/student", student, Student.class);
    }
}