package it.fanta.engine.gameService.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import it.fanta.engine.gameService.producer.KafkaProducer;
import it.fanta.engine.gameService.repository.GameRepository;

@RestController
@RequestMapping("/games")
public class GameController {

	private KafkaProducer kafkaProducer;
	private GameRepository gameRepository;
	
	@Autowired
    public GameController(KafkaProducer kafkaProducer, GameRepository gameRepository) {
		super();
		this.kafkaProducer = kafkaProducer;
		this.gameRepository = gameRepository;
	}

	@GetMapping("/test")
    public String test() {
        return "Game Service attivo!";
    }

    public void updateGameScore(Long gameId, int newScore) {
        // Aggiorna punteggio nel database
        gameRepository.updateScore(gameId, newScore);

        // Invia evento Kafka
        kafkaProducer.sendGameUpdate("Game " + gameId + " updated with score: " + newScore);
    }

}
