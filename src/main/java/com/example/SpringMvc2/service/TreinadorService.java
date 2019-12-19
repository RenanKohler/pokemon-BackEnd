package com.example.SpringMvc2.service;



import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.SpringMvc2.entity.Treinador;
import com.example.SpringMvc2.repository.TreinadorRepository;
@Service
public class TreinadorService {
	@Autowired
	private TreinadorRepository treinadorRepository;
	
	public Iterable<Treinador> obterTodos(){
		return treinadorRepository.findAll();
	}
	public Treinador getTreinador(Long id){
		return treinadorRepository.findById(id).orElseThrow(()-> new RuntimeException("Nao existe esse treinador"));
	}
	public Treinador criarTreinador(Treinador treinador) {
		return treinadorRepository.save(treinador);
		
	}
	public Treinador atualizarTreinador(Treinador treinadorNovo,Long id){		
		return treinadorRepository.findById(id)
				.map(treinador -> {
					treinador.setNome(treinadorNovo.getNome());
					return treinadorRepository.save(treinador);				
				}).orElseGet(()-> {
					treinadorNovo.setId(id);
					return treinadorRepository.save(treinadorNovo);
				});
	}
	public void deleteTreinador(Long id){
		treinadorRepository.deleteById(id);
	}
	
	public Treinador atualizarTreinador2(Treinador treinadorNovo){		
		return treinadorRepository.save(treinadorNovo);
				
	}
	

}
