package br.com.rafakrieger.view;

import java.util.ArrayList;
import java.util.Scanner;

import br.com.rafakrieger.controller.CarteiraController;
import br.com.rafakrieger.controller.RelatorioController;
import br.com.rafakrieger.model.dto.PapelDTO;
import br.com.rafakrieger.model.vo.CarteiraVO;
import br.com.rafakrieger.model.vo.InvestidorVO;

public class MenuRelatorio {
	
	Scanner teclado = new Scanner(System.in);
	
	private static final int OPCAO_MENU_RELATORIO_PAPEIS= 1;
	private static final int OPCAO_MENU_RELATORIO_CARTEIRA = 2;
	private static final int OPCAO_MENU_RELATORIO_SAIR = 3;

	public void apresentarMenuRelatorio() {
		int opcao = this.apresentarOpcoesMenu();
		while (opcao != OPCAO_MENU_RELATORIO_SAIR) {
			switch (opcao) {
			case OPCAO_MENU_RELATORIO_PAPEIS: {
				this.consultarPapeis();
				break;
			}			
			case OPCAO_MENU_RELATORIO_CARTEIRA: {
				this.consultarCarteira();
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
		System.out.println("\nMercado Financeiro \n------ Relatórios ------");
		System.out.println("\nOpções:");
		System.out.println(OPCAO_MENU_RELATORIO_PAPEIS + " - Consultar variação de papeis");
		System.out.println(OPCAO_MENU_RELATORIO_CARTEIRA + " - Consultar dados da carteira");
		System.out.println(OPCAO_MENU_RELATORIO_SAIR + " - Voltar");
		System.out.print("\nDigite a opção: ");
		return Integer.parseInt(teclado.nextLine());
	}

	private void consultarPapeis() {
		RelatorioController relatorioController = new RelatorioController();
		ArrayList<PapelDTO> listaPapelDTO = relatorioController.consultarPapeisController();
		System.out.println("\n----- RELATÓRIO: VARIAÇÃO DE PAPEIS ----- ");
		System.out.printf("%-15s  %-30s  %-20s  %-20s  %-15s \n", "ID", "NOME", "VALOR ATUAL", "VALOR ANTERIOR", "VARIAÇÃO");
		for (int i=0; i<listaPapelDTO.size(); i++) {
			listaPapelDTO.get(i).imprimir();
		}
	}

	
	private void consultarCarteira() {
		InvestidorVO investidorVO = new InvestidorVO();
		System.out.println("Login do investidor: ");
		investidorVO.setLogin(teclado.nextLine());
		CarteiraController carteiraController = new CarteiraController();
		ArrayList<CarteiraVO> dadosCarteiraVO = carteiraController.consultarCarteiraController(investidorVO);
		System.out.println("\n----- DADOS DA CARTEIRA ----- ");
		System.out.printf("%-15s  %-15s  %-15s  %-15s  %-15s  %-15s %-15s  %-15s \n", 
				"INVESTIDOR", "PAPEL", "VALOR", "QTDE", "VALOR MAX", "PERC MAX", "VALOR MIN", "PERC MIN");
		for (int i=0; i < dadosCarteiraVO.size(); i++) {
			dadosCarteiraVO.get(i).imprimir();
		}
	}

}
