package com.lucsms.senhavalida.domain;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Senha {

	@JsonProperty("senha")
	private String senha;
	
	@JsonProperty("ehValida")
	private Boolean senhaValida;
	
	public Senha() {
		this.senhaValida = false;
	}
	
	public Senha(String senha) {
		this.senha = senha;
		this.senhaValida = false;
	}

	public Boolean getSenhaValida() {
		return senhaValida;
	}

	public void setSenhaValida(Boolean senhaValida) {
		this.senhaValida = senhaValida;
	}	
}
