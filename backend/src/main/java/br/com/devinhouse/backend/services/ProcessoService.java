package br.com.devinhouse.backend.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.devinhouse.backend.entities.Assunto;
import br.com.devinhouse.backend.entities.Interessado;
import br.com.devinhouse.backend.entities.Processo;
import br.com.devinhouse.backend.repositories.ProcessoRepository;

@Service
public class ProcessoService {
	
	@Autowired
	private ProcessoRepository repository;
	
//	1 - Deverá haver um endpoint para criação de um processo;
	public Processo cadastrarProcesso(Processo obj) {
		return repository.save(obj);
	}
		
//	2 - Deverá haver um endpoint para listagem de todos os processos, retornando todos os atributos de cada processo;
	public List<Processo> buscarTodosOsProcessos() {
		return repository.findAll();
	}
	
//	3 - Deverá haver um endpoint para buscar um processo baseado na sua identificação única (ID);
	public Processo buscarProcessoPorID(Integer id) {
		return repository.findById(id).get();
	}	
	
//	4 - Deverá haver um endpoint para buscar um processo baseado no seu número de processo (CHAVEPROCESSO);
	public Processo buscarProcessoPorChaveProcesso(String termo) {
		return repository.findByChaveprocesso(termo);
	}
	
//	5 - Deverá haver um endpoint para buscar um ou mais processos baseado em seu interessado (CDINTERESSADO);
	public List<Processo> buscarProcessosPorInteressados(Interessado termo) {
		return repository.findByCdinteressado(termo);
	}
	
//	6 - Deverá haver um endpoint para buscar um ou mais processos baseado em seu assunto (CDASSUNTO);
	public List<Processo> buscarProcessosPorAssunto(Assunto termo) {
		return repository.findByCdassunto(termo);
	}
	
//	7 - Deverá haver um endpoint para atualização de todos os atributos de um processo baseado na sua identificação única (ID);
	public Processo atualizarProcessoPorID(Integer id, Processo obj) {
		Processo processoAtualizado = repository.findById(id).get();
		
		// TODO processos atributos atualização
		
		return repository.save(processoAtualizado);
	}
	
//	8 - Deverá haver um endpoint para exclusão de um processo baseado na sua identificação única (ID);
	public List<Processo> removerProcessoPorID(Integer id) {
		Processo processoFiltrado = repository.findById(id).get();
		repository.delete(processoFiltrado);
		
		return repository.findAll();
	}
	
// TODO Regras de negócio	
//	1 - Não poderá ser cadastrado um novo processo com um id já existente;
//	2 - Não poderá ser cadastrado um novo processo com uma chave de processo já existente;
//	3 - Não poderá ser cadastrado um novo processo com interessados inativos;
//	4 - Não poderá ser cadastrado um novo processo com assuntos inativos;
//	5 - Não poderá ser cadastrado um novo processo com interessados inesistentes no sistema;
//	6 - Não poderá ser cadastrado um novo processo com assuntos inesistentes no sistema;
//	10 - A formatação da chave do processo deve seguir a seguinte mascara SGORGAOSETOR NUPROCESSO/NUANO ex: SOFT 1/2021;
}
