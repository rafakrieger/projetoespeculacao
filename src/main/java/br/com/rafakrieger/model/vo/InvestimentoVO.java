package br.com.rafakrieger.model.vo;

public abstract class InvestimentoVO {
	
	private int idInvestidor;
	private int idPapel;
	private double valor;
	private int qtde;
	
	public InvestimentoVO() {
		super();
	}

	public InvestimentoVO(int idInvestidor, int idPapel, double valor, int qtde) {
		super();
		this.idInvestidor = idInvestidor;
		this.idPapel = idPapel;
		this.valor = valor;
		this.qtde = qtde;
	}

	public int getIdInvestidor() {
		return idInvestidor;
	}

	public void setIdInvestidor(int idInvestidor) {
		this.idInvestidor = idInvestidor;
	}

	public int getIdPapel() {
		return idPapel;
	}

	public void setIdPapel(int idPapel) {
		this.idPapel = idPapel;
	}

	public double getValor() {
		return valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}

	public int getQtde() {
		return qtde;
	}

	public void setQtde(int qtde) {
		this.qtde = qtde;
	}

	
	

}
