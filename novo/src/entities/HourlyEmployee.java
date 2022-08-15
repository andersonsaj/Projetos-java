package entities;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class HourlyEmployee extends Employee{
	private Double hours;
	private Double wage;// representa os salários por hora
	
	private List<Employee> lista = new ArrayList<>();
	
	public HourlyEmployee(double hours, double wage) {
		this.hours = hours;
		this.wage = wage;	
	}
	public Double getHours() {
		return hours;
	}
	public void setHours(Double hours) {
		if ((hours < 0.0) || (hours > 168.0)) 
			 throw new IllegalArgumentException(
			 "As horas trabalhadas devem ser >= 0.0 e <= 168.0");
		this.hours = hours;
	}
	public Double getWage() {
		return wage;
	}
	public void setWage(Double wage) {
		if(wage > 0) {
			this.wage = wage;
		}else {
			System.out.println("Wage não pode ser negativo");
		}
	}
	public List<Employee> getLista() {
		return lista;
	}
	public void setLista(List<Employee> lista) {
		this.lista = lista;
	}
	
	public double earnings() {
		List<HourlyEmployee> list = new ArrayList<>();
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
			if(dia == d || mes == m ||hours > 40) {
			return 40*wage +  (hours- 40) * 1.5 *wage + 100.00;
			}
			
		}
		return wage * hours + 100;
	}
	@Override
	public String toString() {
		return "HourlyEmployee:" + super.getFirstName()+ super.getLastName() +
				"social security number"+ super.getSocialSecurityNumber()+ "\nhours=" + hours + ", \nwage=" 
				+ wage +"\nWageTotal=" + String.format("%.2f",this.earnings());
		
	
	}
	

}
