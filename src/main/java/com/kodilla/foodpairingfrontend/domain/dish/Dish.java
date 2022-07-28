package com.kodilla.foodpairingfrontend.domain.dish;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class Dish {

    @JsonProperty("id")
    private Long id;

    @JsonProperty("externalSystemId")
    private Long externalSystemId;

    @JsonProperty("name")
    private String name;

    @JsonProperty("readyInMinutes")
    private int readyInMinutes;

    @JsonProperty("servings")
    private int servings;

    @JsonProperty("recipeUrl")
    private String recipeUrl;
}
