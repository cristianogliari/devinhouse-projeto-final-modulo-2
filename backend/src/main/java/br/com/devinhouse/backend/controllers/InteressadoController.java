package br.com.devinhouse.backend.controllers;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;
import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.devinhouse.backend.entities.Assunto;

@RestController
@RequestMapping(value = "/interessado")
public class InteressadoController {

	@Autowired
	private InteressadoService service;
	
	

//	Uso de versionamento de API;
//	Uso dos métodos (verbos) HTTP;
//	Uso dos respectivos status codes equivalente a cada requisição HTTP;
//	O media type de arquivo ultilizado no projeto deve ser o : "application/json";

//	9 - Deverá haver um endpoint para cadastro de um interessado;
	
	@RequestMapping(headers = "api-version=v1", value = "/v1"
			+ "/cadastro/interessado", method = POST, consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
	@ResponseBody
	@ResponseStatus(HttpStatus.CREATED)
	public Interessado cadastrarInteressado(@RequestBody Interessado interessado) {
		return service.cadastrarInteressado(interessado);
	}
	
//	10 - Deverá haver um endpoint para buscar um interessado baseado na sua identificação única (ID);
	
	@RequestMapping(headers = "api-version=v1", value = "/v1"
			+ "/buscar/id/{id}", method = GET, produces = APPLICATION_JSON_VALUE)
	@ResponseBody
	@ResponseStatus(HttpStatus.OK)
	public Interessado buscarInteressadoPeloId(@PathVariable Integer id) {
		return service.buscarInteressadoPeloId(id);
	}
	
//	11 - Deverá haver um endpoint para buscar um interessado baseado no documento de indentificação (NUIDENTIFICACAO);
	
	@RequestMapping(headers = "api-version=v1", value = "/v1"
			+ "/buscar/cpf/{cpf}", method = GET, produces = APPLICATION_JSON_VALUE)
	@ResponseBody
	@ResponseStatus(HttpStatus.OK)
	public Interessado buscarInteressadoPeloCpf(@PathVariable Integer cpf) {
		return service.buscarInteressadoPeloCpf(cpf);
	}
}

