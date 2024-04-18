package com.management.hostelease.views.list;

import com.management.hostelease.services.BlockService;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.router.PageTitle;
import org.springframework.beans.factory.annotation.Autowired;

@Route(value = "blocks")
@PageTitle("Blocks | Hostel Management System")
public class BlockView extends VerticalLayout {

    private final BlockService blockService;
    private final Grid<Block> grid;

    @Autowired
    public BlockView(BlockService blockService) {
        this.blockService = blockService;
        this.grid = new Grid<>(Block.class);
        add(grid);
        listBlocks();
    }

    private void listBlocks() {
        grid.setItems(blockService.getAllBlocks());
    }
}
