package org.jhae.spring.controllers;

import org.jhae.spring.models.PokemonData;
import org.jhae.spring.services.PokeapiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;


/**
 * The Class PokemonController.
 */
@RestController
public class PokemonController {
		
	/** The open place holder service. */
	@Autowired
	private PokeapiService pokeApiService;
	
	
	/**
	 * Listar pokemon por nombre
	 *
	 * @return the response ResponseEntity
	 */
	@GetMapping("listar/{name}")
	public ResponseEntity<?> listar(@PathVariable String name) {
		
		PokemonData data = pokeApiService.findPokemonByName(name);
		
		if(data.getIsOk()) {
			return ResponseEntity.ok(data.getPokemonResponse());
		}
		
		 return ResponseEntity.notFound().build();
				
	}

}
