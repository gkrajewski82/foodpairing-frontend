package com.kodilla.foodpairingfrontend.client.foodpairing;

import com.kodilla.foodpairingfrontend.domain.comment.Comment;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

public class CommentBackend {

    private final RestTemplate restTemplate = new RestTemplate();

    public List<Comment> getCommentsForCompositionList(String compositionId) {
        URI url = UriComponentsBuilder
                .fromHttpUrl("http://localhost:8080/foodpairing/v1/comments/" + compositionId)
                .build()
                .encode()
                .toUri();
        Comment[] response = restTemplate.getForObject(url, Comment[].class);
        return Optional.ofNullable(response)
                .map(Arrays::asList)
                .orElse(Collections.emptyList());
    }

    public Comment saveComment(Comment comment) {
        URI url = UriComponentsBuilder
                .fromHttpUrl("http://localhost:8080/foodpairing/v1/comments")
                .build()
                .encode()
                .toUri();
        Comment response = restTemplate.postForObject(url, comment, Comment.class);
        return response;
    }

    public void updateComment(Comment comment) {
        URI url = UriComponentsBuilder
                .fromHttpUrl("http://localhost:8080/foodpairing/v1/comments")
                .build()
                .encode()
                .toUri();
        restTemplate.put(url, comment);
    }

    public void deleteComment(Comment comment) {
        URI url = UriComponentsBuilder
                .fromHttpUrl("http://localhost:8080/foodpairing/v1/comments/" + comment.getId())
                .build()
                .encode()
                .toUri();
        restTemplate.delete(url);
    }
}
