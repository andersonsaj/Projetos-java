package entities;

public abstract class TwoDimensionalShape extends Shape {
	
	public TwoDimensionalShape(String nome) {
		super(nome);
	}
	
	public abstract double calcArea();
}
