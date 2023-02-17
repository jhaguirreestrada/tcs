package org.jhae.spring.models.dto;

import java.io.Serializable;

/**
 * The Class PokemonResponseDTO.
 */
public class PokemonResponseDTO implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private String name;
	private String type;
	private String description;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	

}
