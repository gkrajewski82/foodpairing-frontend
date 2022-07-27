package com.kodilla.foodpairingfrontend.view;

import com.kodilla.foodpairingfrontend.domain.dish.Dish;
import com.kodilla.foodpairingfrontend.domain.dish.DishForm;
import com.kodilla.foodpairingfrontend.domain.dish.DishService;
import com.kodilla.foodpairingfrontend.domain.dish.SpoonacularDish;
import com.kodilla.foodpairingfrontend.domain.dish.SpoonacularDishService;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.Route;

@Route("foodpairing/dish")
public class DishView extends VerticalLayout{


    private SpoonacularDishService spoonacularDishService = SpoonacularDishService.getInstance();
    private DishService dishService = DishService.getInstance();
    ButtonBar buttonBar = new ButtonBar();

    private DishForm dishForm = new DishForm(this);

    private Grid<SpoonacularDish> gridSpoonacularDish = new Grid<>(SpoonacularDish.class);
    private Grid<Dish> gridDish = new Grid<>(Dish.class);
    private TextField findByNameFragment = new TextField();

    public DishView() {
        add(buttonBar.createButtonBar());
        createSearchField();
        gridSpoonacularDish.setColumns("externalSystemId", "name", "readyInMinutes", "servings", "recipeUrl");
        add(findByNameFragment, gridSpoonacularDish);

        gridDish.setColumns("externalSystemId", "name", "readyInMinutes", "servings", "recipeUrl");
        HorizontalLayout mainContent = new HorizontalLayout(gridDish, dishForm);
        mainContent.setSizeFull();
        gridDish.setSizeFull();

        add(mainContent);
        refreshDish();
        setSizeFull();
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
}
