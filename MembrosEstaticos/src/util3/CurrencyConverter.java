package util3;

public class CurrencyConverter {
	public static double dollar;
	public static double reais;
	
	public static double converter() {
		return dollar * reais * 6 /100 + dollar * reais;
	}
}
