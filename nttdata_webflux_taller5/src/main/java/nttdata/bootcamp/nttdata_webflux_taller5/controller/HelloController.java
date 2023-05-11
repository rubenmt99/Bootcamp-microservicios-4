package nttdata.bootcamp.nttdata_webflux_taller5.controller;

import java.time.Duration;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import reactor.core.publisher.Flux;

@RestController
public class HelloController  {

	
	@GetMapping(path = "/numbers", produces = "text/event-stream")
	public Flux<Integer> numbers(){
		
		//implementacion
		return Flux.range(1, 30)  // Genera una secuencia de números del 1 al 30
	            .delayElements(Duration.ofSeconds(1));  // Emite los datos cada segundo
	}
	
	
}