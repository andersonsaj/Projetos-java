package application;

import java.util.Locale;
import java.util.Scanner;

import entities.Triangle;

public class Program {

	public static void main(String[] args) {

		Locale.setDefault(Locale.US);
		Scanner s = new Scanner(System.in);
		Triangle x,y;
		x = new Triangle();
		y = new Triangle();
		System.out.println("Digite as três medidas do triângolo X: ");
		x.a = s.nextDouble();
		x.b = s.nextDouble();
		x.c = s.nextDouble();
		System.out.println("Digite as três medidas do triângolo Y: ");
		y.a = s.nextDouble();
		y.b = s.nextDouble();
		y.c = s.nextDouble();
		
		double areaX = x.area();
		double areaY = y.area();
		
		System.out.printf("Área do triângolo X: %.3f%n", areaX);
		System.out.printf("Área do triângolo Y: %.3f%n", areaY);
		
		if(areaX > areaY) {
			System.out.println("Larger area: X");
		}else {
			System.out.println("Larger area: Y");
		}
		s.close();
	}

}
