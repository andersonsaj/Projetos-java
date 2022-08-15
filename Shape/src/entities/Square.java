package entities;

public class Square extends TwoDimensionalShape {

	private double base;
	private double altura;
	
	public Square(String nome,double base, double altura) {
		super(nome);
		this.base = base;
		this.altura = altura;
	}

	@Override
	public double calcArea() {
		
		return base * altura;
	}

	@Override
	public String toString() {
		return "Square [Área=" + this.calcArea() +  "]";
	}
	
}
