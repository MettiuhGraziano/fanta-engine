package it.fanta.engine.dataService.configuration;

import java.io.FileInputStream;
import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.cloud.firestore.Firestore;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import com.google.firebase.cloud.FirestoreClient;

@Service
public class FirebaseInitializer {

    private FirebaseConfiguration firebaseConfiguration;
    
    @Autowired
    public FirebaseInitializer(FirebaseConfiguration firebaseXmlConfig) {
        this.firebaseConfiguration = firebaseXmlConfig;
    }
    
    @Bean
    public Firestore initializeFirestore() {
        try {
        	FileInputStream serviceAccount = firebaseConfiguration.loadServiceAccount();
        	
        	if (null != serviceAccount) {
        		FirebaseOptions options = FirebaseOptions.builder()
        				.setCredentials(GoogleCredentials.fromStream(serviceAccount))
        				.build();
        		
        		FirebaseApp.initializeApp(options);
        		System.out.println("Firebase inizializzato correttamente!");
			}
        } catch (IOException e) {
            e.printStackTrace();
        }
		return FirestoreClient.getFirestore();
    }
}
