package com.kodilla.foodpairingfrontend.domain.drinkingredient;

import com.kodilla.foodpairingfrontend.client.BackendClient;
import org.springframework.web.client.HttpClientErrorException;

import java.util.Collections;
import java.util.List;

public class DrinkIngredientService {

    private static DrinkIngredientService drinkIngredientService;
    private final BackendClient backendClient = new BackendClient();

    public static DrinkIngredientService getInstance() {
        if (drinkIngredientService == null) {
            drinkIngredientService = new DrinkIngredientService();
        }
        return drinkIngredientService;
    }

    public List<DrinkIngredient> getDrinkIngredientsForDrink(String drinkId) {
        try {
            return backendClient.getDrinkIngredientsForDrinkList(drinkId);
        } catch (HttpClientErrorException e) {
            return Collections.EMPTY_LIST;
        }
    }

    public DrinkIngredient saveDrinkIngredient(DrinkIngredient drinkIngredient) {
        return backendClient.saveDrinkIngredient(drinkIngredient);
    }

    public void updateDrinkIngredient(DrinkIngredient drinkIngredient) {
        backendClient.updateDrinkIngredient(drinkIngredient);
    }

    public void deleteDrinkIngredient(DrinkIngredient drinkIngredient) {
        backendClient.deleteDrinkIngredient(drinkIngredient);
    }
}
