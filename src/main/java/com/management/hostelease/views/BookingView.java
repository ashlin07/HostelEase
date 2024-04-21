package com.management.hostelease.views;

import com.management.hostelease.model.Payment;
import com.management.hostelease.model.Room;
import com.management.hostelease.services.RoomService;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.dialog.Dialog;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.select.Select;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.router.PageTitle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Route(value ="booking")
@PageTitle("Booking | Hostel Management System")
public class BookingView extends VerticalLayout {


    private final Grid<Room> grid;
    private final RestTemplate restTemplate;



    public BookingView() {
        this.grid = new Grid<>(Room.class);
        this.restTemplate = new RestTemplate();
        add(grid);
        listAvailableRooms();
    }

    private void listAvailableRooms() {

        Room[] rooms = restTemplate.getForObject("http://localhost:8080/api/room/showAvailable", Room[].class);
        List<Room> availableRooms = Arrays.asList(rooms != null ? rooms : new Room[0]);
        grid.setItems(availableRooms);
        grid.addColumn(room -> room.getBlock().getPrice()).setHeader("Block Price");
        grid.addComponentColumn(this::createBookButton);
    }
    private Button createBookButton(Room room) {
        return new Button("Book", clickEvent -> {
            Dialog paymentDialog = new Dialog();
            FormLayout paymentForm = new FormLayout();

            TextField studentIdField = new TextField("Student ID");
            Select<String> formOfPaymentField = new Select<>();
            formOfPaymentField.setLabel("Form of Payment");
            formOfPaymentField.setItems("UPI", "Credit", "Debit");

            Button submitButton = new Button("Submit", event -> {
                Payment payment = new Payment();
                payment.setRoomId(room.getId());
                payment.setStudentId(Integer.parseInt(studentIdField.getValue()));
                payment.setFormOfPayment(formOfPaymentField.getValue());
                RestTemplate restTemplate=new RestTemplate();
                restTemplate.postForObject("http://localhost:8080/api/room/book", payment, Void.class);
                paymentDialog.close();
            });

            paymentForm.add(studentIdField, formOfPaymentField, submitButton);
            paymentDialog.add(paymentForm);
            paymentDialog.open();
        });
    }

}