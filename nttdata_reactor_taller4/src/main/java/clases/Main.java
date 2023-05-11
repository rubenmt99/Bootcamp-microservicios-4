package clases;

import javax.security.auth.callback.TextOutputCallback;

import reactor.core.publisher.Flux;

public class Main  {
	
 public static void main(String[] args) {
	 
	 //Objeto Publisher
	 Flux<String> miFlux = Flux.just("mensaje 1", "mensaje 2", "mensaje 3", "mensaje 4", "mensaje 5");

	 //Consumer
	 miFlux.subscribe(texto -> System.out.println("Observador 1 - Mensaje: " + texto));
	 System.out.println("--------------");
	 miFlux.subscribe(texto -> System.out.println("Observador 2 - Mensaje: " + texto));
}
	

}