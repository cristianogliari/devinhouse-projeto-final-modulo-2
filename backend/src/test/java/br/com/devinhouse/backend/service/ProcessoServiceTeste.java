package br.com.devinhouse.backend.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.verify;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
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
public class ProcessoServiceTeste {
	
	private static final Interessado interessado = new Interessado(1, "Fulano", "44431256040", new Date(), "S");
	private static final Assunto assunto = new Assunto(1, "Autorizacao para Corte de Arvores - Area Publica", new Date(), "S");
	private static final Processo processo = new Processo(1, 1, "SOFT", "2021", "SOFT 1/2021", "Corte de arvore frutifera", assunto, interessado);
	
	@Mock
	private ProcessoRepository processoRepository;
	private AssuntoRepository assuntoRepository;
	private InteressadoRepository interessadoRepository;
	
	@InjectMocks
	private ProcessoService processoService;
	
	@Test
	void cadastrarProcessoTest() {
		//given
		List<Assunto> assuntoLista = new ArrayList<Assunto>();
		assuntoLista.add(assunto);
		
		processoService.cadastrarProcesso(processo);
		
		// when
		ArgumentCaptor<Processo> processoArgumentCaptor = ArgumentCaptor.forClass(Processo.class);
		
		verify(processoRepository).save(processoArgumentCaptor.capture());
		
		Processo capturedProcesso = processoArgumentCaptor.getValue();
		
		// then		
		assertThat(capturedProcesso).isEqualTo(processo);
		
	}
	
	@Test
	@Disabled
	void buscarTodosOsProcessosTest() {
		
	}
	
	@Test
	@Disabled
	void buscarProcessoPorIDTest() {
		
	}
	
	@Test
	@Disabled
	void buscarProcessosPorChaveProcessoTest() {
		
	}
	
	@Test
	@Disabled
	void buscarProcessosPorInteressadosTest() {
		
	}
	
	@Test
	@Disabled
	void buscarProcessosPorAssuntoTest() {
		
	}
	
	@Test
	@Disabled
	void atualizarProcessoPorIDTest() {
		
	}
	
	@Test
	@Disabled
	void removerProcessoPorIDTest() {
		
	}
	
}