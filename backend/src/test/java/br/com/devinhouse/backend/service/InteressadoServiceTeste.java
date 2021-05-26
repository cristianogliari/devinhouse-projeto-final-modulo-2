package br.com.devinhouse.backend.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import br.com.devinhouse.backend.entities.Interessado;
import br.com.devinhouse.backend.services.InteressadoService;

@SpringBootTest
@RunWith(SpringRunner.class)
@WebAppConfiguration
public class InteressadoServiceTeste {
	
	@Autowired
	private InteressadoService serviceImpl;
	
	@Test
	public void buscarInteressadoPeloIdTeste() {
		Interessado interessado = serviceImpl.buscarInteressadoPeloId(1);
		assertEquals("1", String.valueOf(interessado.getId()));
		assertEquals("1995-05-18 21:00:00", interessado.getDtnascimento());
		assertEquals("S", interessado.getFlativo());
		assertEquals("Bruno Zardo", interessado.getNminteressado());
		assertEquals("08503736977", interessado.getNuidentificacao());
	}
}
