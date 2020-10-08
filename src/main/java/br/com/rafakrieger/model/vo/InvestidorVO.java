package br.com.rafakrieger.model.vo;

public class InvestidorVO {
	
	private int idInvestidor;
	private String nome;
	private String login;
	private String senha;
	private double capital;
	
	public InvestidorVO() {
		super();
	}

	public InvestidorVO(int idInvestidor, String nome, String login, String senha, double capital) {
		super();
		this.idInvestidor = idInvestidor;
		this.nome = nome;
		this.login = login;
		this.senha = senha;
		this.capital = capital;
	}

	public int getIdInvestidor() {
		return idInvestidor;
	}

	public void setIdInvestidor(int idInvestidor) {
		this.idInvestidor = idInvestidor;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public double getCapital() {
		return capital;
	}

	public void setCapital(double capital) {
		this.capital = capital;
	}
	
	
	public void imprimir() {
		System.out.printf("%-5d  %-30s  %-15s \n",
				this.getIdInvestidor(),
				this.getNome(),
				this.getCapital());		
	}

}
