package br.com.rafakrieger.model.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import br.com.rafakrieger.model.vo.InvestidorVO;

public class InvestidorDAO {

	public int cadastrarInvestidorDAO(InvestidorVO investidorVO) {		
		Connection conn = Banco.getConnection();
		Statement stmt = Banco.getStatement(conn);
		int resultado = 0;		
		
		String query = "INSERT INTO investidor (nome, login, senha, capital) VALUES ('"
				+ investidorVO.getNome() + "', '"
				+ investidorVO.getLogin() + "', '"
				+ investidorVO.getSenha() + "', '"
				+ investidorVO.getCapital()+ "')";
		
		try {
			resultado = stmt.executeUpdate(query);
			stmt.executeQuery("CALL SP_ADD_USUARIO(LAST_INSERT_ID())");
		} catch (SQLException e) {
			System.out.println("Erro ao executar a query de cadastro de usuário");
			System.out.println("Erro: "+e.getMessage());;
		} finally {
			Banco.closeStatement(stmt);
			Banco.closeConnection(conn);
		}		
		return resultado;
	}

	public ArrayList<InvestidorVO> consultarTodosInvestidoresDAO() {
		Connection conn = Banco.getConnection();
		Statement stmt = Banco.getStatement(conn);
		ResultSet resultado = null;	
		ArrayList<InvestidorVO> listaInvestidoresVO = new ArrayList<InvestidorVO>();			
		
		String query = "SELECT idinvestidor, nome, capital FROM investidor";
		
		try {
			resultado = stmt.executeQuery(query);
			while (resultado.next()) {
				InvestidorVO investidor = new InvestidorVO();
				investidor.setIdInvestidor(Integer.parseInt(resultado.getString(1)));
				investidor.setNome(resultado.getString(2));
				investidor.setCapital(Double.parseDouble(resultado.getString(3)));				
				listaInvestidoresVO.add(investidor);
			}
		} catch (SQLException e) {
			System.out.println("Erro ao executar a query de consulta de todos os investidores");
			System.out.println("Erro: "+e.getMessage());
		} finally {
			Banco.closeResultSet(resultado);
			Banco.closeStatement(stmt);
			Banco.closeConnection(conn);
			
		}		
		return listaInvestidoresVO;
	}

	public InvestidorVO consultarInvestidorDAO(InvestidorVO investidorVO) {
		Connection conn = Banco.getConnection();
		Statement stmt = Banco.getStatement(conn);
		ResultSet resultado = null;
		InvestidorVO investidor = null;				
		
		String query = "SELECT idinvestidor, nome, capital FROM investidor WHERE idinvestidor = "+investidorVO.getIdInvestidor();
		
		try {
			resultado = stmt.executeQuery(query);
			if (resultado.next()) {
				investidor = new InvestidorVO();
				investidor.setIdInvestidor(Integer.parseInt(resultado.getString(1)));
				investidor.setNome(resultado.getString(2));
				investidor.setCapital(Double.parseDouble(resultado.getString(3)));				
			}
		} catch (SQLException e) {
			System.out.println("Erro ao executar a query de consulta de um investidor específico");
			System.out.println("Erro: "+e.getMessage());
		} finally {
			Banco.closeResultSet(resultado);
			Banco.closeStatement(stmt);
			Banco.closeConnection(conn);
			
		}		
		return investidor;
	}
	
	public boolean existeRegistroPorLogin(String login) {
		Connection conn = Banco.getConnection();
		Statement stmt = Banco.getStatement(conn);
		ResultSet resultado = null;		
		
		String query = "SELECT idinvestidor FROM investidor WHERE login = '" + login + "' ";
		try {
			resultado = stmt.executeQuery(query);
			if(resultado.next()) {
				return true;
			}
		} catch (SQLException e) {
			System.out.println("Erro ao executar a verificação da existência de usuário por login");
			System.out.println("Erro: "+ e.getMessage());			
		} finally {
			Banco.closeResultSet(resultado);
			Banco.closeStatement(stmt);
			Banco.closeConnection(conn);
		}
		return false;
	}

	public int atualizarInvestidorDAO(InvestidorVO investidorVO) {
		Connection conn = Banco.getConnection();
		Statement stmt = Banco.getStatement(conn);
		int resultado = 0;
		
		String query = "UPDATE investidor SET nome = '"+investidorVO.getNome()
					+"', senha = '"+investidorVO.getSenha()
					+"' WHERE login = '"+investidorVO.getLogin()+"'";
		
		try {
			resultado = stmt.executeUpdate(query);
			stmt.executeQuery("CALL SP_UPDATE_SENHA("+ investidorVO.getIdInvestidor()+", '"+investidorVO.getSenha()+"')");
		} catch (SQLException e) {
			System.out.println("Erro ao executar a query de atualização de usuário");
			System.out.println("Erro: "+e.getMessage());
		} finally {
			Banco.closeStatement(stmt);
			Banco.closeConnection(conn);
		}
		return resultado;
	}

}



