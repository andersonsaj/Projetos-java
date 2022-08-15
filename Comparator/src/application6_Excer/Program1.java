package application6_Excer;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;
import java.util.stream.Collectors;

import entities.Funcionarios;

public class Program1 {

	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		Scanner sc= new Scanner(System.in);
		
		System.out.print("Enter full file path: ");
		String path = sc.next();
		
		try(BufferedReader br = new BufferedReader(new FileReader(path))){
			List<Funcionarios> list = new ArrayList<>();
			String linha = br.readLine();
			
			while(linha != null) {
				String[] f = linha.split(",");
				list.add(new Funcionarios(f[0], f[1], Double.parseDouble(f[2])));
				linha = br.readLine();
			}
			System.out.print("Enter salary: ");
			double salario = sc.nextDouble();
			System.out.printf("Email of people whose salary is more than %.2f:\n",salario );
			
			
			List<String> email = list.stream().filter(f -> f.getSalario() > salario)
					.map(p -> p.getEmail()).sorted().collect(Collectors.toList());
			email.forEach(System.out::println);
			
			double sum = list.stream()
					.filter(x -> x.getNome().charAt(0) == 'M')
					.map(x -> x.getSalario()).reduce(0.0,(x,y) -> x+y);
			
		//	double sum = new Funcionarios().somaSalario(list, f -> f.getNome().charAt(0) == 'M');
			
			System.out.print("Sum of salary of people whose name starts with 'M': "
					+ String.format("%.2f", sum));
		}
		catch(IOException e) {
			System.out.println("Error " + e.getMessage());
		}
		sc.close();
	}

}
