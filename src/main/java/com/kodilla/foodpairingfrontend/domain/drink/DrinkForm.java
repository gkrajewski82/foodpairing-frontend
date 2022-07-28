package com.kodilla.foodpairingfrontend.domain.drink;

import com.kodilla.foodpairingfrontend.view.DrinkView;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.binder.Binder;

public class DrinkForm extends FormLayout {


    private DrinkView drinkView;
    private DrinkService drinkService = DrinkService.getInstance();

    private TextField name = new TextField("Name");
    private TextField alcoholic = new TextField("Alcoholic / Non-alcoholic");
    private TextField glass = new TextField("Proposed glass");
    private TextField instructions = new TextField("Recipe");

    private Button ingredients = new Button("Get ingredients");
    private Binder<Drink> binder = new Binder<>(Drink.class);

    public DrinkForm(DrinkView drinkView) {
        this.drinkView = drinkView;
        ingredients.addThemeVariants(ButtonVariant.LUMO_PRIMARY);
        add(name, alcoholic, glass, instructions, ingredients);
        binder.bindInstanceFields(this);
    }

    public void setDrink(Drink drink) {
        binder.setBean(drink);
            setVisible(true);
            name.focus();
    }
}
