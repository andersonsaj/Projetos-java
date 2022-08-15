package application;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import entities.Estudante;
import entities.EstudanteOrdem;

public class TestComparator {

	public static void main(String[] args) {
		List<Estudante> estudantes = Arrays.asList(
				new Estudante("Pedro", 19),
				new Estudante("Carlos",23),
				new Estudante("Mariana",21),
				new Estudante("Jo�o",18),
				new Estudante("Thiago",20),
				new Estudante("Larissa",21)
				);
		System.out.println("--ordem de inser��o");
		System.out.println(estudantes);
		
		estudantes.sort((first,second) -> first.getIdade() - second.getIdade());
		System.out.println("--ordem natural dos n�meros - idade---");
		System.out.println(estudantes);
		
		estudantes.sort((first, second) -> second.getIdade() - first.getIdade());
		System.out.println("---ordem reversa dos n�meros - idade ---");
		System.out.println(estudantes);
		
		estudantes.sort(Comparator.comparingInt(Estudante::getIdade));
		System.out.println("---ordem natural dos numeros - idade(method reference)----");
		System.out.println(estudantes);
		
		estudantes.sort(Comparator.comparingInt(Estudante::getIdade).reversed());
		System.out.println("---ordem reversa dos n�meros - idade (method reference)---");
		System.out.println(estudantes);
		
		Collections.sort(estudantes);
		
		System.out.println("---ordem natural dos n�meros - idade (interface Comparable ---");
		System.out.println(estudantes);
		
		Collections.sort(estudantes, new EstudanteOrdem());
		System.out.println("---ordem reversa dos n�meros - idade (interface Comparator)");
		System.out.println(estudantes);
	}

}
