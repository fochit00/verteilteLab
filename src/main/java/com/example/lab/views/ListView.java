package com.example.lab.views;

import com.example.lab.data.Concert;
import com.example.lab.data.services.CrmService;
import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.html.H2;
import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.component.html.Paragraph;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.renderer.ComponentRenderer;
import com.vaadin.flow.data.value.ValueChangeMode;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.router.RouteParameters;
import com.vaadin.flow.theme.lumo.LumoUtility;

@PageTitle("concerts")
@Route(value = "")
public class ListView extends VerticalLayout {

    Grid<Concert> grid = new Grid<>(Concert.class);
    CrmService service;

    TextField filterText = new TextField();

    public ListView(CrmService service) {
        this.service = service;
        addClassName("list-view");
        setSizeFull();
        configureGrid();

        add(getContent());
        updateList();

    }

    private Component getContent() {
        HorizontalLayout content = new HorizontalLayout(grid);
        content.setFlexGrow(1, grid);
        content.addClassNames("content");
        content.setSizeFull();
        return content;
    }

    private void configureGrid() {
        grid.addClassNames("contact-grid");
        grid.setSizeFull();
        grid.setColumns("name");
        grid.addColumn(concert -> concert.getCity()).setHeader("City");
        grid.addColumn(concert -> concert.getDate()).setHeader("Date");
        grid.addColumn(
                new ComponentRenderer<>(Button::new, (button, concert) -> {
                    button.setText("Details");
                    button.addClickListener(e -> button.getUI().ifPresent(ui ->
                            ui.navigate(ConcertDetails.class, new RouteParameters("id", concert.getId().toString()))
                            ));
                }));
        grid.getColumns().forEach(col -> col.setAutoWidth(true));
    }
    private void updateList() {
        grid.setItems(service.findAllConcerts(filterText.getValue()));
    }
}

