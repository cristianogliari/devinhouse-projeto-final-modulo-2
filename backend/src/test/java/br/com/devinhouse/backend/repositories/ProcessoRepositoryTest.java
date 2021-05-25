package br.com.devinhouse.backend.repositories;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import br.com.devinhouse.backend.entities.Assunto;
import br.com.devinhouse.backend.entities.Interessado;
import br.com.devinhouse.backend.entities.Processo;

@DataJpaTest
public class ProcessoRepositoryTest {
	
	@Autowired
	private ProcessoRepository processoRepository;
	
	@Autowired
	private AssuntoRepository assuntoRepository;
	
	@Autowired
	private InteressadoRepository interessadoRepository;
	
	@AfterEach
	void tearDown() {
		processoRepository.deleteAll();
		assuntoRepository.deleteAll();
		interessadoRepository.deleteAll();
	}

	@Test
	void findByChaveprocessoTest() {
		Assunto assunto = new Assunto(1, "Corte de Arvores", new Date(), "S");
		Assunto assuntoSalvo = assuntoRepository.save(assunto);
		
		Interessado interessado = new Interessado(1, "Fulano", "44431256040", new Date(), "S");
		Interessado interessadoSalvo = interessadoRepository.save(interessado);
		
		Processo processo = new Processo(1, 1, "SOFT", "2021", "SOFT 1/2021", "Descricao teste", assuntoSalvo, interessadoSalvo);
		Processo processoSalvo = processoRepository.save(processo);
		
		Processo processoPorChaveprocesso = processoRepository.findByChaveprocesso("SOFT 1/2021");
		
		assertThat(processoPorChaveprocesso.getChaveprocesso().equals(processoSalvo.getChaveprocesso()));
	}
	
	@Test
	void findByCdinteressadoTest() {
		Assunto assunto = new Assunto(1, "Corte de Arvores", new Date(), "S");
		Assunto assuntoSalvo = assuntoRepository.save(assunto);
		
		Interessado interessado = new Interessado(1, "Fulano", "44431256040", new Date(), "S");
		Interessado interessadoSalvo = interessadoRepository.save(interessado);
		
		Processo processo = new Processo(1, 1, "SOFT", "2021", "SOFT 1/2021", "Descricao teste", assuntoSalvo, interessadoSalvo);
		processoRepository.save(processo);
		
		List<Processo> processosPorInteressado = processoRepository.findByCdinteressado(interessadoSalvo);
		
		assertThat(processosPorInteressado.size()).isEqualTo(1);
	}
	
	@Test
	void findByCdassuntoTest() {
		Assunto assunto = new Assunto(1, "Corte de Arvores", new Date(), "S");
		Assunto assuntoSalvo = assuntoRepository.save(assunto);
		
		Interessado interessado = new Interessado(1, "Fulano", "44431256040", new Date(), "S");
		Interessado interessadoSalvo = interessadoRepository.save(interessado);
		
		Processo processo = new Processo(1, 1, "SOFT", "2021", "SOFT 1/2021", "Descricao teste", assuntoSalvo, interessadoSalvo);
		processoRepository.save(processo);
		
		List<Processo> processosPorInteressado = processoRepository.findByCdassunto(assuntoSalvo);
		
		assertThat(processosPorInteressado.size()).isEqualTo(1);
	}
}
