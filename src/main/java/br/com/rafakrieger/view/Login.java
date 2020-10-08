package br.com.rafakrieger.view;

import java.util.Scanner;

import br.com.rafakrieger.controller.LoginController;
import br.com.rafakrieger.model.dao.Banco;
import br.com.rafakrieger.model.dto.LoginDTO;

public class Login {	
	
	private static final int OPCAO_LOGIN = 1;
	private static final int OPCAO_NOVO_INVESTIDOR = 2;
	private static final int OPCAO_SAIR = 3;

	Scanner teclado = new Scanner(System.in);
	
	public void solicitarLogin() {
		Banco banco = new Banco();
		banco.zerarLogin();
		int opcao = this.apresentarOpcoesMenu();
		while (opcao != OPCAO_SAIR) {
			switch (opcao) {
				case OPCAO_LOGIN: {
					this.realizarLogin();
					break;
				}
				case OPCAO_NOVO_INVESTIDOR: {
					MenuInvestidor menuInvestidor = new MenuInvestidor();
					menuInvestidor.cadastrarInvestidor();
					break;
				}
				default: {
					System.out.println("\nOpção inválida");	
				}
			}
			opcao = this.apresentarOpcoesMenu();
		}
		
	}	
	
	private int apresentarOpcoesMenu() {
		System.out.println("\n--- $ ---  MERCADO FINANCEIRO --- $ --- ");
		System.out.println("\nOpções:");
		System.out.println(OPCAO_LOGIN + " - Login");
		System.out.println(OPCAO_NOVO_INVESTIDOR + " - Novo investidor");
		System.out.println(OPCAO_SAIR + " - Sair");
		System.out.print("\nDigite a opção: ");
		return Integer.parseInt(teclado.nextLine());
	}
	
	public void realizarLogin() {
		
		LoginDTO loginDTO = new LoginDTO();
		int entrada = 0;
		
		while (entrada == 0) {
			System.out.println("\n----- ACESSO ----- ");

			System.out.println("Login: ");
			loginDTO.setLogin(teclado.nextLine());			
			System.out.println("Senha: ");
			loginDTO.setSenha(teclado.nextLine());
			
			LoginController loginController = new LoginController();
			boolean logado = loginController.verificarLoginController(loginDTO);
			
			if (logado) {
				entrada = 1;
				Menu menu = new Menu();
				menu.apresentarMenu();
			} else {
				System.out.println("Credenciais incorretas");
				this.solicitarLogin();
			}
			
		}
		
	}
}
