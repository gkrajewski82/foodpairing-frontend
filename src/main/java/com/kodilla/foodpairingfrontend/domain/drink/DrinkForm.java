package com.kodilla.foodpairingfrontend.domain.drink;

import com.kodilla.foodpairingfrontend.domain.drinkingredient.DrinkIngredientService;
import com.kodilla.foodpairingfrontend.view.DrinkView;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.binder.Binder;

public class DrinkForm extends FormLayout {

    private DrinkView drinkView;
    private DrinkService drinkService = DrinkService.getInstance();
    private DrinkIngredientService drinkIngredientService = DrinkIngredientService.getInstance();


    private TextField name = new TextField("Name");
    private TextField alcoholic = new TextField("Alcoholic / Non-alcoholic");
    private TextField glass = new TextField("Proposed glass");
    private TextField instructions = new TextField("Recipe");

    private Button update = new Button("Update");
    private Binder<Drink> binder = new Binder<>(Drink.class);

    public DrinkForm(DrinkView drinkView) {
        this.drinkView = drinkView;
        update.addThemeVariants(ButtonVariant.LUMO_PRIMARY);
        add(name, alcoholic, glass, instructions, update);
        binder.bindInstanceFields(this);
        update.addClickListener(event -> update());
    }

    private void update() {
        Drink drink = binder.getBean();
        drinkService.updateDrink(drink);
        drinkView.refreshDrink();
        setDrink(null);
    }

    public void setDrink(Drink drink) {
        binder.setBean(drink);
        setVisible(true);
        name.focus();
    }
}
