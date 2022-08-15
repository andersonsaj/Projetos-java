package exceptions;

public class Divisao {

	private double n1;
	private double n2;
	
	public Divisao(double n1, double n2) {
		this.n1 = n1;
		if(n2>0) {
		this.n2 = n2;
		}else {
			throw new ArithmeticException("Número tem que ser maior que 0");
		}
	}
	
	public double divide() {
		return n1 / n2;
	}
}
