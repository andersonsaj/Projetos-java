package entities;

public class CommissionEmployee extends Employee {
	
	private double grossSales; // vendas brutas semanais
	private double commissionRate; // percentagem da comiss�o
	
	
	// construtor de cinco argumentos
	public CommissionEmployee(String firstName, String lastName, String socialSecurityNumber, double grossSales,
			double commissionRate) {
		super(firstName,lastName,socialSecurityNumber);
		// a chamada impl�cita para o construtor padr�o de Object ocorre aqui continua

		// se grossSales � inv�lido, lan�a uma exce��o
		if (grossSales < 0.0)
			throw new IllegalArgumentException("Gross sales must be >= 0.0");

		// se commissionRate � inv�lido, lan�a uma exce��o
		if (commissionRate <= 0.0 || commissionRate >= 1.0)
			throw new IllegalArgumentException("Commission rate must be > 0.0 and < 1.0");

		

		this.grossSales = grossSales;
		this.commissionRate = commissionRate;
	} // fim do construtor

	// configura a quantidade de vendas brutas
	public void setGrossSales(double grossSales) {
		if (grossSales < 0.0)
			throw new IllegalArgumentException("Gross sales must be >= 0.0");

		this.grossSales = grossSales;
	}

	// retorna a quantidade de vendas brutas
	public double getGrossSales() {
		return grossSales;
	}

	// configura a taxa de comiss�o
	public void setCommissionRate(double commissionRate) {
		if (commissionRate <= 0.0 || commissionRate >= 1.0)
			throw new IllegalArgumentException("Commission rate must be > 0.0 and < 1.0");

		this.commissionRate = commissionRate;
	}

	// retorna a taxa de comiss�o
	public double getCommissionRate() {
		return commissionRate;
	}

// calcula os lucros 
	public double earnings() {
		return commissionRate * grossSales;
	}

// retorna a representa��o String do objeto CommissionEmployee 
	@Override // indica que esse m�todo substitui um m�todo da superclasse
	public String toString() {
		return String.format("%s: %s %s%n%s: %s%n%s: %.2f%n%s: %.2f", "commission employee", super.getFirstName(), super.getLastName(),
				"social security number", super.getSocialSecurityNumber(), "gross sales", grossSales, "commission rate",
				commissionRate);
	}
} // fim da classe CommissionEmployee
