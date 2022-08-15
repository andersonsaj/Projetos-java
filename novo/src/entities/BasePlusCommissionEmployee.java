package entities;

public class BasePlusCommissionEmployee extends Employee {
	private double grossSales; // vendas brutas semanais
	private double commissionRate; // porcentagem da comissão
	private double baseSalary; // salário-base por semanaÿ

	// construtor de seis argumentos
	public BasePlusCommissionEmployee(String firstName, String lastName,
	 String socialSecurityNumber, double grossSales,
	double commissionRate, double baseSalary)
	 {
		super(firstName, lastName, socialSecurityNumber);
	 
	 // a chamada implícita para o construtor padrão de Object ocorre aqui
	
	// se grossSales é inválido, lança uma exceção
	 if (grossSales < 0.0) 
		 throw new IllegalArgumentException(
				 "Gross sales must be >= 0.0");
				 
				  // se commissionRate é inválido, lança uma exceção
				  if (commissionRate <= 0.0 || commissionRate >= 1.0)
				  throw new IllegalArgumentException(
				"Commission rate must be > 0.0 and < 1.0");
				 
				 // se baseSalary é inválido, lança uma exceção ÿ
				  if (baseSalary < 0.0) 
				   throw new IllegalArgumentException( 
				   "Base salary must be >= 0.0"); 
				 
				 
				  this.grossSales = grossSales;
				  this.commissionRate = commissionRate;
				 this.baseSalary = baseSalary;
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

	// configura a taxa de comissão
	public void setCommissionRate(double commissionRate) {
		if (commissionRate <= 0.0 || commissionRate >= 1.0)
			throw new IllegalArgumentException("Commission rate must be > 0.0 and < 1.0");

		this.commissionRate = commissionRate;
	}

// retorna a taxa de comissão
	public double getCommissionRate() {
		return commissionRate;
	}

	// configura o salário-base
	public void setBaseSalary(double baseSalary) {
		if (baseSalary < 0.0)
			throw new IllegalArgumentException("Base salary must be >= 0.0");

		this.baseSalary = baseSalary;
	}

	// retorna o salário-base
	public double getBaseSalary() {
		return baseSalary;
	}

	// calcula os lucros
	public double earnings() {
		return baseSalary + (commissionRate * grossSales);
	}

	// retorna a representação de String de BasePlusCommissionEmployee
	@Override
	 public String toString()
	{
	return String.format(
 "%s: %s %s%n%s: %s%n%s: %.2f%n%s: %.2f%n%s: %.2f",
 "base-salaried commission employee", super.getFirstName(), super.getLastName(),
	 "social security number", super.getSocialSecurityNumber(),
	 "gross sales", grossSales, "commission rate", commissionRate,
	"base salary", baseSalary);
	 }
} // fim da classe BasePlusCommissionEmployee

