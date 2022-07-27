package com.kodilla.foodpairingfrontend.view;

import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;

@Route("foodpairing/commentandrating")
public class CommentRatingView extends VerticalLayout {

    ButtonBar buttonBar = new ButtonBar();

    public CommentRatingView() {
        add(buttonBar.createButtonBar());
    }
}
