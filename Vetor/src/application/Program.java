package application;

import java.util.Locale;
import java.util.Scanner;

public class Program {

	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		double[] vect = new double[n];
		
		double sum = 0.0;
		for(int i = 0; i < n; i++) {
			System.out.printf("Digite altura %d: ", i+1);
			vect[i] = sc.nextDouble();
			sum += vect[i];
		}
		double media = sum / n;
		System.out.printf("Media = %.2f", media );
		sc.close();
	}
}
