package com.kodilla.foodpairingfrontend.view;

import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.Route;

@Route("foodpairing/main")
public class MainView extends VerticalLayout {

    private ButtonBar buttonBar = new ButtonBar();

    public MainView() {
        add(buttonBar.createButtonBar());
        add("Choose your favourite dish, get a random drink to it :) ...... and check how it tastes together......, then...... Comment and rate composition... ");
    }
}