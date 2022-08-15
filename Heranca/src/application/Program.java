package application;

import entities.Account;
import entities.BusinessAccount;
import entities.SavingsAccount;

public class Program {

	public static void main(String[] args) {
		//SOBREPOSIÇÃO
		Account ac = new Account(1001, "Nando", 1000.0);
		ac.wthdraw(200.0);
		System.out.println(ac.getBalance());
		Account ac1 = new SavingsAccount(1000, "Maria", 1000.0, 0.01);
		ac1.wthdraw(200.0);
		System.out.println(ac1.getBalance());
		//SUPER
		Account ac2 = new BusinessAccount(999, "Eva", 1000.0, 500.0);
		ac2.wthdraw(200.0);
		System.out.println(ac2.getBalance());
		//
		BusinessAccount bacc = new BusinessAccount(1002, 
				"Anderson", 0.0, 1000.0);
		// UPCASTING
		Account acc1 = bacc;
		Account acc2 = new BusinessAccount(1003, 
				"Bob", 0.0, 200.0);
		Account acc3 = new SavingsAccount(1004, "Anna", 0.0, 
				0.01);
		
		//DOWSCASTING
		
		BusinessAccount acc4 = (BusinessAccount)acc2;
		acc4.loan(100.0);
		
		//BusinessAccount acc5 = (BusinessAccount)acc3;
		if(acc3 instanceof BusinessAccount) {
			BusinessAccount acc5 = (BusinessAccount)acc3;
			acc5.loan(200.0);
			System.out.println("Loan!");
		}
		if(acc3 instanceof SavingsAccount) {
			SavingsAccount acc5 = (SavingsAccount)acc3;
			System.out.println("Update!");
		}
		
	}

}
