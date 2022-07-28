package com.kodilla.foodpairingfrontend.domain.composition;

import com.kodilla.foodpairingfrontend.client.BackendClient;
import lombok.RequiredArgsConstructor;
import org.springframework.web.client.HttpClientErrorException;

import java.util.Collections;
import java.util.List;

@RequiredArgsConstructor
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

/*    public Composition saveComposition(Composition composition) {
        return backendClient.createComposition(composition);
    }*/
}
