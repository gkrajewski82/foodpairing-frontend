package com.kodilla.foodpairingfrontend.view;

import com.kodilla.foodpairingfrontend.domain.comment.Comment;
import com.kodilla.foodpairingfrontend.domain.comment.CommentForm;
import com.kodilla.foodpairingfrontend.domain.comment.CommentService;
import com.kodilla.foodpairingfrontend.view.component.ButtonBar;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;

@Route("foodpairing/commentandrating")
public class CommentAndRatingView extends VerticalLayout {

    private CommentService commentService = CommentService.getInstance();
    private ButtonBar buttonBar = new ButtonBar();
    private Button addNewComment = new Button("Add new comment");

    private CommentForm commentForm = new CommentForm(this);

    private Grid<Comment> gridComment = new Grid<>(Comment.class);

    public CommentAndRatingView() {
        add(buttonBar.createButtonBar());

        addNewComment.addClickListener(e -> {
            gridComment.asSingleSelect().clear();
            commentForm.setComment(new Comment());
        });
        addNewComment.addThemeVariants(ButtonVariant.LUMO_PRIMARY);
        gridComment.setColumns("description", "created", "compositionId");
        HorizontalLayout dishMainContent = new HorizontalLayout(gridComment, commentForm);
        dishMainContent.setSizeFull();
        gridComment.setSizeFull();
        add(addNewComment, dishMainContent);
        commentForm.setComment(null);
        setSizeFull();
        refreshComment();
        gridComment.asSingleSelect().addValueChangeListener(event -> commentForm.setComment(gridComment.asSingleSelect().getValue()));
    }

    public void refreshComment() {
        gridComment.setItems(commentService.getComments());
    }
}
