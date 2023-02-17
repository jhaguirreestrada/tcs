package org.jhae.spring.models;

/**
 * The Class PokemonGeneral.
 */
public class PokemonGeneral {
	
	private Boolean isOk;
	private Integer id;
	private String name;
	private String type;
	
	
	public Boolean getIsOk() {
		return isOk;
	}
	public void setIsOk(Boolean isOk) {
		this.isOk = isOk;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
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
}
