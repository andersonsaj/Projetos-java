package application6_Excer;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;
import java.util.stream.Collectors;

import entities.Product;

public class Program {

	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);

		System.out.println("Enter full firle path: ");
		String path = sc.next();

		try (BufferedReader br = new BufferedReader(new FileReader(path))) {
			List<Product> list = new ArrayList<>();
			String linha = br.readLine();

			while (linha != null) {
				String[] fields = linha.split(",");
				list.add(new Product(fields[0], Double.parseDouble(fields[1])));
				linha = br.readLine();
			}
			double avg = list.stream().map(p -> p.getPrice()).reduce(0.0, (x, y) -> x + y / list.size());

			System.out.println("Average price: " + String.format("%.2f", avg));

			Comparator<String> comp = (p1, p2) -> p1.toUpperCase().compareTo(p2.toUpperCase());

			List<String> names = list.stream().filter(p -> p.getPrice() < avg).map(p -> p.getName())
					.sorted(comp.reversed()).collect(Collectors.toList());

			names.forEach(System.out::println);
			
		} catch (IOException e) {
			System.out.println("Error " + e.getMessage());
		}
		sc.close();
	}

}
