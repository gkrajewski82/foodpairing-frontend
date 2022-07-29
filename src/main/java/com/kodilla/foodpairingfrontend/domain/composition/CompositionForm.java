package com.kodilla.foodpairingfrontend.domain.composition;

import com.kodilla.foodpairingfrontend.domain.drink.Drink;
import com.kodilla.foodpairingfrontend.domain.drink.DrinkService;
import com.kodilla.foodpairingfrontend.domain.drink.TheCocktailDbDrink;
import com.kodilla.foodpairingfrontend.domain.drink.TheCocktailDbDrinkService;
import com.kodilla.foodpairingfrontend.domain.drinkingredient.DrinkIngredient;
import com.kodilla.foodpairingfrontend.domain.drinkingredient.DrinkIngredientService;
import com.kodilla.foodpairingfrontend.mapper.DrinkIngredientMapper;
import com.kodilla.foodpairingfrontend.mapper.DrinkMapper;
import com.kodilla.foodpairingfrontend.view.CompositionView;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.binder.Binder;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class CompositionForm extends FormLayout {

    private CompositionView compositionView;
    private CompositionService compositionService = CompositionService.getInstance();
    private DrinkService drinkService = DrinkService.getInstance();
    private DrinkIngredientService drinkIngredientService = DrinkIngredientService.getInstance();
    private TheCocktailDbDrinkService theCocktailDbDrinkService = TheCocktailDbDrinkService.getInstance();
    private DrinkMapper drinkMapper = new DrinkMapper();
    private DrinkIngredientMapper drinkIngredientMapper = new DrinkIngredientMapper();

    private TextField id = new TextField("Id");
    private TextField dishId = new TextField("Dish id");
    private TextField drinkId = new TextField("Drink id");
    private TextField created = new TextField("Created");

    private Button changeDrink = new Button("Change drink");
    private Button delete = new Button("Delete composition");
    private Binder<Composition> binder = new Binder<>(Composition.class);

    public CompositionForm(CompositionView compositionView) {
        this.compositionView = compositionView;
        HorizontalLayout buttons = new HorizontalLayout(changeDrink, delete);
        changeDrink.addThemeVariants(ButtonVariant.LUMO_PRIMARY);
        delete.addThemeVariants(ButtonVariant.LUMO_PRIMARY);
        add(id, dishId, drinkId, created, buttons);
        binder.bindInstanceFields(this);
        delete.addClickListener(event -> delete());
        changeDrink.addClickListener(event -> changeDrink());
    }

    private void delete() {
        Composition composition = binder.getBean();
        compositionService.delete(composition);
        compositionView.refreshComposition();
        setComposition(null);
    }

    public void setComposition(Composition composition) {
        binder.setBean(composition);
        setVisible(true);
        created.focus();
    }

    public void changeDrink() {
        Composition composition = binder.getBean();
        TheCocktailDbDrink theCocktailDbDrink = theCocktailDbDrinkService.getTheCocktailDbDrinks().get(0);
        Drink drink = drinkMapper.mapToDrink(theCocktailDbDrink);
        Drink savedDrink = drinkService.saveDrink(drink);
        List<DrinkIngredient> drinkIngredientList = drinkIngredientMapper.mapToDrinkIngredientList(theCocktailDbDrink);
        for (DrinkIngredient ingredient : drinkIngredientList) {
            ingredient.setDrinkId(savedDrink.getId());
            drinkIngredientService.saveDrinkIngredient(ingredient);
        }
        Composition updatedComposition = new Composition(
                composition.getId(),
                composition.getDishId(),
                savedDrink.getId(),
                new Date(),
                new ArrayList<>()
        );
        compositionService.update(updatedComposition);
        drinkService.delete(composition.getDrinkId());
        compositionView.refreshComposition();
    }
}
