package com.kodilla.foodpairingfrontend;

import com.kodilla.foodpairingfrontend.domain.composition.Composition;
import com.kodilla.foodpairingfrontend.domain.composition.CompositionService;
import com.kodilla.foodpairingfrontend.domain.spoonacular.SpoonacularDish;
import com.kodilla.foodpairingfrontend.domain.spoonacular.SpoonacularDishService;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.PostConstruct;

@Route
public class MainView extends VerticalLayout {

    @Autowired
    private SpoonacularDishService spoonacularDishService;

    @Autowired
    private CompositionService compositionService;

    private Grid<SpoonacularDish> gridSpoonacularDish = new Grid<>(SpoonacularDish.class);
    private Grid<Composition> gridComposition = new Grid<>(Composition.class);

    public MainView() {
    }

    public void refresh() {
        gridSpoonacularDish.setItems(spoonacularDishService.getDishes());
        gridComposition.setItems(compositionService.getCompositions());
    }

    @PostConstruct
    public void init() {
        gridSpoonacularDish.setColumns("name", "readyInMinutes", "servings", "recipeUrl");
        gridComposition.setColumns("id", "dishId", "drinkId", "created");
        add(gridSpoonacularDish);
        add(gridComposition);
        setSizeFull();
        refresh();
    }
}