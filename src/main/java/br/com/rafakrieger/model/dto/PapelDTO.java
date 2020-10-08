package br.com.rafakrieger.model.dto;

public class PapelDTO {
	
	private int idPapel;
	private String nome;
	private double valorAtual;
	private double valorAnterior;
	private double variacao;
	
	public PapelDTO() {
		super();
	}

	public PapelDTO(int idPapel, String nome, double valorAtual, double valorAnterior, double variacao) {
		super();
		this.idPapel = idPapel;
		this.nome = nome;
		this.valorAtual = valorAtual;
		this.valorAnterior = valorAnterior;
		this.variacao = variacao;
	}

	public int getIdPapel() {
		return idPapel;
	}

	public void setIdPapel(int idPapel) {
		this.idPapel = idPapel;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public double getValorAtual() {
		return valorAtual;
	}

	public void setValorAtual(double valorAtual) {
		this.valorAtual = valorAtual;
	}

	public double getValorAnterior() {
		return valorAnterior;
	}

	public void setValorAnterior(double valorAnterior) {
		this.valorAnterior = valorAnterior;
	}

	public double getVariacao() {
		return variacao;
	}

	public void setVariacao(double variacao) {
		this.variacao = variacao;
	}
	
	public void imprimir() {
		System.out.printf("%-15d  %-30s  %-20s  %-20s  %-15s \n",
				this.getIdPapel(),
				this.getNome(),
				this.getValorAtual(),
				this.getValorAnterior(),
				this.getVariacao()+"%");
		
	}
	
	

}
