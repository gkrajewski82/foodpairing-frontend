package com.kodilla.foodpairingfrontend.domain.drinkingredient;

import com.kodilla.foodpairingfrontend.view.DrinkView;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.binder.Binder;

public class DrinkIngredientForm extends FormLayout {

    private DrinkView drinkView;
    private DrinkIngredientService drinkIngredientService = DrinkIngredientService.getInstance();

    private TextField drinkId = new TextField("Drink id");
    private TextField name = new TextField("Name");
    private TextField measure = new TextField("Measure");

    private Button update = new Button("Update");
    private Button delete = new Button("Delete");
    private Binder<DrinkIngredient> binder = new Binder<>(DrinkIngredient.class);

    public DrinkIngredientForm(DrinkView drinkView) {
        this.drinkView = drinkView;
        HorizontalLayout buttons = new HorizontalLayout(update, delete);
        update.addThemeVariants(ButtonVariant.LUMO_PRIMARY);
        delete.addThemeVariants(ButtonVariant.LUMO_PRIMARY);
        add(drinkId, name, measure, buttons);
        binder.bindInstanceFields(this);
    }

    public void setDrinkIngredient(DrinkIngredient drinkIngredient) {
        if (drinkIngredient == null) {
            setVisible(false);
        } else {
            setVisible(true);
            name.focus();
        }
    }
}
