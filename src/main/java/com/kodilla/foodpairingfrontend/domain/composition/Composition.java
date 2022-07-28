package com.kodilla.foodpairingfrontend.domain.composition;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.kodilla.foodpairingfrontend.domain.comment.Comment;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

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

    @JsonProperty("commentList")
    private List<Comment> commentList;
}
