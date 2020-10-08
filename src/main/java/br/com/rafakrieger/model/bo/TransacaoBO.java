package br.com.rafakrieger.model.bo;

import java.util.ArrayList;

import br.com.rafakrieger.model.dao.TransacaoDAO;
import br.com.rafakrieger.model.vo.InvestidorVO;
import br.com.rafakrieger.model.vo.TransacaoVO;

public class TransacaoBO {

	public void cadastrarTransacaoBO(TransacaoVO transacaoVO) {
		TransacaoDAO transacaoDAO = new TransacaoDAO();
		int resultado = transacaoDAO.cadastrarTransacaoDAO(transacaoVO);
		if (resultado == 1) {
			System.out.println("\nTransação cadastrada com sucesso");
		} else {
			System.out.println("\nNão foi possível cadastrar a transação");
		}
	}

	public ArrayList<TransacaoVO> consultarTodasTransacoesBO(InvestidorVO investidorVO) {
		TransacaoDAO transacaoDAO = new TransacaoDAO();
		ArrayList<TransacaoVO> listaTransacoesVO = transacaoDAO.consultarTodasTransacoesDAO(investidorVO);
		if (listaTransacoesVO.isEmpty()) {
			System.out.println("\nNão existem transações cadastradas!");
		}
		return listaTransacoesVO;
	}

	public TransacaoVO consultarTransacaoBO(TransacaoVO transacaoVO) {
		TransacaoDAO transacaoDAO = new TransacaoDAO();
		TransacaoVO transacao = transacaoDAO.consultarTransacaoDAO(transacaoVO);
		if (transacao == null) {
			System.out.println("\nTransação não encontrada!");
		}
		return transacao;
	}

	public void atualizarTransacaoBO(TransacaoVO transacaoVO) {
		TransacaoDAO transacaoDAO = new TransacaoDAO();
		if (transacaoDAO.existeRegistroPorIdTransacao(transacaoVO.getIdTransacao())) {
			int resultado = transacaoDAO.atualizarTransacaoDAO(transacaoVO);
			if (resultado == 1) {
				System.out.println("\nTransação atualizada com sucesso");
			} else {
				System.out.println("\nNão foi possível atualizar a transação");
			}
		} else {
			System.out.println("\nTransação não cadastrada!");
		}
	}

	public void excluirTransacaoBO(TransacaoVO transacaoVO) {
		TransacaoDAO transacaoDAO = new TransacaoDAO();
		if (transacaoDAO.existeRegistroPorIdTransacao(transacaoVO.getIdTransacao())) {
			int resultado = transacaoDAO.excluirTransacaoDAO(transacaoVO);
			if (resultado == 1) {
				System.out.println("\nTransação excluída com sucesso");
			} else {
				System.out.println("\nNão foi possível excluir a transação");
			}
		} else {
			System.out.println("\nTransação não existe na base de dados!");
		}

	}
}
