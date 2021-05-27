package br.com.devinhouse.backend.service;

import java.util.Date;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import br.com.devinhouse.backend.entities.Assunto;
import br.com.devinhouse.backend.entities.Interessado;
import br.com.devinhouse.backend.entities.Processo;
import br.com.devinhouse.backend.repositories.ProcessoRepository;
import br.com.devinhouse.backend.services.ProcessoService;

@ExtendWith(MockitoExtension.class)
public class ProcessoServiceTest {
	
	private static final Interessado interessado = new Interessado(1, "Fulano", "44431256040", new Date(), "S");
	private static final Assunto assunto = new Assunto(1, "Autorizacao para Corte de Arvores - Area Publica", new Date(), "S");
	private static final Processo processo = new Processo(1, 1, "SOFT", "2021", "SOFT 1/2021", "Corte de arvore frutifera", assunto, interessado);
	
	@Mock
	private ProcessoRepository processoRepository;
	
	@InjectMocks
	private ProcessoService processoService;
	
	@Test
	void cadastrarProcessoTest() {
		
	}
}
