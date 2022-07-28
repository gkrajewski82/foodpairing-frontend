package com.kodilla.foodpairingfrontend.domain.composition;

import com.kodilla.foodpairingfrontend.domain.dish.Dish;
import com.kodilla.foodpairingfrontend.domain.dish.DishService;
import com.kodilla.foodpairingfrontend.view.CompositionView;
import com.kodilla.foodpairingfrontend.view.DishView;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.binder.Binder;

public class DishToCompositionForm extends FormLayout {

    private CompositionView compositionView;
    private CompositionService compositionService = CompositionService.getInstance();

    private TextField name = new TextField("Name");
    private TextField readyInMinutes = new TextField("Ready in minutes");
    private TextField servings = new TextField("Servings");
    private TextField recipeUrl = new TextField("Recipe URL");

    private Button createComposition = new Button("Create composition with this dish");
    private Binder<Dish> binder = new Binder<>(Dish.class);

    public DishToCompositionForm(CompositionView compositionView) {
        this.compositionView = compositionView;
        createComposition.addThemeVariants(ButtonVariant.LUMO_PRIMARY);
        add(name, readyInMinutes, servings, recipeUrl, createComposition);
        binder.bindInstanceFields(this);
        //createComposition.addClickListener(event -> saveComposition());
    }

/*    public Composition saveComposition() {
        Dish dish = binder.getBean();
        // pobać drinka
        // ustawic setterami albo konstruktorem pola Composition

        compositionService.saveComposition();

        return null;
    }*/

    public void setDish(Dish dish) {
        binder.setBean(dish);
        setVisible(true);
        name.focus();
    }
}
