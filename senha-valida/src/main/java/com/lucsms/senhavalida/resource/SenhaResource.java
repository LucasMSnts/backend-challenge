package com.lucsms.senhavalida.resource;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.lucsms.senhavalida.domain.Senha;
import com.lucsms.senhavalida.services.SenhaService;

@RestController
@RequestMapping(value="/senha")
public class SenhaResource {

	private SenhaService service = new SenhaService();

	@GetMapping
	public ResponseEntity<Senha> validateSenha(@RequestHeader("Senha") String senha) {
		Boolean validacao = service.validaSenha(senha);
		Senha obj = new Senha(senha);
		obj.setSenhaValida(validacao);
		if (validacao == true)
			return ResponseEntity.ok().body(obj);
		return ResponseEntity.badRequest().body(obj);
	}
}
