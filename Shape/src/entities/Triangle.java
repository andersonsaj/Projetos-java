package entities;

public class Triangle extends TwoDimensionalShape{

	private double base;
	private double altura;
	
	public Triangle(String nome,double base, double altura) {
		super(nome);
		this.base = base;
		this.altura = altura;
	}

	@Override	
	public double calcArea() {
		
		return (base * altura)/2;
	}

	@Override
	public String toString() {
		return "Triângulo [Área=" + this.calcArea() +  "]";
	
	}
}
