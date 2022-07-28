package com.kodilla.foodpairingfrontend.domain.dish;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.kodilla.foodpairingfrontend.domain.composition.Composition;
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

    @JsonProperty("compositionList")
    private List<Composition> compositionList;
}
