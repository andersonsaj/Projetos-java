package application;

import entities.CommissionEmployee;

public class CommissionEmployeeTest {

	public static void main(String[] args) {
		// instancia o objeto CommissionEmployee
		
		CommissionEmployee employee = new CommissionEmployee(
		 "Sue", "Jones", "222-22-2222", 10000, .06); 
		
		 // obtém os dados de empregado comissionado
		 System.out.println(
		"Employee information obtained by get methods:");
		 System.out.printf("%n%s %s%n", "First name is",
		 employee.getFirstName());
		 System.out.printf("%s %s%n", "Last name is", 
		 		 employee.getLastName());		

	}

}
