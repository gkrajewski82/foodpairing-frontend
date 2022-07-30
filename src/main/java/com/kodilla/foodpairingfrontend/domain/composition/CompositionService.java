package com.kodilla.foodpairingfrontend.domain.composition;

import com.kodilla.foodpairingfrontend.client.BackendClient;
import org.springframework.web.client.HttpClientErrorException;

import java.util.Collections;
import java.util.List;

public class CompositionService {

    private static CompositionService compositionService;
    private final BackendClient backendClient = new BackendClient();
    private List<Composition> compositionList;

    public static CompositionService getInstance() {
        if (compositionService == null) {
            compositionService = new CompositionService();
        }
        return compositionService;
    }

    public List<Composition> getCompositions() {
        try {
            compositionList = backendClient.getCompositionList();
            return compositionList;
        } catch (HttpClientErrorException e) {
            return Collections.EMPTY_LIST;
        }
    }

    public Composition save(Composition composition) {
        return backendClient.createComposition(composition);
    }

    public void delete(Composition composition) {
        backendClient.deleteComposition(composition);
    }

    public void update(Composition composition) {
        backendClient.updateComposition(composition);
    }
}
