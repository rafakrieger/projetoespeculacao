package br.com.rafakrieger.view;

import java.util.ArrayList;
import java.util.Scanner;

import br.com.rafakrieger.controller.TransacaoController;
import br.com.rafakrieger.model.vo.InvestidorVO;
import br.com.rafakrieger.model.vo.TransacaoVO;



public class MenuTransacao {
	Scanner teclado = new Scanner(System.in);
	
	private static final int OPCAO_MENU_CADASTRAR_TRANSACAO = 1;
	private static final int OPCAO_MENU_CONSULTAR_TRANSACAO = 2;
	private static final int OPCAO_MENU_ATUALIZAR_TRANSACAO = 3;
	private static final int OPCAO_MENU_EXCLUIR_TRANSACAO = 4;
	private static final int OPCAO_MENU_TRANSACAO_VOLTAR = 5;
	
	private static final int OPCAO_MENU_CONSULTAR_TODAS_TRANSACOES = 1;
	private static final int OPCAO_MENU_CONSULTAR_UMA_TRANSACAO = 2;
	private static final int OPCAO_MENU_CONSULTAR_TRANSACAO_VOLTAR = 3;

	public void apresentarMenuTransacao() {
		int opcao = this.apresentarOpcoesMenu();
		while (opcao != OPCAO_MENU_TRANSACAO_VOLTAR) {
			switch(opcao) {					
				case OPCAO_MENU_CADASTRAR_TRANSACAO: {
					this.cadastrarTransacao();
					break;
				}
				case OPCAO_MENU_CONSULTAR_TRANSACAO: {
					this.consultarTransacao();
					break;
				}
				case OPCAO_MENU_ATUALIZAR_TRANSACAO: {
					this.atualizarTransacao();
					break;
				}
				case OPCAO_MENU_EXCLUIR_TRANSACAO: {
					this.excluirTransacao();
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
		System.out.println("\nMercado Financeiro \n------ Transações ------");
		System.out.println("\nOpções:");
		System.out.println(OPCAO_MENU_CADASTRAR_TRANSACAO+" - Cadastrar transação");
		System.out.println(OPCAO_MENU_CONSULTAR_TRANSACAO+" - Consultar transação");
		System.out.println(OPCAO_MENU_ATUALIZAR_TRANSACAO+" - Atualizar transação");
		System.out.println(OPCAO_MENU_EXCLUIR_TRANSACAO+" - Excluir transação");
		System.out.println(OPCAO_MENU_TRANSACAO_VOLTAR+" - Voltar");
		System.out.print("\nDigite a opção: ");
		return Integer.parseInt(teclado.nextLine());
	}
	
	private void cadastrarTransacao() {
		TransacaoVO transacaoVO = new TransacaoVO();
		System.out.println("\nCódigo do investidor: ");
		transacaoVO.setIdInvestidor(Integer.parseInt(teclado.nextLine()));
		System.out.println("\nCódigo do papel: ");
		transacaoVO.setIdPapel(Integer.parseInt(teclado.nextLine()));
		System.out.println("\nQuantidade: ");
		transacaoVO.setQtde(Integer.parseInt(teclado.nextLine()));		
		System.out.println("\nTipo da operação (compra ou venda): ");
		transacaoVO.setOperacao(teclado.nextLine());		
		
		TransacaoController transacaoController = new TransacaoController();
		transacaoController.cadastrarTransacaoController(transacaoVO);
		
	}
	
	private void consultarTransacao() {
		int opcao = this.apresentarOpcoesConsulta();
		TransacaoController transacaoController = new TransacaoController();
		while (opcao != OPCAO_MENU_CONSULTAR_TRANSACAO_VOLTAR) {
			switch(opcao) {
				case OPCAO_MENU_CONSULTAR_TODAS_TRANSACOES: {
					opcao = OPCAO_MENU_CONSULTAR_TRANSACAO_VOLTAR;
					InvestidorVO investidorVO = new InvestidorVO();
					System.out.println("\nDigite o login: ");
					investidorVO.setLogin(teclado.nextLine());
					ArrayList<TransacaoVO> listaTransacoesVO = transacaoController.consultarTodasTransacoesController(investidorVO);
					System.out.println("\n----- TRANSAÇÕES CADASTRADAS ----- ");
					System.out.printf("%-5s  %-15s  %-15s  %-15s  %-15s  %-15s  %-15s \n", 
							"ID", "INVESTIDOR", "PAPEL", "QTDE", "VALOR", "OPERACAO", "DATA");
					for (int i=0; i < listaTransacoesVO.size(); i++) {
						listaTransacoesVO.get(i).imprimir();
					}
					break;
				}
				case OPCAO_MENU_CONSULTAR_UMA_TRANSACAO: {
					opcao = OPCAO_MENU_CONSULTAR_TRANSACAO_VOLTAR;
					TransacaoVO transacaoVO = new TransacaoVO();
					System.out.println("\nDigite o código da transação: ");
					transacaoVO.setIdTransacao(Integer.parseInt(teclado.nextLine()));
					TransacaoVO transacao = transacaoController.consultarTransacaoController(transacaoVO);
					System.out.println("\n----- DADOS DA TRANSAÇÃO ----- ");
					System.out.printf("%-5s  %-15s  %-15s  %-15s  %-15s  %-15s  %-15s \n", 
							"ID", "INVESTIDOR", "PAPEL", "QTDE", "VALOR", "OPERACAO", "DATA");
					transacao.imprimir();
					break;
				}
				default: {
					System.out.println("\nOpção inválida!");
					opcao = this.apresentarOpcoesConsulta();
				}
			}
		}
	}

	private int apresentarOpcoesConsulta() {
		System.out.println("\nInforme o tipo de consulta: ");
		System.out.println(OPCAO_MENU_CONSULTAR_TODAS_TRANSACOES + " - Consultar todas as transações do usuário");
		System.out.println(OPCAO_MENU_CONSULTAR_UMA_TRANSACAO + " - Consultar transação específica");
		System.out.println(OPCAO_MENU_CONSULTAR_TRANSACAO_VOLTAR + " - Voltar");
		System.out.println("\nDigite a opção: ");			
		return Integer.parseInt(teclado.nextLine());
	}

	private void atualizarTransacao() {
		TransacaoVO transacaoVO = new TransacaoVO();	
		System.out.println("\nCódigo da transação: ");
		transacaoVO.setIdTransacao(Integer.parseInt(teclado.nextLine()));
		System.out.println("\nCódigo do investidor: ");
		transacaoVO.setIdInvestidor(Integer.parseInt(teclado.nextLine()));
		System.out.println("\nCódigo do papel: ");
		transacaoVO.setIdPapel(Integer.parseInt(teclado.nextLine()));
		System.out.println("\nQuantidade: ");
		transacaoVO.setQtde(Integer.parseInt(teclado.nextLine()));		
		System.out.println("\nTipo da operação (compra ou venda): ");
		transacaoVO.setOperacao(teclado.nextLine());		
		
		TransacaoController transacaoController = new TransacaoController();
		transacaoController.atualizarTransacaoController(transacaoVO);
	}
	
	private void excluirTransacao() {
		TransacaoVO transacaoVO = new TransacaoVO();
		System.out.println("\nDigite o código da transação: ");
		transacaoVO.setIdTransacao(Integer.parseInt(teclado.nextLine()));
		
		TransacaoController transacaoController = new TransacaoController();
		transacaoController.excluirTransacaoController(transacaoVO);
	}
}
