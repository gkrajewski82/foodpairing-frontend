package com.kodilla.foodpairingfrontend.client.foodpairing;

import com.kodilla.foodpairingfrontend.domain.composition.Composition;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

public class CompositionBackend {

    private final RestTemplate restTemplate = new RestTemplate();

    public List<Composition> getCompositionList() {
        URI url = UriComponentsBuilder
                .fromHttpUrl("http://localhost:8080/foodpairing/v1/compositions")
                .build()
                .encode()
                .toUri();
        Composition[] response = restTemplate.getForObject(url, Composition[].class);
        return Optional.ofNullable(response)
                .map(Arrays::asList)
                .orElse(Collections.emptyList());
    }

    public Composition createComposition(Composition composition) {
        URI url = UriComponentsBuilder
                .fromHttpUrl("http://localhost:8080/foodpairing/v1/compositions")
                .build()
                .encode()
                .toUri();
        Composition response = restTemplate.postForObject(url, composition, Composition.class);
        return response;
    }

    public void updateComposition(Composition composition) {
        URI url = UriComponentsBuilder
                .fromHttpUrl("http://localhost:8080/foodpairing/v1/compositions")
                .build()
                .encode()
                .toUri();
        restTemplate.put(url, composition);
    }

    public void deleteComposition(Composition composition) {
        URI url = UriComponentsBuilder
                .fromHttpUrl("http://localhost:8080/foodpairing/v1/compositions/" + composition.getId())
                .build()
                .encode()
                .toUri();
        restTemplate.delete(url);
    }
}
