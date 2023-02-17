package org.jhae.spring.models;

import org.jhae.spring.models.dto.PokemonResponseDTO;

/**
 * The Class PokemonData.
 */
public class PokemonData {

	private Boolean isOk;
	private PokemonResponseDTO pokemonResponse;
	
	public Boolean getIsOk() {
		return isOk;
	}
	public void setIsOk(Boolean isOk) {
		this.isOk = isOk;
	}
	public PokemonResponseDTO getPokemonResponse() {
		return pokemonResponse;
	}
	public void setPokemonResponse(PokemonResponseDTO pokemonResponse) {
		this.pokemonResponse = pokemonResponse;
	}
	
	
	
}
