package br.com.rafakrieger.model.bo;

import java.util.ArrayList;

import br.com.rafakrieger.model.dao.InvestidorDAO;
import br.com.rafakrieger.model.vo.InvestidorVO;
import br.com.rafakrieger.view.Login;

public class InvestidorBO {

	public void cadastrarInvestidorBO(InvestidorVO investidorVO) {
		InvestidorDAO investidorDAO = new InvestidorDAO();
		int resultado = investidorDAO.cadastrarInvestidorDAO(investidorVO);
			if (resultado == 1 ) {
				System.out.println("\nUsuário cadastrado com sucesso");
				Login novoLogin = new Login();
				novoLogin.realizarLogin();
			} else {
				System.out.println("\nNão foi possível cadastrar o usuário");
			}
	}

	public ArrayList<InvestidorVO> consultarTodosInvestidoresBO() {
		InvestidorDAO investidorDAO = new InvestidorDAO();
		ArrayList<InvestidorVO> listaInvestidoresVO = investidorDAO.consultarTodosInvestidoresDAO();
		if (listaInvestidoresVO.isEmpty()) {
			System.out.println("\nNão existem usuários cadastrados!");
		}
		return listaInvestidoresVO;
	}

	public InvestidorVO consultarInvestidorBO(InvestidorVO investidorVO) {
		InvestidorDAO investidorDAO = new InvestidorDAO();
		InvestidorVO investidor = investidorDAO.consultarInvestidorDAO(investidorVO);
		if (investidor == null) {
			System.out.println("\nUsuário não encontrado!");
		}
		return investidor;
	}

	public void atualizarInvestidorBO(InvestidorVO investidorVO) {
		InvestidorDAO investidorDAO = new InvestidorDAO();
		if (investidorDAO.existeRegistroPorLogin(investidorVO.getLogin())) {
			int resultado = investidorDAO.atualizarInvestidorDAO(investidorVO);
				if (resultado == 1) {
					System.out.println("\nUsuário atualizado com sucesso");
				} else {
					System.out.println("\nNão foi possível atualizar o usuário");
			}
		} else {
			System.out.println("\nUsuário não cadastrado!");
		}
	}	

}
