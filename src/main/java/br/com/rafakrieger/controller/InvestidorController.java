package br.com.rafakrieger.controller;

import java.util.ArrayList;

import br.com.rafakrieger.model.bo.InvestidorBO;
import br.com.rafakrieger.model.vo.InvestidorVO;

public class InvestidorController {

	public void cadastrarInvestidorController(InvestidorVO investidorVO) {
		InvestidorBO investidorBO = new InvestidorBO();
		investidorBO.cadastrarInvestidorBO(investidorVO);		
	}

	public ArrayList<InvestidorVO> consultarTodosInvestidoresController() {
		InvestidorBO investidorBO = new InvestidorBO();
		return investidorBO.consultarTodosInvestidoresBO();
	}

	public InvestidorVO consultarInvestidorController(InvestidorVO investidorVO) {
		InvestidorBO investidorBO = new InvestidorBO();
		return investidorBO.consultarInvestidorBO(investidorVO);
	}

	public void atualizarInvestidorController(InvestidorVO investidorVO) {
		InvestidorBO investidorBO = new InvestidorBO();
		investidorBO.atualizarInvestidorBO(investidorVO);	
	}

}
