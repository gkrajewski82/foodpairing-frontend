package com.kodilla.foodpairingfrontend.domain.comment;

import com.kodilla.foodpairingfrontend.client.BackendClient;
import lombok.RequiredArgsConstructor;
import org.springframework.web.client.HttpClientErrorException;

import java.util.Collections;
import java.util.List;

@RequiredArgsConstructor
public class CommentService {

    private static CommentService commentService;
    private final BackendClient backendClient = new BackendClient();
    private List<Comment> commentList;

    public static CommentService getInstance() {
        if (commentService == null) {
            commentService = new CommentService();
        }
        return commentService;
    }

    public List<Comment> getComments() {
        try {
            commentList = backendClient.getCommentList();
            return commentList;
        } catch (HttpClientErrorException e) {
            return Collections.EMPTY_LIST;
        }
    }

/*    public void save(Dish dish) {
        this.books.add(dish);
    }

    public void delete(Dish dish) {
        this.books.remove(dish);
    }*/
}
