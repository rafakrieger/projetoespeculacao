package br.com.rafakrieger.view;

import java.util.Scanner;

import br.com.rafakrieger.controller.CarteiraController;
import br.com.rafakrieger.model.vo.CarteiraVO;

public class MenuCarteira {
	
	Scanner teclado = new Scanner(System.in);
	
	private static final int OPCAO_MENU_CARTEIRA_CADASTRAR_LIMITES = 1;
	private static final int OPCAO_MENU_CARTEIRA_SAIR = 2;

	public void apresentarMenuCarteira() {
		int opcao = this.apresentarOpcoesMenu();
		while (opcao != OPCAO_MENU_CARTEIRA_SAIR) {
			switch(opcao) {					
				case OPCAO_MENU_CARTEIRA_CADASTRAR_LIMITES: {
					this.cadastrarLimitesCarteira();
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
		System.out.println("\nMercado Financeiro \n------ Carteira ------");
		System.out.println("\nOpções:");
		System.out.println(OPCAO_MENU_CARTEIRA_CADASTRAR_LIMITES+" - Cadastrar ou alterar limites para o disparador de transação");
		System.out.println(OPCAO_MENU_CARTEIRA_SAIR+" - Voltar");
		System.out.print("\nDigite a opção: ");
		return Integer.parseInt(teclado.nextLine());
	}	
	
	private void cadastrarLimitesCarteira() {
		CarteiraVO carteiraVO = new CarteiraVO();
		System.out.println("\nCódigo do investidor: ");
		carteiraVO.setIdInvestidor(Integer.parseInt(teclado.nextLine()));
		System.out.println("\nCódigo do papel: ");
		carteiraVO.setIdPapel(Integer.parseInt(teclado.nextLine()));
		System.out.println("\nGATILHO PARA COMPRA");
		System.out.println("\nValor mínimo: ");
		carteiraVO.setLimiteInferiorValor(Double.parseDouble(teclado.nextLine()));
		System.out.println("\nLimite inferior de variação (em %): ");
		carteiraVO.setLimiteInferiorPerc(Double.parseDouble(teclado.nextLine()));
		System.out.println("\nGATILHO PARA VENDA");
		System.out.println("\nValor máximo: ");
		carteiraVO.setLimiteSuperiorValor(Double.parseDouble(teclado.nextLine()));
		System.out.println("\nLimite superior de variação (em %): ");
		carteiraVO.setLimiteSuperiorPerc(Double.parseDouble(teclado.nextLine()));
		
		CarteiraController carteiraController = new CarteiraController();
		carteiraController.cadastrarLimitesCarteiraController(carteiraVO);
	}
}
