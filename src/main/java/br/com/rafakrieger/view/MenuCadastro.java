package br.com.rafakrieger.view;

import java.util.Scanner;

public class MenuCadastro {
	
	Scanner teclado = new Scanner(System.in);
	
	private static final int OPCAO_MENU_CADASTRO_INVESTIDOR = 1;
	private static final int OPCAO_MENU_CADASTRO_TRANSACAO = 2;
	private static final int OPCAO_MENU_CADASTRO_CARTEIRA = 3;
	private static final int OPCAO_MENU_CADASTRO_VOLTAR = 4;

	public void apresentarMenuCadastro() {
		int opcao = this.apresentarOpcoesMenu();
		while (opcao != OPCAO_MENU_CADASTRO_VOLTAR) {
			switch(opcao) {
			case OPCAO_MENU_CADASTRO_INVESTIDOR: {
				MenuInvestidor menuInvestidor = new MenuInvestidor();
				menuInvestidor.apresentarMenuInvestidor();
				break;
			}
			case OPCAO_MENU_CADASTRO_TRANSACAO: {
				MenuTransacao menuTransacao = new MenuTransacao();
				menuTransacao.apresentarMenuTransacao();
				break;
			}
			case OPCAO_MENU_CADASTRO_CARTEIRA: {
				MenuCarteira menuCarteira = new MenuCarteira();
				menuCarteira.apresentarMenuCarteira();
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
		System.out.println("\nMercado Financeiro \n------ Menu Cadastro ------");
		System.out.println("\nOpções:");
		System.out.println(OPCAO_MENU_CADASTRO_INVESTIDOR+" - Gerenciar investidor");
		System.out.println(OPCAO_MENU_CADASTRO_TRANSACAO+" - Gerenciar transações");
		System.out.println(OPCAO_MENU_CADASTRO_CARTEIRA+" - Gerenciar carteira");
		System.out.println(OPCAO_MENU_CADASTRO_VOLTAR+" - Voltar");
		System.out.print("\nDigite a opção: ");
		return Integer.parseInt(teclado.nextLine());
	}
}
