package org.jhae.spring.services;

import org.jhae.spring.models.PokemonData;

/**
 * The Interface PokeapiService.
 */
public interface PokeapiService {
	
	/**
	 * Buscar pokemones por nombre.
	 *
	 * @return the Ppkemon Data
	 */
	PokemonData findPokemonByName(String name);
}
