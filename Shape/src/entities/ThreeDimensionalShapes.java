package entities;

public abstract class ThreeDimensionalShapes extends Shape {
	
	public ThreeDimensionalShapes(String nome) {
		super(nome);
	}

	public abstract double calcArea();
	public abstract double calcVolu();
}