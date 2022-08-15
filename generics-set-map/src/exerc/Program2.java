package exerc;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;


public class Program2 {

	public static void main(String[] args) throws ParseException {

		Scanner sc = new Scanner(System.in);
		
		
		System.out.print("Enter file full path: ");
		String path = sc.nextLine();
		
		try(BufferedReader br = new BufferedReader(new FileReader(path))){
			Map<String, Integer> votos = new LinkedHashMap<>(); 
			String linha = br.readLine();
			
			while (linha != null) {
				String[] fields = linha.split(",");
				String name = fields[0];
				int n = Integer.parseInt(fields[1]);
				if (votos.containsKey(name)) {
					int votosAteAgora = votos.get(name);
					votos.put(name, n + votosAteAgora);
				}
				else {
					votos.put(name, n);
				}
	
				linha = br.readLine();
			}
			for (String key : votos.keySet()) {
				System.out.println(key + ": " + votos.get(key));
			}
		}
		catch(IOException e) {
			System.out.println("Error: " + e.getMessage());
		}
		sc.close();
	}
}