package exerc;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

import entities.Curso;

public class Program1 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		Set<Curso> set = new HashSet<>();

		try {
			System.out.print("How many students for course A? ");
			int n = sc.nextInt();
			for (int i = 0; i < n; i++) {
				int cod = sc.nextInt();
				String name = "A";
				set.add(new Curso(cod,name));
			}
			System.out.print("How many students for course B? ");
			n = sc.nextInt();
			for (int i = 0; i < n; i++) {
				int cod = sc.nextInt();
				String name = "B";
				set.add(new Curso(cod,name));
			}
			System.out.print("How many students for course C? ");
			n = sc.nextInt();
			for (int i = 0; i < n; i++) {
				int cod = sc.nextInt();
				String name = "C";
				set.add(new Curso(cod,name));
			}
			System.out.println("Total students: " + set.size());
		} catch (InstantiationError e) {
			System.out.println("Error: " + e.getMessage());
		}

	}

}
