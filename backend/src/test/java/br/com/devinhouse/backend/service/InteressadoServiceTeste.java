package br.com.devinhouse.backend.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.verify;

import java.util.Date;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import br.com.devinhouse.backend.entities.Interessado;
import br.com.devinhouse.backend.repositories.InteressadoRepository;
import br.com.devinhouse.backend.services.InteressadoService;

@ExtendWith(MockitoExtension.class)
public class InteressadoServiceTeste {
	
	private static final Interessado interessado = new Interessado(1, "Fulano", "44431256040", new Date(), "S");
	
	@Mock 
	private InteressadoRepository interessadoRepository;
	
	@InjectMocks
	private InteressadoService interessadoService;
	
	@Test
	void cadastrarInteressadoTest() {
		// where
		interessadoService.cadastrarInteressado(interessado);
		
		// then
		ArgumentCaptor<Interessado> interessadoArgumentCaptor = ArgumentCaptor.forClass(Interessado.class);
		
		verify(interessadoRepository).save(interessadoArgumentCaptor.capture());
		
		Interessado capturedInteressado = interessadoArgumentCaptor.getValue();
		
		assertThat(capturedInteressado).isEqualTo(interessado);
	}
	
}


















	
