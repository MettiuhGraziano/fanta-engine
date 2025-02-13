package it.fanta.engine.authService;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthenticationController {
	
    @GetMapping("/hello")
    public String sayHello() {
        return "Auth Service è attivo!";
    }
}

