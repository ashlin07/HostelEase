package com.management.hostelease.views.list;

import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.html.Paragraph;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.router.PageTitle;

@Route(value = "")
@PageTitle("Home | Hostel Management System")
public class HomePage extends VerticalLayout {
    public HomePage() {
        H1 title = new H1("Welcome to the Hostel Management System");
        Paragraph welcomeText = new Paragraph("Manage your hostel rooms, mess, and more efficiently.");

        Button roomManagementButton = new Button("Manage Rooms", event -> {
            UI.getCurrent().navigate(RoomListView.class);// Navigate to Room Management Page
        });
        Button bookingManagementButton = new Button("BookRoom", event -> {
            UI.getCurrent().navigate(BookingView.class);// Navigate to Room Management Page
        });

        Button messManagementButton = new Button("Manage Mess", event -> {
            UI.getCurrent().navigate(MessView.class);
        });

        add(title, welcomeText, roomManagementButton, messManagementButton,bookingManagementButton);
    }
}