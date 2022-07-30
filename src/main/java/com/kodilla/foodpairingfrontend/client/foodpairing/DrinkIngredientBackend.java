package com.kodilla.foodpairingfrontend.client.foodpairing;

import com.kodilla.foodpairingfrontend.domain.drinkingredient.DrinkIngredient;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

public class DrinkIngredientBackend {

    private final RestTemplate restTemplate = new RestTemplate();

    public List<DrinkIngredient> getDrinkIngredientsForDrinkList(String drinkId) {
        URI url = UriComponentsBuilder
                .fromHttpUrl("http://localhost:8080/foodpairing/v1/drinkingredients/" + drinkId)
                .build()
                .encode()
                .toUri();
        DrinkIngredient[] response = restTemplate.getForObject(url, DrinkIngredient[].class);
        return Optional.ofNullable(response)
                .map(Arrays::asList)
                .orElse(Collections.emptyList());
    }

    public DrinkIngredient saveDrinkIngredient(DrinkIngredient drinkIngredient) {
        URI url = UriComponentsBuilder
                .fromHttpUrl("http://localhost:8080/foodpairing/v1/drinkingredients")
                .build()
                .encode()
                .toUri();
        DrinkIngredient response = restTemplate.postForObject(url, drinkIngredient, DrinkIngredient.class);
        return response;
    }

    public void updateDrinkIngredient(DrinkIngredient drinkIngredient) {
        URI url = UriComponentsBuilder
                .fromHttpUrl("http://localhost:8080/foodpairing/v1/drinkingredients")
                .build()
                .encode()
                .toUri();
        restTemplate.put(url, drinkIngredient);
    }

    public void deleteDrinkIngredient(DrinkIngredient drinkIngredient) {
        URI url = UriComponentsBuilder
                .fromHttpUrl("http://localhost:8080/foodpairing/v1/drinkingredients/" + drinkIngredient.getId())
                .build()
                .encode()
                .toUri();
        restTemplate.delete(url);
    }
}
