package com.kodilla.foodpairingfrontend.domain.drink;

import com.kodilla.foodpairingfrontend.client.BackendClient;
import com.kodilla.foodpairingfrontend.domain.dish.Dish;
import lombok.RequiredArgsConstructor;
import org.springframework.web.client.HttpClientErrorException;

import java.util.Collections;
import java.util.List;

@RequiredArgsConstructor
public class DrinkService {

    private static DrinkService drinkService;
    private final BackendClient backendClient = new BackendClient();
    private List<Drink> drinkList;

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

    public void updateDrink(Drink drink) {
        backendClient.updateDrink(drink);
    }

    public void delete(Long drinkId) {
        backendClient.deleteDrink(drinkId);
    }
}
