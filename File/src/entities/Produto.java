package entities;

public class Produto {
	
	private String name;
	private Double preco;
	private Integer quantidade;

	public Produto(String name, double preco, int quant) {
		this.name = name;
		this.preco = preco;
		quantidade = quant;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Double getPreco() {
		return preco;
	}

	public void setPreco(Double preco) {
		this.preco = preco;
	}

	public Integer getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}
	public double valorTotal() {
		return preco * quantidade;
	}
}
