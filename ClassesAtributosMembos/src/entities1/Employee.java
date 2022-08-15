package entities1;

public class Employee {
	
	public String name;
	public double grossSalary, tax;
	
	public double netSalary() {
		return grossSalary - tax;
	}
	public void increaseSalary(double percentage) {
		this.grossSalary =((grossSalary * percentage /100) + netSalary());	
	}
	public String toString() {
		return name + ", $ ";
	}
}
