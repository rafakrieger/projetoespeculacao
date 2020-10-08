package br.com.rafakrieger.controller;

import br.com.rafakrieger.model.dao.Banco;
import br.com.rafakrieger.model.dto.LoginDTO;

public class LoginController {

	public boolean verificarLoginController(LoginDTO loginDTO) {
		Banco loginBanco = new Banco();	
		loginBanco.verificarLoginBanco(loginDTO);		
		return loginBanco.logado();
	}
	
	

}
