package com.kodilla.foodpairingfrontend.domain.dish;

import com.kodilla.foodpairingfrontend.MainView;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.binder.Binder;

public class DishForm extends FormLayout {

    private MainView mainView;
    private DishService dishService = DishService.getInstance();

    private TextField externalSystemId = new TextField("External system id");
    private TextField name = new TextField("Name");
    private TextField readyInMinutes = new TextField("Ready in minutes");
    private TextField servings = new TextField("Servings");
    private TextField recipeUrl = new TextField("Recipe URL");

    private Button save = new Button("Save");
    private Button delete = new Button("Delete");
    private Binder<Dish> binder = new Binder<Dish>(Dish.class);

    public DishForm(MainView mainView) {
        this.mainView = mainView;
        HorizontalLayout buttons = new HorizontalLayout(save, delete);
        save.addThemeVariants(ButtonVariant.LUMO_PRIMARY);
        add(externalSystemId, name, readyInMinutes, servings, recipeUrl, buttons);
        binder.bindInstanceFields(this);
        //save.addClickListener(event -> save());
        //delete.addClickListener(event -> delete());

    }

/*    private void save() {
        Dish dish = binder.getBean();
        //dishService.save(dish);
        mainView.refreshDish();
        setDish(null);
    }*/

/*    private void delete() {
        Dish dish = binder.getBean();
        //dishService.delete(dish);
        mainView.refreshDish();
        setDish(null);
    }*/

/*    public void setDish(Dish dish) {
        binder.setBean(dish);

        if (dish == null) {
            setVisible(false);
        } else {
            setVisible(true);
            name.focus();
        }
    }*/

}
