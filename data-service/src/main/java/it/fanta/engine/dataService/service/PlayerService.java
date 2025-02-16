package it.fanta.engine.dataService.service;

import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.Firestore;
import com.google.cloud.firestore.QueryDocumentSnapshot;
import com.google.cloud.firestore.QuerySnapshot;

import it.fanta.engine.dataService.model.Player;

@Service
public class PlayerService {
	
    private final Firestore firestore;

    public PlayerService(Firestore firestore) {
        this.firestore = firestore;
    }

    public void addPlayer(Player player) throws ExecutionException, InterruptedException {
        firestore.collection("players").document(player.getId()).set(player).get();
    }

    public List<Player> getAllPlayers() throws ExecutionException, InterruptedException {
        ApiFuture<QuerySnapshot> query = firestore.collection("players").get();
        List<QueryDocumentSnapshot> documents = query.get().getDocuments();
        return documents.stream().map(doc -> doc.toObject(Player.class)).collect(Collectors.toList());
    }
}

