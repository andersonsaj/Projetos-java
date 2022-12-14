package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import entities.ImportedProduct;
import entities.Product;
import entities.UsedProduct;

public class Program {

	public static void main(String[] args) throws ParseException {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		List<Product> list = new ArrayList<>();
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		System.out.print("Enter the number of products: ");
		int n = sc.nextInt();
		for(int i = 0; i<n; i++) {
			System.out.printf("Product #%d data:\nCommon, used or imported (c/u/i)? ",i+1);
			char c = sc.next().charAt(0);
			System.out.print("Name: ");
			sc.nextLine();
			String name = sc.nextLine();
			System.out.print("Price: ");
			double price = sc.nextDouble();
			
			if(c == 'c') {
				list.add(new Product(name, price));
			}else {
				if(c == 'u') {
					System.out.print("Manufacture date (DD/MM/YYYY): ");
					Date manufactureDate = sdf.parse(sc.next());
					list.add(new UsedProduct(name, price, manufactureDate));
				}else if(c == 'i') {
					System.out.print("Customs fee: ");
					double customsFee = sc.nextDouble();
					list.add(new ImportedProduct(name, price, customsFee));
				}else {
					System.out.println("Op??o invalida!!");
				}
			}
		}
		System.out.println("PRICE TAGS:");
		for(Product prod : list) {
		System.out.println(prod.priceTag());
		}
		
		sc.close();
	}

}
