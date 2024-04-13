package com.management.hostelease.views.list;

import com.management.hostelease.model.Mess;
import com.management.hostelease.services.MessService;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.binder.Binder;
import com.vaadin.flow.router.Route;
import org.springframework.beans.factory.annotation.Autowired;

@Route("messes")
public class MessView extends VerticalLayout {

    private final MessService messService;
    private final Grid<Mess> grid = new Grid<>(Mess.class);
    private final TextField messName = new TextField("Mess Name");
    private final TextField messType = new TextField("Mess Type");
    private final Button saveButton = new Button("Save");

    private final Binder<Mess> binder = new Binder<>(Mess.class);

    @Autowired
    public MessView(MessService messService) {
        this.messService = messService;
        configureGrid();
        configureBinder();
        configureSaveButton();

        add(messName, messType, saveButton, grid);
        updateGrid();
    }

    private void configureGrid() {
        grid.setColumns("id", "messName", "messType");
        grid.setSizeFull();
    }

    private void configureBinder() {
        binder.bindInstanceFields(this);
    }

    private void configureSaveButton() {
        saveButton.addClickListener(event -> {
            Mess newMess = new Mess(messName.getValue(), messType.getValue());
            messService.addMess(newMess);
            updateGrid();
            clearForm();
        });
    }

    private void updateGrid() {
        grid.setItems(messService.getAllMesses());
    }

    private void clearForm() {
        binder.setBean(null);
        messName.clear();
        messType.clear();
    }
}