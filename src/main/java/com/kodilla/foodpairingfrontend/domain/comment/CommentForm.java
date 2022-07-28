package com.kodilla.foodpairingfrontend.domain.comment;

import com.kodilla.foodpairingfrontend.view.CommentAndRatingView;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.binder.Binder;

public class CommentForm extends FormLayout {

    private CommentAndRatingView commentAndRatingView;
    private CommentService commentService = CommentService.getInstance();

    private TextField description = new TextField("Description");
    private TextField created = new TextField("Created");
    private TextField compositionId = new TextField("Composition id");

    private Button update = new Button("Update");
    private Button delete = new Button("Delete");
    private Binder<Comment> binder = new Binder<>(Comment.class);

    public CommentForm(CommentAndRatingView commentAndRatingView) {
        this.commentAndRatingView = commentAndRatingView;
        HorizontalLayout buttons = new HorizontalLayout(update, delete);
        update.addThemeVariants(ButtonVariant.LUMO_PRIMARY);
        delete.addThemeVariants(ButtonVariant.LUMO_PRIMARY);
        add(description, created, compositionId, buttons);
        binder.bindInstanceFields(this);
        //save.addClickListener(event -> save());
        //delete.addClickListener(event -> delete());

    }

    private void save() {
        Comment comment = binder.getBean();
        //dishService.save(dish);
        commentAndRatingView.refreshComment();
        setComment(null);
    }

    private void delete() {
        Comment comment = binder.getBean();
        //dishService.delete(dish);
        commentAndRatingView.refreshComment();
        setComment(null);
    }

    public void setComment(Comment comment) {
        binder.setBean(comment);

        if (comment == null) {
            setVisible(false);
        } else {
            setVisible(true);
            description.focus();
        }
    }
}
