package com.kodilla.foodpairingfrontend.client;

import com.kodilla.foodpairingfrontend.domain.comment.Comment;
import com.kodilla.foodpairingfrontend.domain.composition.Composition;
import com.kodilla.foodpairingfrontend.domain.dish.Dish;
import com.kodilla.foodpairingfrontend.domain.dish.SpoonacularDish;
import com.kodilla.foodpairingfrontend.domain.drink.Drink;
import com.kodilla.foodpairingfrontend.domain.drink.TheCocktailDbDrink;
import com.kodilla.foodpairingfrontend.domain.drinkingredient.DrinkIngredient;
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

    public List<TheCocktailDbDrink> getDrinkListFromTheCocktailDb() {
        URI url = UriComponentsBuilder
                .fromHttpUrl("http://localhost:8080/foodpairing/v1/thecocktaildb/randomdrink")
                .build()
                .encode()
                .toUri();
        TheCocktailDbDrink[] response = restTemplate.getForObject(url, TheCocktailDbDrink[].class);
        return Optional.ofNullable(response)
                .map(Arrays::asList)
                .orElse(Collections.emptyList());
    }

    public Drink saveDrink(Drink drink) {
        URI url = UriComponentsBuilder
                .fromHttpUrl("http://localhost:8080/foodpairing/v1/drinks")
                .build()
                .encode()
                .toUri();
        Drink response = restTemplate.postForObject(url, drink, Drink.class);
        return response;
    }

    public void updateDrink(Drink drink) {
        URI url = UriComponentsBuilder
                .fromHttpUrl("http://localhost:8080/foodpairing/v1/drinks")
                .build()
                .encode()
                .toUri();
        restTemplate.put(url, drink);
    }

    public List<Drink> getDrinkList() {
        URI url = UriComponentsBuilder
                .fromHttpUrl("http://localhost:8080/foodpairing/v1/drinks")
                .build()
                .encode()
                .toUri();
        Drink[] response = restTemplate.getForObject(url, Drink[].class);
        return Optional.ofNullable(response)
                .map(Arrays::asList)
                .orElse(Collections.emptyList());
    }

    public void deleteDrink(Long drinkId) {
        URI url = UriComponentsBuilder
                .fromHttpUrl("http://localhost:8080/foodpairing/v1/drinks/" + drinkId)
                .build()
                .encode()
                .toUri();
        restTemplate.delete(url);
    }

    public List<DrinkIngredient> getDrinkIngredientForDrinkList(String drinkId) {
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

    public Dish saveDish(Dish dish) {
        URI url = UriComponentsBuilder
                .fromHttpUrl("http://localhost:8080/foodpairing/v1/dishes")
                .build()
                .encode()
                .toUri();
        Dish response = restTemplate.postForObject(url, dish, Dish.class);
        return response;
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

    public Composition createComposition(Composition composition) {
        URI url = UriComponentsBuilder
                .fromHttpUrl("http://localhost:8080/foodpairing/v1/compositions")
                .build()
                .encode()
                .toUri();
        Composition response = restTemplate.postForObject(url, composition, Composition.class);
        return response;
    }

    public void deleteComposition(Composition composition) {
        URI url = UriComponentsBuilder
                .fromHttpUrl("http://localhost:8080/foodpairing/v1/compositions/" + composition.getId())
                .build()
                .encode()
                .toUri();
        restTemplate.delete(url);
    }

    public void updateComposition(Composition composition) {
        URI url = UriComponentsBuilder
                .fromHttpUrl("http://localhost:8080/foodpairing/v1/compositions")
                .build()
                .encode()
                .toUri();
        restTemplate.put(url, composition);
    }
}
