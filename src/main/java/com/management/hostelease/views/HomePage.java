package com.management.hostelease.views;

import com.vaadin.flow.component.applayout.AppLayout;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.html.Nav;
import com.vaadin.flow.component.html.UnorderedList;
import com.vaadin.flow.component.html.ListItem;
import com.vaadin.flow.component.html.Anchor;
import com.vaadin.flow.router.Route;

@Route("/homepage")
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

        addToNavbar(title);
        setContent(nav);
    }
}