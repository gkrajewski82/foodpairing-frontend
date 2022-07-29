package com.kodilla.foodpairingfrontend.domain.composition;

import com.kodilla.foodpairingfrontend.domain.dish.Dish;
import com.kodilla.foodpairingfrontend.domain.drink.Drink;
import com.kodilla.foodpairingfrontend.domain.drink.DrinkService;
import com.kodilla.foodpairingfrontend.domain.drink.TheCocktailDbDrinkService;
import com.kodilla.foodpairingfrontend.domain.drinkingredient.DrinkIngredientService;
import com.kodilla.foodpairingfrontend.mapper.DrinkIngredientMapper;
import com.kodilla.foodpairingfrontend.mapper.DrinkMapper;
import com.kodilla.foodpairingfrontend.view.CompositionView;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.binder.Binder;

import java.util.ArrayList;
import java.util.Date;

public class DishToCompositionForm extends FormLayout {

    private CompositionView compositionView;
    private CompositionService compositionService = CompositionService.getInstance();
    private DrinkService drinkService = DrinkService.getInstance();
    private DrinkIngredientService drinkIngredientService = DrinkIngredientService.getInstance();
    private TheCocktailDbDrinkService theCocktailDbDrinkService = TheCocktailDbDrinkService.getInstance();
    private DrinkMapper drinkMapper = new DrinkMapper();
    private DrinkIngredientMapper drinkIngredientMapper = new DrinkIngredientMapper();

    private TextField id = new TextField("Dish id");
    private TextField name = new TextField("Dish name");
    private TextField readyInMinutes = new TextField("Ready in minutes");
    private TextField servings = new TextField("Servings");
    private TextField recipeUrl = new TextField("Recipe URL");

    private Button createComposition = new Button("Create composition with this dish");
    private Binder<Dish> binder = new Binder<>(Dish.class);

    public DishToCompositionForm(CompositionView compositionView) {
        this.compositionView = compositionView;
        createComposition.addThemeVariants(ButtonVariant.LUMO_PRIMARY);
        id.setReadOnly(true);
        name.setReadOnly(true);
        readyInMinutes.setReadOnly(true);
        servings.setReadOnly(true);
        recipeUrl.setReadOnly(true);
        add(id, name, readyInMinutes, servings, recipeUrl, createComposition);
        binder.bindInstanceFields(this);
        createComposition.addClickListener(event -> saveComposition());
    }

    public void saveComposition() {
        Dish dish = binder.getBean();
        Drink savedDrink = drinkService.saveDrinkWithIngredients();
        Composition composition = new Composition(
                null,
                dish.getId(),
                savedDrink.getId(),
                new Date(),
                new ArrayList<>()
        );
        compositionService.save(composition);
        compositionView.refreshComposition();
    }

    public void setDish(Dish dish) {
        binder.setBean(dish);
        setVisible(true);
        name.focus();
    }
}
