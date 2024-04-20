package com.management.hostelease.views;

import com.vaadin.flow.component.applayout.AppLayout;
import com.vaadin.flow.component.applayout.DrawerToggle;
import com.vaadin.flow.component.html.*;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;

@Route("homepage")
public class HomePage extends AppLayout {

    public HomePage() {
        H1 title = new H1("Home Page");
        Nav nav = new Nav();
        UnorderedList list = new UnorderedList();

        ListItem roomItem = new ListItem(new Anchor("room", "Room"));
        ListItem messItem = new ListItem(new Anchor("mess", "Mess"));
        ListItem attendanceItem = new ListItem(new Anchor("attendance", "Attendance"));

        list.add(roomItem, messItem, attendanceItem);
        nav.add(list);

        addToNavbar(new DrawerToggle(), title);
        addToDrawer(nav);

        // Create a layout for the content area
        VerticalLayout contentLayout = new VerticalLayout();

        // Styling for the content layout
        contentLayout.getStyle().set("padding", "20px");

        // Create a layout for the image and content
        Div imageAndContentLayout = new Div();

        // Styling for the image and content layout
        imageAndContentLayout.getStyle().set("display", "flex");
        imageAndContentLayout.getStyle().set("justify-content", "space-between");
        imageAndContentLayout.getStyle().set("align-items", "center");
        imageAndContentLayout.getStyle().set("padding-bottom", "20px");

        // Add the main image
        Image mainImage = new Image("/hostel.jpg", "Main Image");
        mainImage.setWidth("50%"); // Adjust the width as needed
        imageAndContentLayout.add(mainImage);

        // Create a layout for the text content
        Div textContentLayout = new Div();

        // Styling for the text content layout
        textContentLayout.getStyle().set("flex-grow", "1");
        textContentLayout.getStyle().set("padding", "20px");

        // Add text content
        H2 welcomeText = new H2("Welcome to PES University Hostel Management System");

        // Styling for the welcome text
        welcomeText.getStyle().set("color", "#333");
        welcomeText.getStyle().set("font-size", "24px");
        welcomeText.getStyle().set("font-weight", "bold");
        welcomeText.getStyle().set("margin-bottom", "10px");

        Paragraph description = new Paragraph("Manage your hostel stay seamlessly. Book your mess, rooms, and give attendance effortlessly.");

        // Styling for the description
        description.getStyle().set("color", "#666");
        description.getStyle().set("font-size", "18px");

        textContentLayout.add(welcomeText, description);

        // Add the text content layout to the main layout
        imageAndContentLayout.add(textContentLayout);

        // Add the image and content layout to the content layout
        contentLayout.add(imageAndContentLayout);

        // Set the content layout as the content of the page
        setContent(contentLayout);
    }
}
