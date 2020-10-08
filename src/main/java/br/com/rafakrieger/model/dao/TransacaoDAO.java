package br.com.rafakrieger.model.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

import br.com.rafakrieger.model.vo.InvestidorVO;
import br.com.rafakrieger.model.vo.TransacaoVO;


public class TransacaoDAO {
	
	DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");


	public int cadastrarTransacaoDAO(TransacaoVO transacaoVO) {
		Connection conn = Banco.getConnection();
		Statement stmt = Banco.getStatement(conn);
		Statement stmt2 = Banco.getStatement(conn);
		ResultSet rs = null;
		int resultado = 0;	
		
		String query = "INSERT INTO transacao (idinvestidor, idpapel, qtde, valor, operacao, dttransacao) VALUES ('"
				+ transacaoVO.getIdInvestidor() + "', '"
				+ transacaoVO.getIdPapel() + "', '"
				+ transacaoVO.getQtde() + "', '"
				+ this.obterValorPapel(transacaoVO) + "', '"
				+ transacaoVO.getOperacao() + "', "
				+ "NOW())";
		
		try {
			resultado = stmt.executeUpdate(query);
			rs = stmt2.executeQuery("SELECT DISTINCT idinvestidor FROM transacao");
			while (rs.next()) {
				int id = rs.getInt(1);
				stmt.executeUpdate("CALL SP_DISPARADOR("+id+", "+transacaoVO.getIdPapel()+")");
			}
		} catch (SQLException e) {
			System.out.println("Erro ao executar a query de cadastro de transação");
			System.out.println("Erro: "+e.getMessage());;
		} finally {
			Banco.closeResultSet(rs);
			Banco.closeStatement(stmt2);
			Banco.closeStatement(stmt);
			Banco.closeConnection(conn);
		}		
		return resultado;
	}

	private Double obterValorPapel(TransacaoVO transacaoVO) {
		Connection conn = Banco.getConnection();
		Statement stmt = Banco.getStatement(conn);
		ResultSet resultado = null;		
		Double valor = 0.0;
		
		String query = "SELECT valor FROM papel WHERE idpapel = '" + transacaoVO.getIdPapel() + "' ";
		try {
			resultado = stmt.executeQuery(query);
			if (resultado.next()) {
				valor = resultado.getDouble(1);
			}
		} catch (SQLException e) {
			System.out.println("Erro ao executar a consulta do valor do papel");
			System.out.println("Erro: "+ e.getMessage());			
		} finally {
			Banco.closeResultSet(resultado);
			Banco.closeStatement(stmt);
			Banco.closeConnection(conn);
		}
		return valor;
	}

	public ArrayList<TransacaoVO> consultarTodasTransacoesDAO(InvestidorVO investidorVO) {
		Connection conn = Banco.getConnection();
		Statement stmt = Banco.getStatement(conn);
		ResultSet resultado = null;	
		ArrayList<TransacaoVO> listaTransacoesVO = new ArrayList<TransacaoVO>();			
		
		String query = "SELECT idtransacao, idinvestidor, idpapel, qtde, valor, operacao, dttransacao "
				+"FROM transacao WHERE idinvestidor IN (SELECT idinvestidor FROM investidor WHERE login = '"+investidorVO.getLogin()+"')";
		
		try {
			resultado = stmt.executeQuery(query);
			while (resultado.next()) {
				TransacaoVO transacao = new TransacaoVO();
				transacao.setIdTransacao(Integer.parseInt(resultado.getString(1)));
				transacao.setIdInvestidor(Integer.parseInt(resultado.getString(2)));
				transacao.setIdPapel(Integer.parseInt(resultado.getString(3)));
				transacao.setQtde(Integer.parseInt(resultado.getString(4)));
				transacao.setValor(Double.parseDouble(resultado.getString(5)));
				transacao.setOperacao(resultado.getString(6));				
				transacao.setDtTransacao(LocalDate.parse(resultado.getString(7), dateFormatter));
				listaTransacoesVO.add(transacao);
			}
		} catch (SQLException e) {
			System.out.println("Erro ao executar a query de consulta de todas as transações de um usuário");
			System.out.println("Erro: "+e.getMessage());
		} finally {
			Banco.closeResultSet(resultado);
			Banco.closeStatement(stmt);
			Banco.closeConnection(conn);
			
		}		
		return listaTransacoesVO;
	}

