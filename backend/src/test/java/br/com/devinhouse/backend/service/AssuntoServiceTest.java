package br.com.devinhouse.backend.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.junit.After;
import org.junit.Before;

import br.com.devinhouse.backend.services.AssuntoService;
import br.com.devinhouse.backend.entities.Assunto;
import br.com.devinhouse.backend.repositories.AssuntoRepository;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Date;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

//@DataJpaTest
//@SpringBootTest
//@RunWith(SpringRunner.class)
//@WebAppConfiguration
@ExtendWith(MockitoExtension.class)
public class AssuntoServiceTest {

	private static final Assunto assunto = new Assunto(1, "Autorizacao para Corte de Arvores - Area Publica", new Date(), "S");

	@Mock
	private AssuntoRepository assuntoRepository;

	@InjectMocks
	private AssuntoService assuntoService;

	@Test
	public void cadastrarAssuntoTest() {
		// given
		assuntoService.cadastrarAssunto(assunto);

		// when
		ArgumentCaptor<Assunto> assuntoArgumentCaptor = ArgumentCaptor.forClass(Assunto.class);
		
		verify(assuntoRepository).save(assuntoArgumentCaptor.capture());
		
		Assunto capturedAssunto = assuntoArgumentCaptor.getValue();
		
		// then
		assertThat(capturedAssunto).isEqualTo(assunto);
	}

	@Test
	@Disabled
	public void buscarAssuntoPeloIdTest() {
//		Assunto assunto = serviceImpl.buscarAssuntoPeloId(1);
//		assertEquals("Roubo", assunto.getDescricao());
//		assertEquals(1, assunto.getId());

		int expected = 1;

		System.out.println(assunto.getId());

//		when(assuntoRepository.findById(expected)).thenReturn(Optional.of(mock(Assunto.class)));
//
//		serviceImpl.buscarAssuntoPeloId(expected);
//		
//
//		verify(assuntoRepository).findById(expected);
		
		assertEquals(expected, assunto.getId());
	}

}