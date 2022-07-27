package com.kodilla.foodpairingfrontend;

import com.kodilla.foodpairingfrontend.domain.composition.Composition;
import com.kodilla.foodpairingfrontend.domain.composition.CompositionService;
import com.kodilla.foodpairingfrontend.domain.dish.Dish;
import com.kodilla.foodpairingfrontend.domain.dish.DishService;
import com.kodilla.foodpairingfrontend.domain.spoonacular.SpoonacularDish;
import com.kodilla.foodpairingfrontend.domain.spoonacular.SpoonacularDishService;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.PostConstruct;

@PageTitle("home")
@Route
public class MainView extends VerticalLayout {

    @Autowired
    private SpoonacularDishService spoonacularDishService;

    @Autowired
    private DishService dishService;

    private Grid<SpoonacularDish> gridSpoonacularDish = new Grid<>(SpoonacularDish.class);
    private Grid<Dish> gridDish = new Grid<>(Dish.class);
    private TextField findByNameFragment = new TextField();

    public MainView() {
    }

    public void refreshSpoonacular() {
        gridSpoonacularDish.setItems(spoonacularDishService.getSpoonacularDishes(findByNameFragment.getValue()));
    }

    public void refreshDish() {
        gridDish.setItems(dishService.getDishes());
    }

    public void createSearchField() {
        findByNameFragment.setPlaceholder("Search dish by name...");
        findByNameFragment.setClearButtonVisible(true);
        findByNameFragment.addValueChangeListener(e -> refreshSpoonacular());
    }

    @PostConstruct
    public void init() {
        createSearchField();
        gridSpoonacularDish.setColumns("externalSystemId", "name", "readyInMinutes", "servings", "recipeUrl");
        add(findByNameFragment, gridSpoonacularDish);

        gridDish.setColumns("externalSystemId", "name", "readyInMinutes", "servings", "recipeUrl");
        add(gridDish);
        refreshDish();
        setSizeFull();
    }
}