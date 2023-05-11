package nttdata.bootcamp.nttdata.webflux.taller6.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

import nttdata.bootcamp.nttdata.webflux.parte2.taller6.modelo.Persona;

@Controller
public class TestController {
    private final WebClient webClient;

    @Autowired
    public TestController(WebClient webClient) {
        this.webClient = webClient;
    }

    @GetMapping("/personas")
    public String mostrarPersonas(Model model) {
        List<Persona> personas = webClient.get()
                .uri("/person-list-1")
                .retrieve()
                .bodyToFlux(Persona.class)
                .collectList()
                .block();

        model.addAttribute("personas", personas);

        return "personas";
    }
}