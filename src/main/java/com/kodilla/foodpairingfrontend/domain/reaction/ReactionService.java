package com.kodilla.foodpairingfrontend.domain.reaction;

import com.kodilla.foodpairingfrontend.client.BackendClient;
import org.springframework.web.client.HttpClientErrorException;

import java.util.Collections;
import java.util.List;

public class ReactionService {

    private static ReactionService reactionService;
    private final BackendClient backendClient = new BackendClient();

    public static ReactionService getInstance() {
        if (reactionService == null) {
            reactionService = new ReactionService();
        }
        return reactionService;
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
