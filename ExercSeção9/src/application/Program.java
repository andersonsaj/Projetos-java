package application;

import java.util.Locale;
import java.util.Scanner;

import entities.Account;

public class Program {

	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		Scanner s = new Scanner(System.in);
		Account account;
		
		System.out.print("Enter account number: ");
		int number = s.nextInt();
		System.out.print("Enter account holder: ");
		s.nextLine();
		String holder = s.nextLine();
		System.out.print("Is there na initial deposit (y/n)? ");
		char c = s.next().charAt(0);
		if (c == 'y') {
			double initialDeposit = s.nextDouble();
			System.out.print("Enter initial deposit value: ");
			account = new Account(number, holder, initialDeposit);
			System.out.printf("%n");
		} else {
			account = new Account(number, holder);
			System.out.printf("%n%n");
		}
		System.out.printf("Account data:%n" + account + "%n%n");
		System.out.print("Enter a deposit value: ");
		account.deposit(s.nextDouble());
		System.out.printf("Updated account data:%n" + account + "%n%n");
		System.out.printf("Enter a withdraw value: ");
		account.withdraw(s.nextDouble());
		System.out.printf("Updated account data:%n" + account + "%n%n");
		
		s.close();
	}

}
