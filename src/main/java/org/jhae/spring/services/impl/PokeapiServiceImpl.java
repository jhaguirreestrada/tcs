package org.jhae.spring.services.impl;

import org.jhae.spring.models.PokemonCharacteristic;
import org.jhae.spring.models.PokemonData;
import org.jhae.spring.models.PokemonGeneral;
import org.jhae.spring.models.dto.PokemonResponseDTO;
import org.jhae.spring.services.PokeapiService;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Value;

import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;


/**
 * The class PokeapiServiceImpl.
 */
@Service
public class PokeapiServiceImpl  implements PokeapiService{
	
	
	/** The rest template. */
	@Autowired
	private RestTemplate restTemplate;
	
	//@Value("${api.url.general}")
	private String urlGeneral = "https://pokeapi.co/api/v2/pokemon/";

	//@Value("${api.url.characteristic}")
	private String urlCharacteristic = "https://pokeapi.co/api/v2/characteristic/";
	
	
	/**
	 * Buscar pokemon por nombre.
	 *
	 * @return the response Pokemon Data
	 */
	@Override
	public PokemonData findPokemonByName(String name) {
		
		
		PokemonData data = new PokemonData();
		PokemonGeneral general = this.findPokemonGeneral(name);
		
		if(general.getIsOk()) {
			PokemonCharacteristic characteristic = this.findPokemonCharacteristic(general.getId());
			
			if(characteristic.getIsOk()) {
				PokemonResponseDTO responseDTO = new PokemonResponseDTO();
				responseDTO.setName(general.getName());
				responseDTO.setType(general.getType());
				responseDTO.setDescription(characteristic.getDescription());
				
				data.setIsOk(true);
				data.setPokemonResponse(responseDTO);	
			} else {
				data.setIsOk(false);
			}
			
		} else {
			data.setIsOk(false);
		}
		
		return data;
		
	}
	
	
	/**
	 * Buscar datos generales del Pokemon a la api general
	 *
	 * @return Pokemon General
	 */
	private PokemonGeneral findPokemonGeneral(String name) {
		
		PokemonGeneral general = new PokemonGeneral();
	
		try {	 
		
			ResponseEntity<String> response = restTemplate.exchange(urlGeneral + name, HttpMethod.GET, null, String.class);
			
		    
		    if (response.getStatusCode().equals(HttpStatus.OK)) {
		    	//Convertimos el string en un objeto json
			    JSONObject json = new JSONObject(response.getBody());
			    
			    general.setIsOk(true);
			    general.setId(json.getInt("id"));
			    general.setName(json.getString("name"));
			    general.setType(json.getJSONArray("types").getJSONObject(0).getJSONObject("type").getString("name"));	
                
            } else{
            	general.setIsOk(false);
			    general.setName(response.getStatusCode().toString());
                
            }
		
		} catch (Exception e) {
			general.setIsOk(false);
			general.setName(e.getMessage());
	            
	    }
		
		return general;
		
	}
	
	/**
	 * Buscar datos del Pokemon a la api Characteristic
	 *
	 * @return Pokemon Charatesristic
	 */
	private PokemonCharacteristic findPokemonCharacteristic(Integer id) {
		
		PokemonCharacteristic characteristic = new PokemonCharacteristic();
	
		try {	 
		
			ResponseEntity<String> response = restTemplate.exchange(urlCharacteristic + id, HttpMethod.GET, null, String.class);
			
		    
		    if (response.getStatusCode().equals(HttpStatus.OK)) {
		    	//Convertimos el string en un objeto json
			    JSONObject json = new JSONObject(response.getBody());
			    
			    characteristic.setIsOk(true);
			    characteristic.setDescription(json.getJSONArray("descriptions").getJSONObject(0).getString("description"));	
                
            } else{
            	characteristic.setIsOk(false);
            	characteristic.setDescription(response.getStatusCode().toString());
                
            }
		
		} catch (Exception e) {
			characteristic.setIsOk(false);
			characteristic.setDescription(e.getMessage());
	            
	    }
		
		return characteristic;
		
	}

}
