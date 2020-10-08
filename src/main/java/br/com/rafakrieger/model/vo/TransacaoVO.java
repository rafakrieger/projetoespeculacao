package br.com.rafakrieger.model.vo;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class TransacaoVO extends InvestimentoVO {
	
	DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
	
	private int idTransacao;
	private String operacao;
	private LocalDate dtTransacao;
	
	public TransacaoVO() {
		super();
	}

	public TransacaoVO(int idTransacao, int idInvestidor, int idPapel, double valor, int qtde, DateTimeFormatter dateFormatter,
			String operacao, LocalDate dtTransacao) {
		super(idInvestidor, idPapel, valor, qtde);
		this.idTransacao = idTransacao;
		this.operacao = operacao;
		this.dtTransacao = dtTransacao;
	}
	
	
	
	public int getIdTransacao() {
		return idTransacao;
	}

	public void setIdTransacao(int idTransacao) {
		this.idTransacao = idTransacao;
	}

	public String getOperacao() {
		return operacao;
	}

	public void setOperacao(String operacao) {
		this.operacao = operacao;
	}

	public LocalDate getDtTransacao() {
		return dtTransacao;
	}

	public void setDtTransacao(LocalDate dtTransacao) {
		this.dtTransacao = dtTransacao;
	}
	
	
	public void imprimir() {
		System.out.printf("%-5d  %-15d  %-15d  %-15s  %-15s  %-15s  %-15s \n",
				this.getIdTransacao(),
				this.getIdInvestidor(),
				this.getIdPapel(),
				this.getValor(),
				this.getQtde(),
				this.getOperacao(),
				this.getDtTransacao().format(dateFormatter));		
	}	

}
