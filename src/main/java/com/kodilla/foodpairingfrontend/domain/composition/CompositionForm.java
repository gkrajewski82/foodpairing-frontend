package com.kodilla.foodpairingfrontend.domain.composition;

import com.kodilla.foodpairingfrontend.view.CompositionView;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.binder.Binder;

public class CompositionForm extends FormLayout {

    private CompositionView compositionView;
    private CompositionService compositionService = CompositionService.getInstance();

    private TextField id = new TextField("Id");
    private TextField dishId = new TextField("Dish id");
    private TextField drinkId = new TextField("Drink id");
    private TextField created = new TextField("Created");

    private Button changeDrink = new Button("Change drink");
    private Button delete = new Button("Delete drink");
    private Binder<Composition> binder = new Binder<>(Composition.class);

    public CompositionForm(CompositionView compositionView) {
        this.compositionView = compositionView;
        HorizontalLayout buttons = new HorizontalLayout(changeDrink, delete);
        changeDrink.addThemeVariants(ButtonVariant.LUMO_PRIMARY);
        delete.addThemeVariants(ButtonVariant.LUMO_PRIMARY);
        add(id, dishId, drinkId, created, buttons);
        binder.bindInstanceFields(this);
        delete.addClickListener(event -> delete());
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
}
