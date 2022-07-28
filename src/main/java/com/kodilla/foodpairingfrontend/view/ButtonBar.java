package com.kodilla.foodpairingfrontend.view;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;

public class ButtonBar {

    public HorizontalLayout createButtonBar() {
        Button main = new Button("Main page");
        Button dish = new Button("Dishes");
        Button drink = new Button("Drinks");
        Button composition = new Button("Compositions");
        Button commentAndRating = new Button("Comments and ratings");

        main.addThemeVariants(ButtonVariant.LUMO_PRIMARY, ButtonVariant.LUMO_CONTRAST);
        dish.addThemeVariants(ButtonVariant.LUMO_PRIMARY, ButtonVariant.LUMO_CONTRAST);
        drink.addThemeVariants(ButtonVariant.LUMO_PRIMARY, ButtonVariant.LUMO_CONTRAST);
        composition.addThemeVariants(ButtonVariant.LUMO_PRIMARY, ButtonVariant.LUMO_CONTRAST);
        commentAndRating.addThemeVariants(ButtonVariant.LUMO_PRIMARY, ButtonVariant.LUMO_CONTRAST);

        HorizontalLayout buttons = new HorizontalLayout(main, dish, drink, composition, commentAndRating);
        main.addClickListener(event -> main.getUI().ifPresent(ui -> ui.navigate("foodpairing/main")));
        dish.addClickListener(event -> dish.getUI().ifPresent(ui -> ui.navigate("foodpairing/dish")));
        drink.addClickListener(event -> drink.getUI().ifPresent(ui -> ui.navigate("foodpairing/drink")));
        composition.addClickListener(event -> composition.getUI().ifPresent(ui -> ui.navigate("foodpairing/composition")));
         commentAndRating.addClickListener(event -> commentAndRating.getUI().ifPresent(ui -> ui.navigate("foodpairing/commentandrating")));
        return buttons;
    }

}
