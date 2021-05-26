package br.com.devinhouse.backend.repository;

import org.junit.jupiter.api.DisplayName;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import br.com.devinhouse.backend.repositories.AssuntoRepository;

@DataJpaTest
@DisplayName("Teste Assunto Repository")
public class AssuntoRepositoryTest {

	@Autowired
	private AssuntoRepository assuntoRepository;
}
