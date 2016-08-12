package main.semana04Complementar;

public class CompraParcelada extends Compra {

	private int parcelas;
	private Double juros;

	public CompraParcelada(Double valorDaCompra, int parcelas, Double juros) {
		super(valorDaCompra);
		this.parcelas = parcelas;
		this.juros = juros;		
	}
	
	@Override
	public Double total() {
		return super.total() * Math.pow((1 + juros),parcelas);
	}

}
