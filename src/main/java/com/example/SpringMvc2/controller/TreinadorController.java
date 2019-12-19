package com.example.SpringMvc2.controller;

import java.util.Set;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.SpringMvc2.entity.Treinador;
import com.example.SpringMvc2.service.TreinadorService;




@RestController
@RequestMapping("/treinador")
public class TreinadorController {
	
	@Autowired
	private TreinadorService treinadorService;	
	@GetMapping
	public Iterable<Treinador> obterTodos(){
		return treinadorService.obterTodos();
	}
	@PostMapping
	public Treinador criarTreinador(@RequestBody Treinador treinador){
		return treinadorService.criarTreinador(treinador);
		
	}
	@GetMapping("/{id}")
	public Treinador getTreinador(@PathVariable("id") Long id ){
		return treinadorService.getTreinador(id);
	}
	@PutMapping("/{id}")
	public Treinador atualizarTreinador(@RequestBody Treinador treinador,@PathVariable Long id){
		return treinadorService.atualizarTreinador(treinador,id);
	}
	@DeleteMapping("/{id}")
	public void deletarTreinador(@PathVariable Long id){
		treinadorService.deleteTreinador(id);
	}

}
