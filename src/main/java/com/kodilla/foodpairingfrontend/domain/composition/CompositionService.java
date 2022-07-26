package com.kodilla.foodpairingfrontend.domain.composition;

import com.kodilla.foodpairingfrontend.client.BackendClient;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CompositionService {

    private final BackendClient backendClient;
    private List<Composition> compositionList;

    public List<Composition> getCompositions() {
        compositionList = backendClient.getCompositionList();
        return compositionList;
    }
}
