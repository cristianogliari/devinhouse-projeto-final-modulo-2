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
import br.com.devinhouse.backend.services.AssuntoService;

@WebMvcTest(value = AssuntoController.class)
public class AssuntoControllerTest {
	private static final Assunto assunto = new Assunto(1, "Autorizacao para Corte de Arvores - Area Publica", new Date(), "S");

	@Autowired
	private MockMvc mockMvc;
	
	@MockBean
	private AssuntoService assuntoService;
	
	@Test
	void cadastrarAssuntoTest() throws Exception {
		// given
		Assunto assuntoACadastrar = assunto;
		
		ObjectWriter assuntoObjeto = new ObjectMapper().writer().withDefaultPrettyPrinter();
		String json = assuntoObjeto.writeValueAsString(assuntoACadastrar);
		
		MockHttpServletRequestBuilder requisicao = MockMvcRequestBuilders
				.post("/assuntos/v1/cadastrar")
				.content(json)
				.contentType(MediaType.APPLICATION_JSON)
				.accept(MediaType.APPLICATION_JSON)
				.header("api-version", "v1");
		
		// when
		when(assuntoService.cadastrarAssunto(assuntoACadastrar)).thenReturn(assuntoACadastrar);
		ResultActions retornoDeAcoes = mockMvc.perform(requisicao);
		
		// then
		retornoDeAcoes
			.andExpect(status().isCreated())
			.andExpect(jsonPath("id").value(assuntoACadastrar.getId()));
	}
		
	// buscarTodosOsAssuntosController
	// buscarAssuntoPeloId
}
