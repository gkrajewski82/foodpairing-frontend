package com.kodilla.foodpairingfrontend.domain.dish;


import com.kodilla.foodpairingfrontend.client.BackendClient;
import com.kodilla.foodpairingfrontend.domain.spoonacular.SpoonacularDish;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;

import java.util.Collections;
import java.util.List;

@Service
@RequiredArgsConstructor
public class DishService {

    private final BackendClient backendClient;
    private List<Dish> dishList;

    public List<Dish> getDishes() {
        try {
            dishList = backendClient.getDishList();
            return dishList;
        } catch (HttpClientErrorException e) {
            return Collections.EMPTY_LIST;
        }
    }

/*    public void save(Dish dish) {
        this.books.add(dish);
    }

    public void delete(Dish dish) {
        this.books.remove(dish);
    }*/
}
