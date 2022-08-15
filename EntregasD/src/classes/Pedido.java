package classes;

import java.util.Comparator;
import java.util.Date;
import java.util.List;

import enums.FormaPagamento;
import enums.StatusPedido;

public class Pedido  implements Comparator<Pedido>{

	private Cliente cliente;
	private List<Produto> produtos;
	private Funcionario atendente;
	private Funcionario entregador;
	private Endereco endereco;
	private boolean entrega;
	private double desconto;
	private double taxaEntrega;
	private double valor;
	private FormaPagamento formaPagamento;
	private double troco;
	private Date data;
	private Date hora;
	private StatusPedido status;
	
	
	
	public List<Produto> getProdutos() {
		return produtos;
	}

	public void setProdutos(List<Produto> produtos) {
		this.produtos = produtos;
	}

	public Funcionario getAtendente() {
		return atendente;
	}

	public void setAtendente(Funcionario atendente) {
		this.atendente = atendente;
	}

	public Funcionario getEntregador() {
		return entregador;
	}

	public void setEntregador(Funcionario entregador) {
		this.entregador = entregador;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}



	public boolean isEntrega() {
		return entrega;
	}



	public void setEntrega(boolean entrega) {
		this.entrega = entrega;
	}



	public double getDesconto() {
		return desconto;
	}



	public void setDesconto(double desconto) {
		this.desconto = desconto;
	}



	public double getTaxaEntrega() {
		return taxaEntrega;
	}



	public void setTaxaEntrega(double taxaEntrega) {
		this.taxaEntrega = taxaEntrega;
	}



	public double getValor() {
		return valor;
	}



	public void setValor(double valor) {
		this.valor = valor;
	}



	public FormaPagamento getFormaPagamento() {
		return formaPagamento;
	}



	public void setFormaPagamento(FormaPagamento formaPagamento) {
		this.formaPagamento = formaPagamento;
	}



	public double getTroco() {
		return troco;
	}



	public void setTroco(double troco) {
		this.troco = troco;
	}


	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public Date getHora() {
		return hora;
	}

	public void setHora(Date hora) {
		this.hora = hora;
	}

	public StatusPedido getStatus() {
		return status;
	}

	public void setStatus(StatusPedido status) {
		this.status = status;
	}

	@Override
	public int compare(Pedido p1, Pedido p2) {
		if (p1.data.getTime() == p2.data.getTime())
			return 0;
		else
			if (p1.data.getTime() > p2.data.getTime())
				return -1;
			else
				return 1;
	}

}
