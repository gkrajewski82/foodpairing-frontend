package com.kodilla.foodpairingfrontend.domain.drinkingredient;

import com.kodilla.foodpairingfrontend.client.BackendClient;
import com.kodilla.foodpairingfrontend.domain.drink.Drink;
import com.kodilla.foodpairingfrontend.domain.drink.DrinkService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.client.HttpClientErrorException;

import java.util.Collections;
import java.util.List;

@RequiredArgsConstructor
public class DrinkIngredientService {

    private static DrinkIngredientService drinkIngredientService;
    private final BackendClient backendClient = new BackendClient();
    private List<DrinkIngredient> drinkIngredientList;

    public static DrinkIngredientService getInstance() {
        if (drinkIngredientService == null) {
            drinkIngredientService = new DrinkIngredientService();
        }
        return drinkIngredientService;
    }

    public List<DrinkIngredient> getDrinkIngredientList() {
        try {
            drinkIngredientList = backendClient.getDrinkIngredientList();
            return drinkIngredientList;
        } catch (HttpClientErrorException e) {
            return Collections.EMPTY_LIST;
        }
    }

    public DrinkIngredient saveDrinkIngredient(DrinkIngredient drinkIngredient) {
        return backendClient.saveDrinkIngredient(drinkIngredient);
    }
}
