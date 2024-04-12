package com.management.hostelease.views.list;

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
            // Navigate to Room Management Page
        });

        Button messManagementButton = new Button("Manage Mess", event -> {
            // Navigate to Mess Management Page
        });

        add(title, welcomeText, roomManagementButton, messManagementButton);
    }
}