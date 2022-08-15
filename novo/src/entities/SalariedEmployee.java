package entities;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class SalariedEmployee extends Employee{
	private double weeklySalary;

	// construtor
	public SalariedEmployee(String firstName, String lastName, String socialSecurityNumber, double weeklySalary, Date birthDate) {
		super(firstName, lastName, socialSecurityNumber,birthDate);

		if (weeklySalary < 0.0)
			throw new IllegalArgumentException("Weekly salary must be >= 0.0");

		this.weeklySalary = weeklySalary;
	}

	// configura o salário
	public void setWeeklySalary(double weeklySalary) {
		if (weeklySalary < 0.0)
			throw new IllegalArgumentException("Weekly salary must be >= 0.0");

		this.weeklySalary = weeklySalary;
	}

	// retorna o salário
	public double getWeeklySalary() {
		return weeklySalary;
	}

	// calcula os rendimentos; sobrescreve o método earnings em Employeeÿ
	@Override
	public double earnings() {
		List<SalariedEmployee> list = new ArrayList<>();
		Date data = new Date();
		Calendar cal1 =  Calendar.getInstance();
		cal1.setTime(data);
		int mes = cal1.get(Calendar.MONTH);
		int dia = cal1.get(Calendar.DAY_OF_MONTH);
		for(Employee e : list) {
			Calendar cal2 =  Calendar.getInstance();
			cal2.setTime(e.getBirthDate());
			int m = cal2.get(Calendar.MONTH);
			int d = cal2.get(Calendar.DAY_OF_MONTH);
			if(dia == d || mes == m) {
			return getWeeklySalary() + 100.00;
			}
		}
		return getWeeklySalary();
	}

	// retorna a representação String do objeto SalariedEmployee
	@Override
	public String toString() {
		return String.format("salaried employee: %s%n%s: $%,.2f", super.toString(), "weekly salary", getWeeklySalary());
	}

}
