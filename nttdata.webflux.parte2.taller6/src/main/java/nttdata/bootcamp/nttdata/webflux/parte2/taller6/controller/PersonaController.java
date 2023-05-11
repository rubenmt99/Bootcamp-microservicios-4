package nttdata.bootcamp.nttdata.webflux.parte2.taller6.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import nttdata.bootcamp.nttdata.webflux.parte2.taller6.modelo.Persona;

@RestController
public class PersonaController  {
	
	
	@GetMapping(value = "/person-list-1")
	public List<Persona> listarPersonas(){
		
		List<Persona> miListaList = new ArrayList<>();
		miListaList.add(new Persona("Andres", "Martinez", (Integer) 27));
		miListaList.add(new Persona("Sofía", "Reyes", (Integer) 21));
		
		return miListaList;	
	}

}