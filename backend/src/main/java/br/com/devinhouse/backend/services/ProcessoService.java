package br.com.devinhouse.backend.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.devinhouse.backend.entities.Assunto;
import br.com.devinhouse.backend.entities.Interessado;
import br.com.devinhouse.backend.entities.Processo;
import br.com.devinhouse.backend.repositories.AssuntoRepository;
import br.com.devinhouse.backend.repositories.InteressadoRepository;
import br.com.devinhouse.backend.repositories.ProcessoRepository;

@Service
public class ProcessoService {
	
	@Autowired
	private ProcessoRepository repository;
	
	@Autowired
	private AssuntoRepository assuntoRepository;
	
	@Autowired
	private InteressadoRepository interessadoRepository;
	
	private boolean verificaExistenciaDeProcesso(Integer id) {
		Processo processoEncontrado = repository.findById(id).get();				
		boolean status = false;
		
		if(processoEncontrado.getId() > 0) {
			status = true;
		}
		return status;
	}
	
//	1 - Deverá haver um endpoint para criação de um processo;
	public Processo cadastrarProcesso(Processo obj) {
		Assunto assuntoLocalizado = assuntoRepository.findById(obj.getCdassunto().getId()).get();
		obj.setCdassunto(assuntoLocalizado);
		
		Interessado interessadoLocalizado = interessadoRepository.findById(obj.getCdinteressado().getId()).get();
		obj.setCdinteressado(interessadoLocalizado);

		//		10 - A formatação da chave do processo deve seguir a seguinte mascara SGORGAOSETOR NUPROCESSO/NUANO ex: SOFT 1/2021;
		obj.setChaveprocesso(obj.getSgorgaosetor() + " " + obj.getNuprocesso() + "/" + obj.getNuano());
				
		return repository.save(obj);

		// 		TODO Regras de negócio	
		//		2 - Não poderá ser cadastrado um novo processo com uma chave de processo já existente;
		//		3 - Não poderá ser cadastrado um novo processo com interessados inativos;
		//		4 - Não poderá ser cadastrado um novo processo com assuntos inativos;
		//		5 - Não poderá ser cadastrado um novo processo com interessados inexistentes no sistema;
		//		6 - Não poderá ser cadastrado um novo processo com assuntos inexistentes no sistema;

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
//	public List<Processo> buscarProcessosPorInteressados(String termo) {
//		Processo processoEncontrado = repository.findByCdinteressado(termo);
//		
//		return repository.findByCdinteressado(termo);
//	}
//	
//	6 - Deverá haver um endpoint para buscar um ou mais processos baseado em seu assunto (CDASSUNTO);
//	public List<Processo> buscarProcessosPorAssunto(Assunto termo) {
//		return repository.findByCdassunto(termo);
//	}
	
//	7 - Deverá haver um endpoint para atualização de todos os atributos de um processo baseado na sua identificação única (ID);
	public Processo atualizarProcessoPorID(Integer id, Processo obj) {
		Processo processoEncontrado = repository.findById(id).get();
		
		if (verificaExistenciaDeProcesso(id)) {
			if(!obj.getDescricao().isBlank()) {
				processoEncontrado.setDescricao(obj.getDescricao());
			}
			if(!obj.getSgorgaosetor().isBlank()) {
				processoEncontrado.setSgorgaosetor(obj.getSgorgaosetor());
			}
			if(!obj.getNuano().isBlank()) {
				processoEncontrado.setNuano(obj.getNuano());
			}
			if(!obj.getChaveprocesso().isBlank()) {
				processoEncontrado.setChaveprocesso(obj.getChaveprocesso());
			}
			if(!obj.getCdassunto().getDescricao().isBlank()) {
				Assunto assuntoAtualizadoEncontrado = assuntoRepository.findById(obj.getCdassunto().getId()).get();
				processoEncontrado.setCdassunto(assuntoAtualizadoEncontrado);
			}
			if(!obj.getCdinteressado().getNminteressado().isBlank()) {
				Interessado interessadoAtualizadoEncontrado = interessadoRepository.findById(obj.getCdinteressado().getId()).get();
				processoEncontrado.setCdinteressado(interessadoAtualizadoEncontrado);
			}
		} else {
			throw new RuntimeException("Processo não encontrado");
		}
		
		return repository.save(processoEncontrado);
	}
	
//	8 - Deverá haver um endpoint para exclusão de um processo baseado na sua identificação única (ID);
	public List<Processo> removerProcessoPorID(Integer id) {
		Processo processoFiltrado = repository.findById(id).get();
		repository.delete(processoFiltrado);
		
		return repository.findAll();
	}
}
