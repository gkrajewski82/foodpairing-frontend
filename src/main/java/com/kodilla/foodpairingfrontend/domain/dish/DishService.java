package com.kodilla.foodpairingfrontend.domain.dish;

import com.kodilla.foodpairingfrontend.client.BackendClient;
import lombok.RequiredArgsConstructor;
import org.springframework.web.client.HttpClientErrorException;

import java.util.Collections;
import java.util.List;

@RequiredArgsConstructor
public class DishService {

    private static DishService dishService;
    private final BackendClient backendClient = new BackendClient();
    private List<Dish> dishList;

    public static DishService getInstance() {
        if (dishService == null) {
            dishService = new DishService();
        }
        return dishService;
    }

    public List<Dish> getDishes() {
        try {
            dishList = backendClient.getDishList();
            return dishList;
        } catch (HttpClientErrorException e) {
            return Collections.EMPTY_LIST;
        }
    }

    public void delete(Dish dish) {
        backendClient.deleteDish(dish);
    }

    public Dish saveDish(Dish dish) {
        return backendClient.saveDish(dish);
    }
}
