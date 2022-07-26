package com.kodilla.foodpairingfrontend.domain.composition;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.Date;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class Composition {

    @JsonProperty("id")
    private Long id;

    @JsonProperty("dishId")
    private Long dishId;

    @JsonProperty("drinkId")
    private Long drinkId;

    @JsonProperty("created")
    private Date created;
}
