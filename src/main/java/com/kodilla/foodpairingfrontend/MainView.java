package com.kodilla.foodpairingfrontend;

import com.kodilla.foodpairingfrontend.domain.composition.Composition;
import com.kodilla.foodpairingfrontend.domain.composition.CompositionService;
import com.kodilla.foodpairingfrontend.domain.spoonacular.SpoonacularDish;
import com.kodilla.foodpairingfrontend.domain.spoonacular.SpoonacularDishService;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
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
    private TextField findByNameFragment = new TextField();

    public MainView() {
    }

    public void refreshSpoonacularData() {
        gridSpoonacularDish.setItems(spoonacularDishService.getDishes(findByNameFragment.getValue()));
    }

    public void refresh() {
        gridComposition.setItems(compositionService.getCompositions());
    }

    public void createSearchField() {
        findByNameFragment.setPlaceholder("Search dish by name...");
        findByNameFragment.setClearButtonVisible(true);
        findByNameFragment.addValueChangeListener(e -> refreshSpoonacularData());
    }

    @PostConstruct
    public void init() {
        createSearchField();
        gridSpoonacularDish.setColumns("name", "recipeUrl", "readyInMinutes", "servings");
        add(findByNameFragment, gridSpoonacularDish);

        gridComposition.setColumns("id", "dishId", "drinkId", "created");
        add(gridComposition);
        setSizeFull();
        refresh();
    }
}