package com.example.lab.views;

import com.example.lab.data.Concert;
import com.example.lab.data.services.CrmService;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.html.H2;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.orderedlayout.FlexComponent;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.BeforeEnterEvent;
import com.vaadin.flow.router.BeforeEnterObserver;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;

import java.awt.*;
import java.util.Optional;

@PageTitle("details")
@Route(value = "details/:id?")
public class ConcertDetails extends Div implements BeforeEnterObserver{

    private String id;
    H1 name = new H1();
    H2 location = new H2();
    H2 date = new H2();
    H2 tickets = new H2();
    H2 time = new H2();

    Div outer = new Div();

    Button returnButton = new Button("Return to overview");
    VerticalLayout allElements = new VerticalLayout();
    private Optional<Concert> concert;

    CrmService service;

    @Override
    public void beforeEnter(BeforeEnterEvent event) {
        id = event.getRouteParameters().get("id").orElseThrow();
        concert = service.findConcertById(Long.valueOf(id));
        configureDetails(concert);
    }


    public ConcertDetails(CrmService service) {
        this.service =service;
        returnButton.addClickListener(e -> returnButton.getUI().ifPresent(ui ->
                ui.navigate("")));
        allElements.setAlignItems(FlexComponent.Alignment.CENTER);
        allElements.add(name, location, date, time, tickets, returnButton);
        outer.setClassName("outer");
        outer.add(allElements);

        add(outer);
    }

    private void configureDetails(Optional<Concert> concert){
        name.setText(concert.get().getName());
        location.setText(concert.get().getLocation());
        date.setText(concert.get().getDate());
        tickets.setText(String.valueOf(concert.get().getTickets())+" Tickets available");
        time.setText("At "+concert.get().getTime());
    }

}
