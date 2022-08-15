package entities;

public abstract class Shape {
	private String nome;

	public Shape(String nome) {
		super();
		this.nome = nome;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	@Override
	public String toString() {
		return "Shape [nome=" + nome + "]";
	}

}
