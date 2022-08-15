package mod.services;

import java.util.Calendar;
import java.util.Date;

import mod.entities.Contrato;
import mod.entities.Prestacao;

public class ContratoServico {
	
	private PagamentoServicoOnline pagamentoServicoOnline;
	
	
	public ContratoServico(PagamentoServicoOnline pagamentoServicoOnline) {
		this.pagamentoServicoOnline = pagamentoServicoOnline;
	}


	public void processContrato(Contrato contrato, Integer meses) {
		double cotaBasica = contrato.getValorTotal() / meses;
		
		for(int i =1; i<= meses; i++) {
			Date date = addMeses(contrato.getData(),i);
			double updateCota = cotaBasica + pagamentoServicoOnline.juros(cotaBasica, i);
			double cotaTotal = updateCota + pagamentoServicoOnline.taxaPagamento(updateCota);
			contrato.addPrestacao(new Prestacao(date, cotaTotal));
		}
	}
	private Date addMeses(Date date, int n) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		cal.add(Calendar.MONTH, n);
		return cal.getTime();
	}
}
