package mod.services;

public  class PagamentoServico implements PagamentoServicoOnline{
	
	private static final double taxa = 0.02;
	private static final double jurosMensal = 0.01;
	
	@Override
	public double taxaPagamento(double valor) {
		return valor * taxa  ;
	}
	@Override
	public double juros(double valor, int meses) {
		return valor * jurosMensal * meses;
		
	}

}
