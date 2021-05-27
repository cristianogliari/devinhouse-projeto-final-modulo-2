package br.com.devinhouse.backend.controllers;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.Date;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;

import br.com.devinhouse.backend.entities.Assunto;
import br.com.devinhouse.backend.entities.Interessado;
import br.com.devinhouse.backend.entities.Processo;
import br.com.devinhouse.backend.services.ProcessoService;

@WebMvcTest(value = ProcessoController.class)
public class ProcessoControllerTest {
	private static final Interessado interessado = new Interessado(1, "Fulano", "44431256040", new Date(), "S");
	private static final Assunto assunto = new Assunto(1, "Autorizacao para Corte de Arvores - Area Publica", new Date(), "S");
	private static final Processo processo = new Processo(1, 1, "SOFT", "2021", "SOFT 1/2021", "Corte de arvore frutifera", assunto, interessado);

	@Autowired
	private MockMvc mockMvc;
	
	@MockBean
	private ProcessoService processoService;
	
	@Test
	void criarProcessoControllerTest() throws Exception {
		// given
		Processo processoACadastrar = processo;
		
		ObjectWriter processoObjeto = new ObjectMapper().writer().withDefaultPrettyPrinter();
		String json = processoObjeto.writeValueAsString(processoACadastrar);
		
		MockHttpServletRequestBuilder requisicao = MockMvcRequestBuilders
				.post("/processos/v1/cadastrar")
				.content(json)
				.contentType(MediaType.APPLICATION_JSON)
				.accept(MediaType.APPLICATION_JSON)
				.header("api-version", "v1");
		
		// when
		when(processoService.cadastrarProcesso(processoACadastrar)).thenReturn(processoACadastrar);
		ResultActions retornoDeAcoes = mockMvc.perform(requisicao);
		
		// then
		retornoDeAcoes
			.andExpect(status().isCreated())
			.andExpect(jsonPath("id").value(processoACadastrar.getId()))
			.andExpect(jsonPath("nuprocesso").value(processoACadastrar.getNuprocesso()))
			.andExpect(jsonPath("sgorgaosetor").value(processoACadastrar.getSgorgaosetor()))
			.andExpect(jsonPath("nuano").value(processoACadastrar));
	}

	
	
	// buscarTodosOsProcessosController
	// buscarProcessoPorIDController
	// buscarProcessoPorChaveProcessoController
	// buscarProcessosPorInteressadosController
	// buscarProcessosPorAssuntoController
	// atualizarProcessoPorIDController
	// removerProcessoPorIDController
}
