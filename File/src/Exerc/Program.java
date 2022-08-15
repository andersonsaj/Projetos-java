package Exerc;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import entities.Produto;

public class Program {

	public static void main(String[] args) {
		// String path = "C:\\Users\\Anderson\\Documents\\Produto.csv";
		Locale.setDefault(Locale.US);

		Scanner sc = new Scanner(System.in);

		List<Produto> list = new ArrayList<>();

		System.out.println("Enter file path: ");
		String sourceFileStr = sc.nextLine();

		File sourceFile = new File(sourceFileStr);
		String sourceFolderStr = sourceFile.getParent();

		boolean success = new File(sourceFolderStr + "\\out").mkdir();

		String targetFileStr = sourceFolderStr + "\\out\\summary.csv";

		try (BufferedWriter br = new BufferedWriter(new FileWriter(sourceFileStr))) {

				System.out.print("Digite o Nome do Produto: ");
				String name = sc.nextLine();
				System.out.print("Digite o Pre�o do Produto: ");
				double price = sc.nextDouble();
				System.out.print("Digite a quantidade do Produto: ");
				int quantity = sc.nextInt();
				list.add(new Produto(name, price, quantity));
				for(Produto item : list) {
				br.write(item.getName()+ "," + String.format("%.2f", item.getPreco()) +","+ item.getQuantidade());
				br.newLine();
				
				BufferedReader br1 = new BufferedReader(new FileReader(sourceFileStr));
					String itemCsv = br1.readLine();

				while (itemCsv != null) {

					String[] fields = itemCsv.split(",");

					name = fields[0];
					price = Double.parseDouble(fields[1]);
					quantity = Integer.parseInt(fields[2]);

					itemCsv = br1.readLine();

				}
				}
				try (BufferedWriter bw = new BufferedWriter(new FileWriter(targetFileStr))) {
					for (Produto item : list) {
						bw.write(item.getName() + "," + String.format("%.2f", item.valorTotal()));
						bw.newLine();
					}
					System.out.println(targetFileStr + " CREATED!");
				} catch (IOException e) {
					System.out.println("Error writing file: " + e.getMessage());
				}
			}
		catch (IOException e) {
			System.out.println("Error: " + e.getMessage());
		}
		sc.close();
	}
}
