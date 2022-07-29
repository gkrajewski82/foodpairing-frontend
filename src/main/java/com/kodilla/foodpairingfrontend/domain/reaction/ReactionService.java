package com.kodilla.foodpairingfrontend.domain.reaction;

import com.kodilla.foodpairingfrontend.client.BackendClient;
import com.kodilla.foodpairingfrontend.domain.comment.Comment;
import com.kodilla.foodpairingfrontend.domain.comment.CommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.client.HttpClientErrorException;

import java.util.Collections;
import java.util.List;

@RequiredArgsConstructor
public class ReactionService {

    private static ReactionService reactionService;
    private final BackendClient backendClient = new BackendClient();
    private List<Reaction> reactionList;

    public static ReactionService getInstance() {
        if (reactionService == null) {
            reactionService = new ReactionService();
        }
        return reactionService;
    }

    public List<Reaction> getReactions() {
        try {
            reactionList = backendClient.getReactionList();
            return reactionList;
        } catch (HttpClientErrorException e) {
            return Collections.EMPTY_LIST;
        }
    }

    public List<Reaction> getReactionsForComment(String commentId) {
        try {
            return backendClient.getReactionsForCommentList(commentId);
        } catch (HttpClientErrorException e) {
            return Collections.EMPTY_LIST;
        }
    }

    public Reaction saveReaction(Reaction reaction) {
        return backendClient.saveReaction(reaction);
    }

    public void updateReaction(Reaction reaction) {
        backendClient.updateReaction(reaction);
    }

    public void deleteReaction(Reaction reaction) {
        backendClient.deleteReaction(reaction);
    }
}
