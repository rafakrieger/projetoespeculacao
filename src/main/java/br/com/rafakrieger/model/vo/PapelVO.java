package br.com.rafakrieger.model.vo;

public class PapelVO {
	
	private int idPapel;
	private String nomePapel;
	private double valorPapel;
	private int qtdePapel;
	
	public PapelVO() {
		super();
	}

	public PapelVO(int idPapel, String nomePapel, double valorPapel, int qtdePapel) {
		super();
		this.idPapel = idPapel;
		this.nomePapel = nomePapel;
		this.valorPapel = valorPapel;
		this.qtdePapel = qtdePapel;
	}

	public int getIdPapel() {
		return idPapel;
	}

	public void setIdPapel(int idPapel) {
		this.idPapel = idPapel;
	}

	public String getNomePapel() {
		return nomePapel;
	}

	public void setNomePapel(String nomePapel) {
		this.nomePapel = nomePapel;
	}

	public double getValorPapel() {
		return valorPapel;
	}

	public void setValorPapel(double valorPapel) {
		this.valorPapel = valorPapel;
	}

	public int getQtdePapel() {
		return qtdePapel;
	}

	public void setQtdePapel(int qtdePapel) {
		this.qtdePapel = qtdePapel;
	}
	
	
	public void imprimir() {
		System.out.printf("%-5d  %-30s  %-15s  %-15s \n",
				this.getIdPapel(),
				this.getNomePapel(),
				this.getValorPapel(),
				this.getQtdePapel());
		
	}
	

}
