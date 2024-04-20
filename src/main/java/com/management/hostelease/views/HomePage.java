package com.management.hostelease.views;

import com.vaadin.flow.component.applayout.AppLayout;
import com.vaadin.flow.component.applayout.DrawerToggle;
import com.vaadin.flow.component.html.*;
import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.orderedlayout.FlexComponent;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.login.LoginForm;
import com.vaadin.flow.router.Route;

@Route("homepage")
public class HomePage extends AppLayout {

    public HomePage() {
        H1 title = new H1("Home Page");
        Nav nav = new Nav();
        UnorderedList list = new UnorderedList();

        Anchor roomAnchor = new Anchor("room", "Room");
        roomAnchor.add(new Icon(VaadinIcon.HOME));
        ListItem roomItem = new ListItem(roomAnchor);

        Anchor messAnchor = new Anchor("mess", "Mess");
        messAnchor.add(new Icon(VaadinIcon.BOOK));
        ListItem messItem = new ListItem(messAnchor);

        Anchor attendanceAnchor = new Anchor("attendance", "Attendance");
        attendanceAnchor.add(new Icon(VaadinIcon.CALENDAR));
        ListItem attendanceItem = new ListItem(attendanceAnchor);

        list.add(roomItem, messItem, attendanceItem);
        nav.add(list);

        addToNavbar(new DrawerToggle(), title);
        addToDrawer(nav);

        // Create a layout for the content area
        VerticalLayout contentLayout = new VerticalLayout();

        // Styling for the content layout
        contentLayout.getStyle().set("padding", "20px");
        contentLayout.getStyle().set("text-align", "center");

        // Add the main image
        Image mainImage = new Image("/hostel.jpg", "Main Image");
        mainImage.setWidth("50%"); // Adjust the width as needed
        contentLayout.add(mainImage);

        // Add text content
        H2 welcomeText = new H2("Welcome to PES University Hostel Management System");
        welcomeText.getStyle().set("color", "#333");
        welcomeText.getStyle().set("font-size", "24px");
        welcomeText.getStyle().set("font-weight", "bold");
        welcomeText.getStyle().set("margin-bottom", "10px");

        Paragraph description = new Paragraph("Manage your hostel stay seamlessly. Book your mess, rooms, and give attendance effortlessly.");
        description.getStyle().set("color", "#666");
        description.getStyle().set("font-size", "18px");

        // Add buttons
        Button bookMessButton = new Button("Book Mess");
        Button bookRoomButton = new Button("Book Room");
        Button attendanceButton = new Button("Attendance");

        // Style the buttons
        bookMessButton.getStyle().set("background-color", "#4CAF50");
        bookMessButton.getStyle().set("color", "white");
        bookMessButton.getStyle().set("padding", "10px 24px");
        bookMessButton.getStyle().set("text-align", "center");
        bookMessButton.getStyle().set("text-decoration", "none");
        bookMessButton.getStyle().set("display", "inline-block");
        bookMessButton.getStyle().set("font-size", "16px");
        bookMessButton.getStyle().set("margin", "4px 2px");
        bookMessButton.getStyle().set("cursor", "pointer");
        bookMessButton.getStyle().set("border-radius", "12px");

        bookRoomButton.getStyle().set("background-color", "#008CBA");
        bookRoomButton.getStyle().set("color", "white");
        bookRoomButton.getStyle().set("padding", "10px 24px");
        bookRoomButton.getStyle().set("text-align", "center");
        bookRoomButton.getStyle().set("text-decoration", "none");
        bookRoomButton.getStyle().set("display", "inline-block");
        bookRoomButton.getStyle().set("font-size", "16px");
        bookRoomButton.getStyle().set("margin", "4px 2px");
        bookRoomButton.getStyle().set("cursor", "pointer");
        bookRoomButton.getStyle().set("border-radius", "12px");

        attendanceButton.getStyle().set("background-color", "#f44336");
        attendanceButton.getStyle().set("color", "white");
        attendanceButton.getStyle().set("padding", "10px 24px");
        attendanceButton.getStyle().set("text-align", "center");
        attendanceButton.getStyle().set("text-decoration", "none");
        attendanceButton.getStyle().set("display", "inline-block");
        attendanceButton.getStyle().set("font-size", "16px");
        attendanceButton.getStyle().set("margin", "4px 2px");
        attendanceButton.getStyle().set("cursor", "pointer");
        attendanceButton.getStyle().set("border-radius", "12px");

        // Add login form
        LoginForm loginForm = new LoginForm();

        // Create a layout for the buttons
        HorizontalLayout buttonsLayout = new HorizontalLayout();
        buttonsLayout.add(bookMessButton, bookRoomButton, attendanceButton);
        buttonsLayout.setAlignItems(FlexComponent.Alignment.CENTER);

        // Create a layout for the login form
        VerticalLayout loginFormLayout = new VerticalLayout();
        loginFormLayout.add(loginForm);
        loginFormLayout.setAlignItems(FlexComponent.Alignment.CENTER);

        // Add components to content layout
        contentLayout.add(welcomeText, description, buttonsLayout, loginFormLayout);

        // Add content layout to the page
        setContent(contentLayout);
    }
}
