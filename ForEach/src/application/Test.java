package application;

import java.util.Arrays;
import java.util.List;

public class Test {
	public static void main(String[] args) {
		List<Pessoa> pessoas = Arrays.asList(
				new Pessoa("Ana 1"),
				new Pessoa("Ana 2"),
				new Pessoa("Ana 3"),
				new Pessoa("Ana 4")
				);
		for(Pessoa p : pessoas) {
			System.out.println(p);
		}
		System.out.println("------------------");
		pessoas.forEach(p -> System.out.println(p.getNome()));
	}

}
