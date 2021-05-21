package br.com.devinhouse.backend.services;

import org.springframework.stereotype.Service;

import br.com.devinhouse.backend.entities.Assunto;
import br.com.devinhouse.backend.repositories.AssuntoRepository;

import org.springframework.beans.factory.annotation.Autowired;


@Service
public class AssuntoService {
	
	@Autowired
	private AssuntoRepository repository;
	
	public Assunto cadastrarAssunto(Assunto assunto) {
		return repository.save(assunto);
	}
	
	public Assunto buscarAssuntoPeloId(Integer id) {
		Assunto encontrado = repository.findById(id).get();
		
		return encontrado;
	}
}