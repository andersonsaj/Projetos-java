package entities;

public class BasePlusCommissionEmployee extends CommissionEmployee {
	private double baseSalary; // sal�rio de base por semana
	// construtor

	public BasePlusCommissionEmployee(String firstName, String lastName, String socialSecurityNumber, double grossSales,
			double commissionRate, double baseSalary) {
		super(firstName, lastName, socialSecurityNumber, grossSales, commissionRate);
		if (baseSalary < 0.0) // valida baseSalary
			throw new IllegalArgumentException("Base salary must be >= 0.0");
		this.baseSalary = baseSalary * 1.1;
	}

	// configura o sal�rio-base
	public void setBaseSalary(double baseSalary) {
		if (baseSalary < 0.0) // valida baseSalary
			throw new IllegalArgumentException("Base salary must be >= 0.0");
		this.baseSalary = baseSalary * 1.1;

	}

	public double getBaseSalary() {
		return baseSalary;
	} // calcula os vencimentos; sobrescreve o m�todo earnings em CommissionEmployee

	@Override
	public double getPaymentAmount(){
		return getBaseSalary() + super.getPaymentAmount();
	}

// retorna a representa��o String do objeto BasePlusCommissionEmployee � 
	@Override
	public String toString() {
		return String.format("%s %s; %s: $%,.2f", "base-salaried", super.toString(), "base salary", getBaseSalary());
	}
}
