package br.com.devinhouse.backend.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.devinhouse.backend.entities.Interessado;
import br.com.devinhouse.backend.repositories.InteressadoRepository;

@Service
public class InteressadoService {

	@Autowired
	private InteressadoRepository repository;

	public Interessado cadastrarInteressado(Interessado interessado) {
		Interessado resultado = repository.findByCpf(interessado.getNuidentificacao());
		if (resultado != null) {
			System.out.println("CPF já cadastrado no nome " + resultado.getNminteressado());
			return null;
		} else {
			repository.save(interessado);
			return interessado;
		}
	};

	public Interessado buscarInteressadoPeloId(Integer id) {
		Interessado encontrado = repository.findById(id).get();

		return encontrado;
	}

	public Interessado buscarInteressadoPeloCpf(String nuidentificacao) {
		Interessado encontrado = repository.findByCpf(nuidentificacao);

		return encontrado;
	}

//	7 - Não poderá ser cadastrado um novo interessado com um id já existente;
//	8 - Não poderá ser cadastrado um novo interessado com um mesmo documento de indentificação;
//	9 - Não poderá ser cadastrado um novo interessado com um documento de identificação inválido;
}
