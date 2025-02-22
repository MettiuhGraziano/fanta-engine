package it.fanta.engine.dataService.configuration;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class FirebaseConfiguration {

	//Legge la proprietà dal file application.properties
	@Value("${firebase.config.path}") 
    private String configPath;
	
	public FileInputStream loadServiceAccount() {
		 try {
			FileInputStream serviceAccount = new FileInputStream(configPath);
			
			return serviceAccount;
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		return null;
	}
}