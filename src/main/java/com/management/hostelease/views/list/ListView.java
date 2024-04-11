package com.management.hostelease.views.list;


import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.datepicker.DatePicker;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;

@Route(value = "")
@PageTitle("Contacts | Vaadin CRM")
public class ListView extends VerticalLayout {
    public ListView() {
        Button button = new Button("I'm a button");
        HorizontalLayout layout = new HorizontalLayout(button, new DatePicker("Pick a date"));
        add(layout);
    }

}