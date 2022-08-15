package application1;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

import entities.Product;

public class Program {

	public static void main(String[] args) {
		//Predicate
		List<Product> list = new ArrayList<>();
		
		list.add(new Product("Tv", 900.00));
		list.add(new Product("Mouse", 50.00));
		list.add(new Product("Tablet", 350.50));
		list.add(new Product("HD Case", 80.90));
		
		double min = 100.0;
		
		//Predicate<Product> pred = p -> p.getPrice() >= min;
		
		//list.removeIf(p -> p.getPrice() >= 100);
	    //list.removeIf(new ProductPredicate());
		//list.removeIf(Product :: staticProductPreticate);
		//list.removeIf(Product :: noStaticProductPreticate);
		//list.removeIf(pred);
		list.removeIf(p -> p.getPrice() >= min);
		
		
		for (Product p : list) {
			System.out.println(p);
		}

	}

}
