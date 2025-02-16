package it.fanta.engine.gameService.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/games")
public class GameController {

    @GetMapping("/test")
    public String test() {
        return "Game Service attivo!";
    }
}
