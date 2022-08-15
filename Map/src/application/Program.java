package application;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Program {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Map<String, Integer> votos = new LinkedHashMap<>(); 
		
		System.out.print("Enter file full path: ");
		String path = sc.nextLine();

		try (BufferedReader br = new BufferedReader(new FileReader(path))) {
			String line = br.readLine();

			while (line != null) {
				String[] f = line.split(",");
				String name = f[0];
				int n = Integer.parseInt(f[0]);

				if (votos.containsKey(name)) {
					int votosAteAgora = votos.get(name);
					votos.put(name, n + votosAteAgora);
				}
				else {
					votos.put(name, n);
				}

				line = br.readLine();
			}
			for (String key : votos.keySet()) {
				System.out.println(key + ": " + votos.get(key));
			}
		} catch (IOException e) {
			System.out.println("Error: " + e.getMessage());
		}

		sc.close();

	}

}
