package entities;

public class Circle extends TwoDimensionalShape{
	private double raio;
	
	public Circle(String nome,double raio) {
		super(nome);
		this.raio =raio;
	}
	@Override
	public double calcArea() {
		
		return Math.pow(raio, 2)* 3.14;
				
	}
	@Override
	public String toString() {
		return "Circle [Área=" + this.calcArea() + "]";
	}
	
}
