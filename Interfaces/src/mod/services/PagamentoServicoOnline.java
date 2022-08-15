package mod.services;

public interface PagamentoServicoOnline {
	
	double taxaPagamento(double valor);
	
	double juros(double valor, int meses);
}
