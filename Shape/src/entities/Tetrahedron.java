package entities;

public class Tetrahedron extends ThreeDimensionalShapes{
	private double aresta;
	
	public Tetrahedron(String nome,double aresta) {
		super(nome);
		this.aresta = aresta;
	}

	@Override
	public double calcArea() {
		return Math.pow(aresta, 2) * Math.sqrt(3) ;
	}

	@Override
	public double calcVolu() {
		return (Math.pow(aresta, 3) * Math.sqrt(2)) / 12 ;
	}

	@Override
	public String toString() {
		return "Tetrahedron [Área=" + String.format("%.2f",this.calcArea()) + 
				" Volume=" + String.format("%.2f",this.calcVolu()) +"]";
	}
}
