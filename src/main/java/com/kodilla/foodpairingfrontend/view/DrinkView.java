package com.kodilla.foodpairingfrontend.view;

import com.kodilla.foodpairingfrontend.domain.drink.Drink;
import com.kodilla.foodpairingfrontend.domain.drink.DrinkForm;
import com.kodilla.foodpairingfrontend.domain.drink.DrinkService;
import com.kodilla.foodpairingfrontend.view.component.ButtonBar;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;

@Route("foodpairing/drink")
public class DrinkView extends VerticalLayout {

    private DrinkService drinkService = DrinkService.getInstance();
    private ButtonBar buttonBar = new ButtonBar();

    private DrinkForm drinkForm = new DrinkForm(this);

    private Grid<Drink> gridDrink = new Grid<>(Drink.class);

    public DrinkView() {
        add(buttonBar.createButtonBar());

        gridDrink.setColumns("name", "alcoholic", "glass", "instructions");
        HorizontalLayout drinkMainContent = new HorizontalLayout(gridDrink, drinkForm);
        drinkMainContent.setSizeFull();
        gridDrink.setSizeFull();
        add(drinkMainContent);
        drinkForm.setDrink(null);
        setSizeFull();
        refreshDrink();
        gridDrink.asSingleSelect().addValueChangeListener(event -> drinkForm.setDrink(gridDrink.asSingleSelect().getValue()));
    }

    public void refreshDrink() {
        gridDrink.setItems(drinkService.getDrinks());
    }
}
