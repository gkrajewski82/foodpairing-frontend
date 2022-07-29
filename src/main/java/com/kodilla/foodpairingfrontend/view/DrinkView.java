package com.kodilla.foodpairingfrontend.view;

import com.kodilla.foodpairingfrontend.domain.drink.Drink;
import com.kodilla.foodpairingfrontend.domain.drink.DrinkForm;
import com.kodilla.foodpairingfrontend.domain.drink.DrinkService;
import com.kodilla.foodpairingfrontend.domain.drinkingredient.DrinkIngredient;
import com.kodilla.foodpairingfrontend.domain.drinkingredient.DrinkIngredientForm;
import com.kodilla.foodpairingfrontend.domain.drinkingredient.DrinkIngredientService;
import com.kodilla.foodpairingfrontend.view.component.ButtonBar;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;

@Route("foodpairing/drink")
public class DrinkView extends VerticalLayout {

    private DrinkService drinkService = DrinkService.getInstance();
    private DrinkIngredientService drinkIngredientService = DrinkIngredientService.getInstance();
    private ButtonBar buttonBar = new ButtonBar();
    private Button addNewIngredient = new Button("Add new ingredient");

    private DrinkForm drinkForm = new DrinkForm(this);
    private DrinkIngredientForm drinkIngredientForm = new DrinkIngredientForm(this);

    private Grid<Drink> gridDrink = new Grid<>(Drink.class);
    private Grid<DrinkIngredient> gridDrinkIngredient = new Grid<>(DrinkIngredient.class);

    public DrinkView() {
        add(buttonBar.createButtonBar());

        gridDrink.setColumns("id", "name", "alcoholic", "glass", "instructions");
        HorizontalLayout drinkMainContent = new HorizontalLayout(gridDrink, drinkForm);
        drinkMainContent.setSizeFull();
        gridDrink.setSizeFull();
        add(drinkMainContent);
        drinkForm.setDrink(null);
        setSizeFull();
        refreshDrink();
        gridDrink.asSingleSelect().addValueChangeListener(event -> drinkForm.setDrink(gridDrink.asSingleSelect().getValue()));

        addNewIngredient.addClickListener(e -> {
            gridDrinkIngredient.asSingleSelect().clear();
            drinkIngredientForm.setDrinkIngredient(new DrinkIngredient());
        });
        addNewIngredient.addThemeVariants(ButtonVariant.LUMO_PRIMARY);
        gridDrinkIngredient.setColumns("name", "measure", "drinkId");
        HorizontalLayout drinkIngredientMainContent = new HorizontalLayout(gridDrinkIngredient, drinkIngredientForm);
        drinkIngredientMainContent.setSizeFull();
        gridDrinkIngredient.setSizeFull();
        add(addNewIngredient, drinkIngredientMainContent);
        drinkIngredientForm.setDrinkIngredient(null);
        setSizeFull();
        refreshDrinkIngredient();
        gridDrinkIngredient.asSingleSelect().addValueChangeListener(event -> drinkIngredientForm.setDrinkIngredient(gridDrinkIngredient.asSingleSelect().getValue()));
    }

    public void refreshDrink() {
        gridDrink.setItems(drinkService.getDrinks());
    }

    public void refreshDrinkIngredient() {
        gridDrinkIngredient.setItems(drinkIngredientService.getDrinkIngredients());
    }
}
