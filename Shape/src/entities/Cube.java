package entities;

public class Cube extends ThreeDimensionalShapes{
	private double base;
	
	public Cube(String nome, double base) {
		super(nome);
		this.base = base;
	}

	public double getBase() {
		return base;
	}

	public void setBase(double base) {
		this.base = base;
	}

	@Override
	public double calcArea() {
		
		return 4 * base;
	}

	@Override
	public String toString() {
		return "Cube [[Área=" + this.calcArea() + " Volume=" + this.calcVolu() +"]"; 
	}

	@Override
	public double calcVolu() {
		return Math.pow(base, 3);
	}
	
}
