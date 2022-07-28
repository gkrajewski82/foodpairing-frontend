package com.kodilla.foodpairingfrontend.client;

import com.kodilla.foodpairingfrontend.domain.comment.Comment;
import com.kodilla.foodpairingfrontend.domain.composition.Composition;
import com.kodilla.foodpairingfrontend.domain.dish.Dish;
import com.kodilla.foodpairingfrontend.domain.dish.SpoonacularDish;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Optional;


public class BackendClient {

    private final RestTemplate restTemplate = new RestTemplate();

    public List<SpoonacularDish> getDishListFromSpoonacular(String nameFragment) {
        URI url = UriComponentsBuilder
                .fromHttpUrl("http://localhost:8080/foodpairing/v1/spoonacular/dishes/" + nameFragment)
                .build()
                .encode()
                .toUri();
        SpoonacularDish[] response = restTemplate.getForObject(url, SpoonacularDish[].class);
        return Optional.ofNullable(response)
                .map(Arrays::asList)
                .orElse(Collections.emptyList());
    }

    public List<Dish> getDishList() {
        URI url = UriComponentsBuilder
                .fromHttpUrl("http://localhost:8080/foodpairing/v1/dishes")
                .build()
                .encode()
                .toUri();
        Dish[] response = restTemplate.getForObject(url, Dish[].class);
        return Optional.ofNullable(response)
                .map(Arrays::asList)
                .orElse(Collections.emptyList());
    }

    public void deleteDish(Dish dish) {
        URI url = UriComponentsBuilder
                .fromHttpUrl("http://localhost:8080/foodpairing/v1/dishes/" + dish.getId())
                .build()
                .encode()
                .toUri();
        restTemplate.delete(url);
    }

    public List<Comment> getCommentList() {
        URI url = UriComponentsBuilder
                .fromHttpUrl("http://localhost:8080/foodpairing/v1/comments")
                .build()
                .encode()
                .toUri();
        Comment[] response = restTemplate.getForObject(url, Comment[].class);
        return Optional.ofNullable(response)
                .map(Arrays::asList)
                .orElse(Collections.emptyList());
    }

    public List<Composition> getCompositionList() {
        URI url = UriComponentsBuilder
                .fromHttpUrl("http://localhost:8080/foodpairing/v1/compositions")
                .build()
                .encode()
                .toUri();
            Composition[] response = restTemplate.getForObject(url, Composition[].class);
            return Optional.ofNullable(response)
                    .map(Arrays::asList)
                    .orElse(Collections.emptyList());
    }

}
