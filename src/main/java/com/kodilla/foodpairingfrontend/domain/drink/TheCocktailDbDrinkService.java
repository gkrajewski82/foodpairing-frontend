package com.kodilla.foodpairingfrontend.domain.drink;

import com.kodilla.foodpairingfrontend.client.BackendClient;
import lombok.RequiredArgsConstructor;
import org.springframework.web.client.HttpClientErrorException;

import java.util.Collections;
import java.util.List;

@RequiredArgsConstructor
public class TheCocktailDbDrinkService {


    private static TheCocktailDbDrinkService theCocktailDbDrinkService;
    private final BackendClient backendClient = new BackendClient();
    private List<TheCocktailDbDrink> theCocktailDbDrinkList;

    public static TheCocktailDbDrinkService getInstance() {
        if (theCocktailDbDrinkService == null) {
            theCocktailDbDrinkService = new TheCocktailDbDrinkService();
        }
        return theCocktailDbDrinkService;
    }

    public List<TheCocktailDbDrink> getTheCocktailDbDrinks() {
        try {
            theCocktailDbDrinkList = backendClient.getDrinkListFromTheCocktailDb();
            return theCocktailDbDrinkList;
        } catch (HttpClientErrorException e) {
            return Collections.EMPTY_LIST;
        }
    }
}
