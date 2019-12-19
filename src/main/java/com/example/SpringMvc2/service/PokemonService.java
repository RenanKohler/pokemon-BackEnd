package com.example.SpringMvc2.service;

import java.security.KeyManagementException;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.X509Certificate;

import javax.net.ssl.SSLContext;

import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.conn.ssl.TrustStrategy;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.client.RestTemplate;

import com.example.SpringMvc2.entity.Pokemon;
import com.example.SpringMvc2.entity.Treinador;


@Service
public class PokemonService {


	

	@Autowired
	private TreinadorService treinadorService;
	@Autowired
	private RestTemplate restTemplate;

	private final String URL = "https://pokeapi.co/api/v2/pokemon/";

	//	public Pokemon adicionarPokemon(Long treinadorId, Pokemon pokemon){
	//		Treinador treinador = treinadorService.getTreinador(treinadorId);
	//		treinador.getPokemons().add(pokemon);
	//		treinadorService.atualizarTreinador2(treinador);
	//		return pokemon;
	//	}
	
	


	public Pokemon adicionarPokemon(Long treinadorId, Pokemon pokemon) {

		Treinador treinador = treinadorService.getTreinador(treinadorId);

		Pokemon p = null;
		
		if (!StringUtils.isEmpty(pokemon.getId())) {
		
			p = restTemplate.getForObject(URL + pokemon.getId(), Pokemon.class);

		} else if (!StringUtils.isEmpty(pokemon.getName())) {

			p = restTemplate.getForObject(URL + pokemon.getName(), Pokemon.class);
		}

		treinador.getPokemons().add(p);

		treinadorService.atualizarTreinador2(treinador);

		return pokemon;
	}

	/*public Pokemon getPokemon(Long pokemonId){
		return pokemonRepository.findById(pokemonId).orElse(null); 

	}
	 */
	
	
}
