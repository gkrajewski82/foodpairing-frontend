package com.kodilla.foodpairingfrontend.domain.dish;

import com.kodilla.foodpairingfrontend.view.DishView;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.binder.Binder;

public class SpoonacularDishForm extends FormLayout {

    private DishView dishView;
    private SpoonacularDishService spoonacularDishService = SpoonacularDishService.getInstance();

    private TextField name = new TextField("Name");
    private TextField readyInMinutes = new TextField("Ready in minutes");
    private TextField servings = new TextField("Servings");
    private TextField recipeUrl = new TextField("Recipe URL");

    private Button addDish = new Button("Add dish to \"Foodpairing\" database");
    private Binder<SpoonacularDish> binder = new Binder<>(SpoonacularDish.class);

    public SpoonacularDishForm(DishView dishView) {
        this.dishView = dishView;
        HorizontalLayout buttons = new HorizontalLayout(addDish);
        addDish.addThemeVariants(ButtonVariant.LUMO_PRIMARY);
        add(name, readyInMinutes, servings, recipeUrl, addDish);
        binder.bindInstanceFields(this);
        //save.addClickListener(event -> save());
        //delete.addClickListener(event -> delete());

    }

/*    private void save() {
        SpoonacularDish spoonacularDish = binder.getBean();
        //dishService.save(dish);
        dishView.refreshDish();
        setDish(null);
    }*/

    public void setSpoonacularDish(SpoonacularDish spoonacularDish) {
        binder.setBean(spoonacularDish);
        setVisible(true);
        name.focus();
    }
}
