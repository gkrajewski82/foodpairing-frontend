package com.kodilla.foodpairingfrontend.domain.composition;

import com.kodilla.foodpairingfrontend.client.BackendClient;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
public class CompositionService {

    private final BackendClient backendClient = new BackendClient();
    private List<Composition> compositionList;

    public List<Composition> getCompositions() {
        compositionList = backendClient.getCompositionList();
        return compositionList;
    }
}
