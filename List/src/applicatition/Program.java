package applicatition;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Program {

	public static void main(String[] args) {

		List<String> list = new ArrayList<>();

		list.add("Maria");
		list.add("Alex");
		list.add("Bob");
		list.add("Joao");
		list.add("Bia");
		list.add(2, "Ana");

		for (String x : list) {
			System.out.println(x);
		}

		System.out.println("Tamanho list: " + list.size());// tamanho da list
		list.remove("Joao");
		list.remove(0);
		list.removeIf(x -> x.charAt(0) == 'A');
		
		System.out.println("------------------------");
		System.out.println("Tamanho list: " + list.size());
		for (String x : list) {
			System.out.println(x);
		}
		System.out.println("------------------------");
		System.out.println("Index of Bob: " + list.indexOf("Bob"));
		System.out.println("Index of Nando: " + list.indexOf("Nando"));
		System.out.println("------------------------");
		List<String> result = list.stream().filter(x -> x.charAt(0) == 'B').collect(Collectors.toList());
		for (String x : result) {
			System.out.println(x);
		}
		System.out.println("------------------------");
		String name = list.stream().filter(x -> x.charAt(0) == 'B').findFirst().orElse(null);
		System.out.println(name);
		
	}

}
