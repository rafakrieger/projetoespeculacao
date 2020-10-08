package br.com.rafakrieger.controller;

import java.util.ArrayList;

import br.com.rafakrieger.model.bo.TransacaoBO;
import br.com.rafakrieger.model.vo.InvestidorVO;
import br.com.rafakrieger.model.vo.TransacaoVO;

public class TransacaoController {

	public void cadastrarTransacaoController(TransacaoVO transacaoVO) {
		TransacaoBO transacaoBO = new TransacaoBO();
		transacaoBO.cadastrarTransacaoBO(transacaoVO);		
	}

	public ArrayList<TransacaoVO> consultarTodasTransacoesController(InvestidorVO investidorVO) {
		TransacaoBO transacaoBO = new TransacaoBO();
		return transacaoBO.consultarTodasTransacoesBO(investidorVO);
	}

	public TransacaoVO consultarTransacaoController(TransacaoVO transacaoVO) {
		TransacaoBO transacaoBO = new TransacaoBO();
		return transacaoBO.consultarTransacaoBO(transacaoVO);
	}

	public void atualizarTransacaoController(TransacaoVO transacaoVO) {
		TransacaoBO transacaoBO = new TransacaoBO();
		transacaoBO.atualizarTransacaoBO(transacaoVO);
	}

	public void excluirTransacaoController(TransacaoVO transacaoVO) {
		TransacaoBO transacaoBO = new TransacaoBO();
		transacaoBO.excluirTransacaoBO(transacaoVO);
	}

}
