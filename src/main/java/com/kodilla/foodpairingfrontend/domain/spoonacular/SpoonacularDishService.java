package com.kodilla.foodpairingfrontend.domain.spoonacular;

import com.kodilla.foodpairingfrontend.client.BackendClient;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;

import java.util.Collections;
import java.util.List;

@Service
@RequiredArgsConstructor
public class SpoonacularDishService {

    private final BackendClient backendClient;
    private List<SpoonacularDish> spoonacularDishList;

    public List<SpoonacularDish> getDishes(String nameFragment) {
        try {
            spoonacularDishList = backendClient.getDishListFromSpoonacular(nameFragment);
            return spoonacularDishList;
        } catch (HttpClientErrorException e) {
            return Collections.EMPTY_LIST;
        }
    }
}
