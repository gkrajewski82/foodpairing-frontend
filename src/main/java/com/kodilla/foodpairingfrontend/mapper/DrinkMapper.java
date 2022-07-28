package com.kodilla.foodpairingfrontend.mapper;

import com.kodilla.foodpairingfrontend.domain.drink.Drink;
import com.kodilla.foodpairingfrontend.domain.drink.TheCocktailDbDrink;

import java.util.ArrayList;

public class DrinkMapper {

    public Drink mapTheCocktailDbDrinkToDrink(TheCocktailDbDrink theCocktailDbDrink) {
        return new Drink(
                null,
                theCocktailDbDrink.getExternalSystemId(),
                theCocktailDbDrink.getName(),
                theCocktailDbDrink.getAlcoholic(),
                theCocktailDbDrink.getGlass(),
                theCocktailDbDrink.getInstructions(),
                new ArrayList<>()
        );
    }
}
