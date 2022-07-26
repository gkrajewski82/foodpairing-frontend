package com.kodilla.foodpairingfrontend.domain.spoonacular;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class SpoonacularDish {

    @JsonProperty("title")
    private String name;

    @JsonProperty("sourceUrl")
    private String recipeUrl;

    @JsonProperty("readyInMinutes")
    private int readyInMinutes;

    @JsonProperty("servings")
    private int servings;
}
