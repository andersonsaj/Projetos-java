package application;

public class Pessoa {
	private String nome;
	private Integer idade;
	public Pessoa() {}
	public Pessoa(String nome) {
		this.nome =nome;
	}
	
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public String toString() {
		return getNome() + idade;
	}
	public Integer getIdade() {
		return idade;
	}
	public void setIdade(Integer idade) {
		this.idade = idade;
	}
	

}
