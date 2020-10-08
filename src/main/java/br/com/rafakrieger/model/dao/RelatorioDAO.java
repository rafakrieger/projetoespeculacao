package br.com.rafakrieger.model.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import br.com.rafakrieger.model.dto.PapelDTO;

public class RelatorioDAO {

	public ArrayList<PapelDTO> consultarPapeisDAO() {
		Connection conn = Banco.getConnection();
		Statement stmt = Banco.getStatement(conn);
		ResultSet resultado = null;		
		ArrayList<PapelDTO> listaPapelDTO = new ArrayList<PapelDTO>();
		String query = "SELECT ID_PAPEL, NOME_PAPEL, VALOR_ATUAL, VALOR_ANTERIOR, VARIACAO FROM VW_PAPEIS";
		
		try {
			resultado = stmt.executeQuery(query);
			while (resultado.next()) {
				PapelDTO papel = new PapelDTO();
				papel.setIdPapel(Integer.parseInt(resultado.getString(1)));
				papel.setNome(resultado.getString(2));
				papel.setValorAtual(Double.parseDouble(resultado.getString(3)));
				papel.setValorAnterior(Double.parseDouble(resultado.getString(4)));
				papel.setVariacao(Double.parseDouble(resultado.getString(5)));
				listaPapelDTO.add(papel);
			}
		} catch (SQLException e) {
			System.out.println("Erro ao executar a query de relatório de variação de papéis");
			System.out.println("Erro: "+e.getMessage());
		} finally {
			Banco.closeResultSet(resultado);
			Banco.closeStatement(stmt);
			Banco.closeConnection(conn);
		}		
		return listaPapelDTO;
	}

}
