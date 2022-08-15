package entities;

public class Sphere extends ThreeDimensionalShapes {
	private double raio;

	public Sphere(String nome, double raio) {
		super(nome);
		this.raio = raio;
	}

	@Override
	public double calcArea() {
		return 4 * 3.14 * Math.pow(raio, 2);
	}
	@Override
	public double calcVolu() {
		return (4/3) * 3.14 * Math.pow(raio, 3);
	}
	public double getRaio() {
		return raio;
	}

	public void setRaio(double raio) {
		this.raio = raio;
	}

	@Override
	public String toString() {
		return "Sphere [Área=" + this.calcArea() + " Volume=" + this.calcVolu() +"]";
	}
}
