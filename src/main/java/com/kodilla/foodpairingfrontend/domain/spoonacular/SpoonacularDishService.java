package com.kodilla.foodpairingfrontend.domain.spoonacular;

import com.kodilla.foodpairingfrontend.client.BackendClient;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SpoonacularDishService {

    private final BackendClient backendClient;
    private List<SpoonacularDish> spoonacularDishList;

    public List<SpoonacularDish> getDishes() {
        spoonacularDishList = backendClient.getDishListFromSpoonacular();
        return spoonacularDishList;
    }
}
