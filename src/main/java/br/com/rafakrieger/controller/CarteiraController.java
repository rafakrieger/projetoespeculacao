package br.com.rafakrieger.controller;

import java.util.ArrayList;

import br.com.rafakrieger.model.bo.CarteiraBO;
import br.com.rafakrieger.model.vo.CarteiraVO;
import br.com.rafakrieger.model.vo.InvestidorVO;

public class CarteiraController {

	public void cadastrarLimitesCarteiraController(CarteiraVO carteiraVO) {
		CarteiraBO carteiraBO = new CarteiraBO();
		carteiraBO.cadastrarLimitesCarteiraBO(carteiraVO);		
	}

	public ArrayList<CarteiraVO> consultarCarteiraController(InvestidorVO investidorVO) {
		CarteiraBO carteiraBO = new CarteiraBO();
		return carteiraBO.consultarCarteiraBO(investidorVO);
	}

}
