package br.com.rafakrieger.model.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import br.com.rafakrieger.model.vo.CarteiraVO;
import br.com.rafakrieger.model.vo.InvestidorVO;

public class CarteiraDAO {

	public int cadastrarLimitesCarteiraDAO(CarteiraVO carteiraVO) {
		Connection conn = Banco.getConnection();
		Statement stmt = Banco.getStatement(conn);
		int resultado = 0;		
		
		String query = "UPDATE carteira SET "
				+ "limite_inferior_valor = "+carteiraVO.getLimiteInferiorValor()+", "
				+ "limite_superior_valor = "+carteiraVO.getLimiteSuperiorValor()+", "
				+ "limite_inferior_perc = "+carteiraVO.getLimiteInferiorPerc() * -1 +", "
				+ "limite_superior_perc = "+carteiraVO.getLimiteSuperiorPerc()+" "
				+ "WHERE idinvestidor = "+carteiraVO.getIdInvestidor()+" "
				+ "AND idpapel = "+carteiraVO.getIdPapel();		
		try {
			resultado = stmt.executeUpdate(query);
		} catch (SQLException e) {
			System.out.println("Erro ao executar a query de cadastro de limites");
			System.out.println("Erro: "+e.getMessage());;
		} finally {
			Banco.closeStatement(stmt);
			Banco.closeConnection(conn);
		}		
		return resultado;
	}

	public ArrayList<CarteiraVO> consultarCarteiraDAO(InvestidorVO investidorVO) {
		Connection conn = Banco.getConnection();
		Statement stmt = Banco.getStatement(conn);
		ResultSet resultado = null;	
		ArrayList<CarteiraVO> dadosCarteiraVO = new ArrayList<CarteiraVO>();			
		
		String query = "SELECT idinvestidor, idpapel, qtde, valor, limite_inferior_valor, limite_superior_valor, limite_inferior_perc, "
				+ "limite_superior_perc FROM carteira WHERE idinvestidor IN "
				+ "(SELECT idinvestidor FROM investidor WHERE login = '"+investidorVO.getLogin()+"')";
		
		try {
			resultado = stmt.executeQuery(query);
			while (resultado.next()) {
				CarteiraVO carteira = new CarteiraVO();
				carteira.setIdInvestidor(Integer.parseInt(resultado.getString(1)));
				carteira.setIdPapel(Integer.parseInt(resultado.getString(2)));
				carteira.setQtde(Integer.parseInt(resultado.getString(3)));
				carteira.setValor(Double.parseDouble(resultado.getString(4)));
				carteira.setLimiteInferiorValor(Double.parseDouble(resultado.getString(5)));
				carteira.setLimiteSuperiorValor(Double.parseDouble(resultado.getString(6)));			
				carteira.setLimiteInferiorPerc(Double.parseDouble(resultado.getString(7)));
				carteira.setLimiteInferiorPerc(Double.parseDouble(resultado.getString(8)));
				dadosCarteiraVO.add(carteira);
			}
		} catch (SQLException e) {
			System.out.println("Erro ao executar a query de consulta de carteira");
			System.out.println("Erro: "+e.getMessage());
		} finally {
			Banco.closeResultSet(resultado);
			Banco.closeStatement(stmt);
			Banco.closeConnection(conn);
			
		}		
		return dadosCarteiraVO;
	}

}
