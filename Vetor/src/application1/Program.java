package application1;

import java.util.Locale;
import java.util.Scanner;

import entities.Product;

public class Program {

	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		Product[] vect = new Product[n];
		double sum = 0.0;
		for (int i = 0; i < vect.length; i++) {
			sc.nextLine();
			System.out.print("Digite um nome: ");
			String name = sc.nextLine();
			System.out.print("Digite um price: ");
			double price = sc.nextDouble();
			vect[i] = new Product(name, price);
			sum += vect[i].getPrice();
		}
		double avg = sum / vect.length;
		System.out.printf("Aversge price = %.2f", avg);
		sc.close();
	}

}
