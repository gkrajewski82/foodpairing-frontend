package com.kodilla.foodpairingfrontend.view;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;

@Route("foodpairing")
public class MainView extends VerticalLayout {

    ButtonBar buttonBar = new ButtonBar();

    public MainView() {
        add(buttonBar.createButtonBar());
    }

}