package it.fanta.engine.notificationService.consumer;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaConsumer {

    @KafkaListener(topics = "game-updates", groupId = "notification-group")
    public void consumeGameUpdate(String message) {
        System.out.println("Notifica ricevuta: " + message);
        sendPushNotification("Aggiornamento Partita", message);
    }

    private void sendPushNotification(String title, String body) {
        // Qui chiameremo il Firebase Notification Service
        System.out.println("Inviando notifica push: " + title + " - " + body);
    }
}