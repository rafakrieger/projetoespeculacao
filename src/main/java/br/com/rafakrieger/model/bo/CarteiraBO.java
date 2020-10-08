package br.com.rafakrieger.model.bo;

import java.util.ArrayList;

import br.com.rafakrieger.model.dao.CarteiraDAO;
import br.com.rafakrieger.model.vo.CarteiraVO;
import br.com.rafakrieger.model.vo.InvestidorVO;

public class CarteiraBO {

	public void cadastrarLimitesCarteiraBO(CarteiraVO carteiraVO) {
		CarteiraDAO carteiraDAO = new CarteiraDAO();
		int resultado = carteiraDAO.cadastrarLimitesCarteiraDAO(carteiraVO);
		if (resultado == 1) {
			System.out.println("\nLimites cadastrados com sucesso");
		} else {
			System.out.println("\nNão foi possível cadastrar os limites");
		}
	}

	public ArrayList<CarteiraVO> consultarCarteiraBO(InvestidorVO investidorVO) {
		CarteiraDAO carteiraDAO = new CarteiraDAO();
		ArrayList<CarteiraVO> dadosCarteiraVO = carteiraDAO.consultarCarteiraDAO(investidorVO);
		if (dadosCarteiraVO.isEmpty()) {
			System.out.println("\nNão existem dados na carteira!");
		}
		return dadosCarteiraVO;
	}

}
