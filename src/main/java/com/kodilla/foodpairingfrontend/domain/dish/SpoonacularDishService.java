package com.kodilla.foodpairingfrontend.domain.dish;

import com.kodilla.foodpairingfrontend.client.BackendClient;
import com.kodilla.foodpairingfrontend.mapper.DishMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.web.client.HttpClientErrorException;

import java.util.Collections;
import java.util.List;

@RequiredArgsConstructor
public class SpoonacularDishService {

    private static SpoonacularDishService spoonacularDishService;
    private final BackendClient backendClient = new BackendClient();
    private List<SpoonacularDish> spoonacularDishList;

    public static SpoonacularDishService getInstance() {
        if (spoonacularDishService == null) {
            spoonacularDishService = new SpoonacularDishService();
        }
        return spoonacularDishService;
    }

    public List<SpoonacularDish> getSpoonacularDishes(String nameFragment) {
        try {
            spoonacularDishList = backendClient.getDishListFromSpoonacular(nameFragment);
            return spoonacularDishList;
        } catch (HttpClientErrorException e) {
            return Collections.EMPTY_LIST;
        }
    }
}
