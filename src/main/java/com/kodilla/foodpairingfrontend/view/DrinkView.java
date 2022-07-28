package com.kodilla.foodpairingfrontend.view;

import com.kodilla.foodpairingfrontend.view.component.ButtonBar;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;

@Route("foodpairing/drink")
public class DrinkView extends VerticalLayout {

    private ButtonBar buttonBar = new ButtonBar();

    public DrinkView() {
        add(buttonBar.createButtonBar());
    }
}
