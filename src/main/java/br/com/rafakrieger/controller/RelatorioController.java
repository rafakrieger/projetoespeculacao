package br.com.rafakrieger.controller;

import java.util.ArrayList;

import br.com.rafakrieger.model.dao.RelatorioDAO;
import br.com.rafakrieger.model.dto.PapelDTO;

public class RelatorioController {

	public ArrayList<PapelDTO> consultarPapeisController() {
		RelatorioDAO relatorioDAO = new RelatorioDAO();		
		return relatorioDAO.consultarPapeisDAO();
	}

}
