package br.com.devinhouse.backend.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

import java.util.Date;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import br.com.devinhouse.backend.entities.Assunto;
import br.com.devinhouse.backend.entities.Interessado;
import br.com.devinhouse.backend.entities.Processo;
import br.com.devinhouse.backend.repositories.AssuntoRepository;
import br.com.devinhouse.backend.repositories.InteressadoRepository;
import br.com.devinhouse.backend.repositories.ProcessoRepository;
import br.com.devinhouse.backend.services.ProcessoService;

@ExtendWith(MockitoExtension.class)
public class ProcessoServiceTest {
	
	private static final Interessado interessado = new Interessado(1, "Fulano", "44431256040", new Date(), "S");
	private static final Assunto assunto = new Assunto(1, "Autorizacao para Corte de Arvores - Area Publica", new Date(), "S");
	private static final Processo processo = new Processo(1, 1, "SOFT", "2021", "SOFT 1/2021", "Corte de arvore frutifera", assunto, interessado);
	
	@Mock
	private ProcessoRepository processoRepository;
	
	@Mock
	private AssuntoRepository assuntoRepository;
	
	@Mock
	private InteressadoRepository interessadoRepository;
	
	@InjectMocks
	private ProcessoService processoService;
	
	@Test
	void cadastrarProcessoTest() {
		//  given
		Processo processoASalvar = processo;
		
		when(assuntoRepository.findById(assunto.getId())).thenReturn(Optional.of(assunto));
		when(interessadoRepository.findById(interessado.getId())).thenReturn(Optional.of(interessado));
		when(processoRepository.save(processoASalvar)).thenReturn(processoASalvar);
		
		// when
		Processo processoSalvo = processoService.cadastrarProcesso(processoASalvar);
	
		// then
		assertThat(processoSalvo).isEqualTo(processoASalvar);
		
	}
	
	//  buscarTodosOsProcessos
	//  buscarProcessoPorID
	//  buscarProcessoPorChaveProcesso
	//  buscarProcessosPorInteressados
	//  buscarProcessosPorAssunto
	//  atualizarProcessoPorID
	//  removerProcessoPorID
	
		//  given
		//  when
		//  then
	
	
}