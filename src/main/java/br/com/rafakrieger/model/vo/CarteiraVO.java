package br.com.rafakrieger.model.vo;

public class CarteiraVO extends InvestimentoVO {
	
	private double limiteInferiorValor;
	private double limiteSuperiorValor;
	private double limiteInferiorPerc;
	private double limiteSuperiorPerc;
	
	public CarteiraVO() {
		super();
	}

	public CarteiraVO(int idInvestidor, int idPapel, double valor, int qtde, double limiteInferiorValor,
			double limiteSuperiorValor, double limiteInferiorPerc, double limiteSuperiorPerc) {
		super(idInvestidor, idPapel, valor, qtde);
		this.limiteInferiorValor = limiteInferiorValor;
		this.limiteSuperiorValor = limiteSuperiorValor;
		this.limiteInferiorPerc = limiteInferiorPerc;
		this.limiteSuperiorPerc = limiteSuperiorPerc;
	}

	public double getLimiteInferiorValor() {
		return limiteInferiorValor;
	}

	public void setLimiteInferiorValor(double limiteInferiorValor) {
		this.limiteInferiorValor = limiteInferiorValor;
	}

	public double getLimiteSuperiorValor() {
		return limiteSuperiorValor;
	}

	public void setLimiteSuperiorValor(double limiteSuperiorValor) {
		this.limiteSuperiorValor = limiteSuperiorValor;
	}

	public double getLimiteInferiorPerc() {
		return limiteInferiorPerc;
	}

	public void setLimiteInferiorPerc(double limiteInferiorPerc) {
		this.limiteInferiorPerc = limiteInferiorPerc;
	}

	public double getLimiteSuperiorPerc() {
		return limiteSuperiorPerc;
	}

	public void setLimiteSuperiorPerc(double limiteSuperiorPerc) {
		this.limiteSuperiorPerc = limiteSuperiorPerc;
	}
	
	
	public void imprimir() {
		System.out.printf("%-15d  %-15d  %-15s  %-15s  %-15s  %-15s %-15s  %-15s \n",
				this.getIdInvestidor(),
				this.getIdPapel(),
				this.getValor(),
				this.getQtde(),
				this.getLimiteInferiorValor(),
				this.getLimiteSuperiorValor(),
				this.getLimiteInferiorPerc(),
				this.getLimiteSuperiorPerc());
		
	}


}
