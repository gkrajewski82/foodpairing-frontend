package com.kodilla.foodpairingfrontend.client.foodpairing;

import com.kodilla.foodpairingfrontend.domain.reaction.Reaction;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

public class ReactionBackend {

    private final RestTemplate restTemplate = new RestTemplate();

    public List<Reaction> getReactionsForCommentList(String commentId) {
        URI url = UriComponentsBuilder
                .fromHttpUrl("http://localhost:8080/foodpairing/v1/reactions/" + commentId)
                .build()
                .encode()
                .toUri();
        Reaction[] response = restTemplate.getForObject(url, Reaction[].class);
        return Optional.ofNullable(response)
                .map(Arrays::asList)
                .orElse(Collections.emptyList());
    }

    public Reaction saveReaction(Reaction reaction) {
        URI url = UriComponentsBuilder
                .fromHttpUrl("http://localhost:8080/foodpairing/v1/reactions")
                .build()
                .encode()
                .toUri();
        Reaction response = restTemplate.postForObject(url, reaction, Reaction.class);
        return response;
    }

    public void updateReaction(Reaction reaction) {
        URI url = UriComponentsBuilder
                .fromHttpUrl("http://localhost:8080/foodpairing/v1/reactions")
                .build()
                .encode()
                .toUri();
        restTemplate.put(url, reaction);
    }

    public void deleteReaction(Reaction reaction) {
        URI url = UriComponentsBuilder
                .fromHttpUrl("http://localhost:8080/foodpairing/v1/reactions/" + reaction.getId())
                .build()
                .encode()
                .toUri();
        restTemplate.delete(url);
    }
}
