package com.kodilla.foodpairingfrontend.domain.drink;

import com.kodilla.foodpairingfrontend.client.BackendClient;
import com.kodilla.foodpairingfrontend.domain.drinkingredient.DrinkIngredient;
import com.kodilla.foodpairingfrontend.domain.drinkingredient.DrinkIngredientService;
import com.kodilla.foodpairingfrontend.mapper.DrinkIngredientMapper;
import com.kodilla.foodpairingfrontend.mapper.DrinkMapper;
import org.springframework.web.client.HttpClientErrorException;

import java.util.Collections;
import java.util.List;

public class DrinkService {

    private static DrinkService drinkService;
    private final BackendClient backendClient = new BackendClient();
    private List<Drink> drinkList;

    private DrinkIngredientService drinkIngredientService = DrinkIngredientService.getInstance();
    private TheCocktailDbDrinkService theCocktailDbDrinkService = TheCocktailDbDrinkService.getInstance();
    private DrinkMapper drinkMapper = new DrinkMapper();
    private DrinkIngredientMapper drinkIngredientMapper = new DrinkIngredientMapper();

    public static DrinkService getInstance() {
        if (drinkService == null) {
            drinkService = new DrinkService();
        }
        return drinkService;
    }

    public List<Drink> getDrinks() {
        try {
            drinkList = backendClient.getDrinkList();
            return drinkList;
        } catch (HttpClientErrorException e) {
            return Collections.EMPTY_LIST;
        }
    }

    public Drink saveDrink(Drink drink) {
        return backendClient.saveDrink(drink);
    }

    public Drink saveDrinkWithIngredients() {
        TheCocktailDbDrink theCocktailDbDrink = theCocktailDbDrinkService.getTheCocktailDbDrinks().get(0);
        Drink drink = drinkMapper.mapToDrink(theCocktailDbDrink);
        Drink savedDrink = drinkService.saveDrink(drink);
        List<DrinkIngredient> drinkIngredientList = drinkIngredientMapper.mapToDrinkIngredientList(theCocktailDbDrink);
        for (DrinkIngredient ingredient : drinkIngredientList) {
            ingredient.setDrinkId(savedDrink.getId());
            drinkIngredientService.saveDrinkIngredient(ingredient);
        }
        return savedDrink;
    }

    public void updateDrink(Drink drink) {
        backendClient.updateDrink(drink);
    }

    public void delete(Long drinkId) {
        backendClient.deleteDrink(drinkId);
    }
}
