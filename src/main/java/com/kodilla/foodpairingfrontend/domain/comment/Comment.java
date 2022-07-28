package com.kodilla.foodpairingfrontend.domain.comment;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class Comment {

    @JsonProperty("description")
    private String description;

    @JsonProperty("created")
    private Date created;

    @JsonProperty("compositionId")
    private Long compositionId;
}
