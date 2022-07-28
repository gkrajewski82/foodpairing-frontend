package com.kodilla.foodpairingfrontend.view;

import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;

@Route("foodpairing/composition")
public class CompositionView extends VerticalLayout {

    private ButtonBar buttonBar = new ButtonBar();

    public CompositionView() {
        add(buttonBar.createButtonBar());
    }
}
