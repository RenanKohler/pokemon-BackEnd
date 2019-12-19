package com.example.SpringMvc2.controller;

import java.security.KeyManagementException;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestClientException;

import com.example.SpringMvc2.entity.Pokemon;
import com.example.SpringMvc2.entity.Treinador;
import com.example.SpringMvc2.service.PokemonService;

@RestController
@RequestMapping("/treinador/{treinadorId}/pokemon")
public class PokemonController {
	
	@Autowired
	private PokemonService pokemonService;
	
	/*@PostMapping
	public Pokemon adicionarPokemon(@RequestBody Treinador treinador){
		return pokemonService.adicionarPokemon(treinador.getId(),treinador.getPokemons().iterator().next());
	}*/
	@PostMapping
	public Pokemon adicionarPokemon(@PathVariable Long treinadorId, @RequestBody Pokemon pokemon) throws RestClientException, KeyManagementException, KeyStoreException, NoSuchAlgorithmException {
		
		return  pokemonService.adicionarPokemon(treinadorId, pokemon);
	}
	
}
