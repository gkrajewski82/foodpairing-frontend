package com.kodilla.foodpairingfrontend.domain.drink;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.kodilla.foodpairingfrontend.domain.drinkingredient.DrinkIngredient;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class Drink {

    @JsonProperty("id")
    private Long id;

    @JsonProperty("externalSystemId")
    private String externalSystemId;

    @JsonProperty("name")
    private String name;

    @JsonProperty("alcoholic")
    private String alcoholic;

    @JsonProperty("glass")
    private String glass;

    @JsonProperty("drinkIngredientList")
    private List<DrinkIngredient> drinkIngredientList;
}