	public TransacaoVO consultarTransacaoDAO(TransacaoVO transacaoVO) {
		Connection conn = Banco.getConnection();
		Statement stmt = Banco.getStatement(conn);
		ResultSet resultado = null;
		TransacaoVO transacao = null;				
		
		String query = "SELECT idtransacao, idinvestidor, idpapel, qtde, valor, operacao, dttransacao FROM transacao"
				+ " WHERE idtransacao = "+transacaoVO.getIdTransacao();
		
		try {
			resultado = stmt.executeQuery(query);
			if (resultado.next()) {
				transacao = new TransacaoVO();
				transacao.setIdTransacao(Integer.parseInt(resultado.getString(1)));
				transacao.setIdInvestidor(Integer.parseInt(resultado.getString(2)));
				transacao.setIdPapel(Integer.parseInt(resultado.getString(3)));
				transacao.setQtde(Integer.parseInt(resultado.getString(4)));
				transacao.setValor(Double.parseDouble(resultado.getString(5)));
				transacao.setOperacao(resultado.getString(6));				
				transacao.setDtTransacao(LocalDate.parse(resultado.getString(7), dateFormatter));				
			}
		} catch (SQLException e) {
			System.out.println("Erro ao executar a query de consulta de uma transação específica");
			System.out.println("Erro: "+e.getMessage());
		} finally {
			Banco.closeResultSet(resultado);
			Banco.closeStatement(stmt);
			Banco.closeConnection(conn);
			
		}		
		return transacao;
	}

	public boolean existeRegistroPorIdTransacao(int idTransacao) {
		Connection conn = Banco.getConnection();
		Statement stmt = Banco.getStatement(conn);
		ResultSet resultado = null;		
		
		String query = "SELECT idtransacao FROM transacao WHERE idtransacao = '" + idTransacao + "' ";
		try {
			resultado = stmt.executeQuery(query);
			if(resultado.next()) {
				return true;
			}
		} catch (SQLException e) {
			System.out.println("Erro ao executar a verificação da existência de transação por ID");
			System.out.println("Erro: "+ e.getMessage());			
		} finally {
			Banco.closeResultSet(resultado);
			Banco.closeStatement(stmt);
			Banco.closeConnection(conn);
		}
		return false;
	}

	public int atualizarTransacaoDAO(TransacaoVO transacaoVO) {
		Connection conn = Banco.getConnection();
		Statement stmt = Banco.getStatement(conn);
		int resultado = 0;
		
		String query = "UPDATE transacao SET "
				+ "idinvestidor = "+transacaoVO.getIdInvestidor() + ", "
				+ "idpapel = "+transacaoVO.getIdPapel() + ", "
				+ "qtde = "+transacaoVO.getQtde() + ", "
				+ "valor = "+this.obterValorPapel(transacaoVO) + ", "
				+ "operacao = '"+transacaoVO.getOperacao() + "', "
				+ "dttransacao = NOW()"
				+ "WHERE idtransacao = "+transacaoVO.getIdTransacao();	
		try {
			resultado = stmt.executeUpdate(query);
		} catch (SQLException e) {
			System.out.println("Erro ao executar a query de atualização de transação");
			System.out.println("Erro: "+e.getMessage());;
		} finally {
			Banco.closeStatement(stmt);
			Banco.closeConnection(conn);
		}		
		return resultado;
	}

	public int excluirTransacaoDAO(TransacaoVO transacaoVO) {
		Connection conn = Banco.getConnection();
		Statement stmt = Banco.getStatement(conn);
		int resultado = 0;
		
		String query = "DELETE FROM transacao WHERE idtransacao = "+transacaoVO.getIdTransacao();
		
		try {
			resultado = stmt.executeUpdate(query);
		} catch (SQLException e) {
			System.out.println("Erro ao executar a query de exclusão de transação");
			System.out.println("Erro: "+e.getMessage());;
		} finally {
			Banco.closeStatement(stmt);
			Banco.closeConnection(conn);
		}
		return resultado;		
	}

}
