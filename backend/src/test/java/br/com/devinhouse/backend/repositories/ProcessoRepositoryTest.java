package br.com.devinhouse.backend.repositories;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

@DataJpaTest
public class ProcessoRepositoryTest {
	
	@Autowired
	ProcessoRepository processoRepository;
	
	@Test
	void findByChaveprocessoTest() {
		
	}
	
	@Test
	void findByCdinteressadoTest() {
		
	}
	
	@Test
	void findByCdassuntoTest() {
		
	}
}
