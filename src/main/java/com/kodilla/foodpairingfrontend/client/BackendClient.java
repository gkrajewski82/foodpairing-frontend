package com.kodilla.foodpairingfrontend.client;

import com.kodilla.foodpairingfrontend.domain.composition.Composition;
import com.kodilla.foodpairingfrontend.domain.spoonacular.SpoonacularDish;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Component
@RequiredArgsConstructor
public class BackendClient {

    private final RestTemplate restTemplate;

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

    public List<SpoonacularDish> getDishListFromSpoonacular() {
        URI url = UriComponentsBuilder
                .fromHttpUrl("http://localhost:8080/foodpairing/v1/spoonacular/dishes/banana")
                .build()
                .encode()
                .toUri();

        SpoonacularDish[] response = restTemplate.getForObject(url, SpoonacularDish[].class);
        return Optional.ofNullable(response)
                .map(Arrays::asList)
                .orElse(Collections.emptyList());
    }
}
