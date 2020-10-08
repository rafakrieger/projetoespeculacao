package br.com.rafakrieger.view;

import java.util.ArrayList;
import java.util.Scanner;

import br.com.rafakrieger.controller.InvestidorController;
import br.com.rafakrieger.model.vo.InvestidorVO;

public class MenuInvestidor {
	Scanner teclado = new Scanner(System.in);
	
	private static final int OPCAO_MENU_CONSULTAR_INVESTIDOR = 1;
	private static final int OPCAO_MENU_ATUALIZAR_INVESTIDOR = 2;
	private static final int OPCAO_MENU_USUARIO_VOLTAR = 3;
	
	private static final int OPCAO_MENU_CONSULTAR_TODOS_INVESTIDORES = 1;
	private static final int OPCAO_MENU_CONSULTAR_UM_INVESTIDOR = 2;
	private static final int OPCAO_MENU_CONSULTAR_INVESTIDOR_VOLTAR = 3;

	public void apresentarMenuInvestidor() {
			int opcao = this.apresentarOpcoesMenu();
			while (opcao != OPCAO_MENU_USUARIO_VOLTAR) {
				switch(opcao) {					
					case OPCAO_MENU_CONSULTAR_INVESTIDOR: {
						this.consultarInvestidor();
						break;
					}
					case OPCAO_MENU_ATUALIZAR_INVESTIDOR: {
						this.atualizarInvestidor();
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
			System.out.println("\nMercado Financeiro \n------ Investidor ------");
			System.out.println("\nOpções:");
			System.out.println(OPCAO_MENU_CONSULTAR_INVESTIDOR+" - Consultar investidor");
			System.out.println(OPCAO_MENU_ATUALIZAR_INVESTIDOR+" - Atualizar investidor");
			System.out.println(OPCAO_MENU_USUARIO_VOLTAR+" - Voltar");
			System.out.print("\nDigite a opção: ");
			return Integer.parseInt(teclado.nextLine());
		}
		
		public void cadastrarInvestidor() {
			InvestidorVO investidorVO = new InvestidorVO();
			System.out.println("\nNome: ");
			investidorVO.setNome(teclado.nextLine());
			System.out.println("\nCapital: ");
			investidorVO.setCapital(Double.parseDouble(teclado.nextLine()));
			System.out.println("\nLogin: ");
			investidorVO.setLogin(teclado.nextLine());
			System.out.println("\nSenha: ");
			investidorVO.setSenha(teclado.nextLine());
			
			InvestidorController investidorController = new InvestidorController();
			investidorController.cadastrarInvestidorController(investidorVO);
		}

		private void consultarInvestidor() {
			int opcao = this.apresentarOpcoesConsulta();
			InvestidorController investidorController = new InvestidorController();
			while (opcao != OPCAO_MENU_CONSULTAR_INVESTIDOR_VOLTAR) {
				switch(opcao) {
					case OPCAO_MENU_CONSULTAR_TODOS_INVESTIDORES: {
						opcao = OPCAO_MENU_CONSULTAR_INVESTIDOR_VOLTAR;
						ArrayList<InvestidorVO> listaInvestidoresVO = investidorController.consultarTodosInvestidoresController();
						System.out.println("\n----- INVESTIDORES CADASTRADOS ----- ");
						System.out.printf("\n%-6s %-31s %-16s \n", "ID", "NOME", "CAPITAL");
						for (int i=0; i < listaInvestidoresVO.size(); i++) {
							listaInvestidoresVO.get(i).imprimir();
						}
						break;
					}
					case OPCAO_MENU_CONSULTAR_UM_INVESTIDOR: {
						opcao = OPCAO_MENU_CONSULTAR_INVESTIDOR_VOLTAR;
						InvestidorVO investidorVO = new InvestidorVO();
						System.out.println("\nDigite o código do investidor: ");
						investidorVO.setIdInvestidor(Integer.parseInt(teclado.nextLine()));
						InvestidorVO investidor = investidorController.consultarInvestidorController(investidorVO);
						System.out.println("\n----- DADOS DO INVESTIDOR ----- ");
						System.out.printf("\n%-6s %-31s %-16s \n", "ID", "NOME", "CAPITAL");
						investidor.imprimir();
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
			System.out.println(OPCAO_MENU_CONSULTAR_TODOS_INVESTIDORES + " - Consultar todos os investidores");
			System.out.println(OPCAO_MENU_CONSULTAR_UM_INVESTIDOR + " - Consultar investidor específico");
			System.out.println(OPCAO_MENU_CONSULTAR_INVESTIDOR_VOLTAR + " - Voltar");
			System.out.println("\nDigite a opção: ");			
			return Integer.parseInt(teclado.nextLine());
		}
		
		private void atualizarInvestidor() {
			InvestidorVO investidorVO = new InvestidorVO();	
			System.out.println("\nCódigo do investidor: ");
			investidorVO.setIdInvestidor(Integer.parseInt(teclado.nextLine()));
			System.out.println("\nLogin: ");
			investidorVO.setLogin(teclado.nextLine());
			System.out.println("\nNovo nome: ");
			investidorVO.setNome(teclado.nextLine());
			System.out.println("\nNova senha: ");
			investidorVO.setSenha(teclado.nextLine());			
			
			InvestidorController investidorController = new InvestidorController();
			investidorController.atualizarInvestidorController(investidorVO);
		}
		
	}

