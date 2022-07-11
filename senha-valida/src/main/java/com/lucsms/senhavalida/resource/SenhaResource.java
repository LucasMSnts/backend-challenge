package com.lucsms.senhavalida.resource;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.lucsms.senhavalida.domain.Senha;
import com.lucsms.senhavalida.services.SenhaService;

@RestController
@RequestMapping(value="/senha")
public class SenhaResource {

	private SenhaService service = new SenhaService();

	@RequestMapping(value="/{senha}",method=RequestMethod.GET) 
	public ResponseEntity<Senha> validateSenha(@PathVariable String senha) {		
		Boolean validacao = service.validaSenha(senha);
		Senha obj = new Senha(senha);
		obj.setSenhaValida(validacao);
		if (validacao == true)
			return ResponseEntity.ok().body(obj);
		return ResponseEntity.badRequest().body(obj);
	}

	@GetMapping
	public ResponseEntity<Senha> senhaVazia() {
		Senha obj = new Senha("");
		return ResponseEntity.badRequest().body(obj);
	}
}
