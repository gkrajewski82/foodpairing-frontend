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

    public List<Comment> getCommentsForComposition(String commentId) {
        try {
            return backendClient.getCommentsForCompositionList(commentId);
        } catch (HttpClientErrorException e) {
            return Collections.EMPTY_LIST;
        }
    }

    public Comment saveComment(Comment comment) {
        return backendClient.saveComment(comment);
    }

    public void updateComment(Comment comment) {
        backendClient.updateComment(comment);
    }

    public void deleteComment(Comment comment) {
        backendClient.deleteComment(comment);
    }
}
