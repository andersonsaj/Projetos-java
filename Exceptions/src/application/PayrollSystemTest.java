package application;

import entities.BasePlusCommissionEmployee;
import entities.CommissionEmployee;
import entities.Employee;
import entities.HourlyEmployee;
import entities.PieceWorker;
import entities.SalariedEmployee;

public class PayrollSystemTest {

	public static void main(String[] args) {
		       
		SalariedEmployee salariedEmployee =    
				new SalariedEmployee("John", "Smith", "111-11-1111", 800.00);
		HourlyEmployee hourlyEmployee =
				new HourlyEmployee("Karen", "Price", "222-22-2222", 16.75, 40);
		CommissionEmployee commissionEmployee =
				new CommissionEmployee("Sue", "Jones", "333-33-3333", 10000, .06);  
		BasePlusCommissionEmployee basePlusCommissionEmployee =
				new BasePlusCommissionEmployee("Bob", "Lewis", "444-44-4444", 5000, .04, 300); 
		PieceWorker pieceWorker = new PieceWorker("Ana", "Silva", "555-55-5555", 18.2, 10);
		
		System.out.println("Employees processed individually:"); 
		System.out.printf("%n%s%n%s: $%,.2f%n%n", 
				salariedEmployee, "earned", salariedEmployee.getPaymentAmount()); 
		System.out.printf("%s%n%s: $%,.2f%n%n", hourlyEmployee, "earned", hourlyEmployee.getPaymentAmount());
		 System.out.printf("%s%n%s: $%,.2f%n%n", 
				 commissionEmployee, "earned", commissionEmployee.getPaymentAmount()); 
		 System.out.printf("%s%n%s: $%,.2f%n%n",
				 basePlusCommissionEmployee, "earned", basePlusCommissionEmployee.getPaymentAmount()); 
		 System.out.println("Salário:" + pieceWorker.getPaymentAmount());
		 
		 Employee[] employees = new Employee[5];
		 // inicializa o array com Employees 
		 employees[0] = salariedEmployee; 
		 employees[1] = hourlyEmployee; 
		 employees[2] = commissionEmployee;  
		 employees[3] = basePlusCommissionEmployee; 
		 employees[4] = pieceWorker;
		 System.out.printf("Employees processed polymorphically:%n%n"); 
		 // processa genericamente cada elemento no employees     
		 for (Employee currentEmployee : employees){ 
			 System.out.println( currentEmployee ); // invoca toString 
			 // determina se elemento é um BasePlusCommissionEmployee 
			 if (currentEmployee instanceof BasePlusCommissionEmployee)  
			 {            // downcast da referência de Employee para  
				 // referência a BasePlusCommissionEmployee 
				 BasePlusCommissionEmployee employee = 
						 (BasePlusCommissionEmployee) currentEmployee ; 
				 employee.setBaseSalary(1.10 * employee.getBaseSalary()); 
				 System.out.printf( "new base salary with 10%% increase is: $%,.2f%n",employee.getBaseSalary()); 
				 } // fim do if 
			 System.out.printf( "earned $%,.2f%n%n", currentEmployee.getPaymentAmount() ); 
			 } // for final
		 // obtém o nome do tipo de cada objeto no array employees 
		 for (int j = 0; j < employees.length; j++)              
			    System.out.printf("Employee %d is a %s%n", j,
			    		employees[j].getClass().getName());             
		  
			 
		 }
}
