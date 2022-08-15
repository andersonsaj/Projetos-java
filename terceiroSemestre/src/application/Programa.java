package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import entities.Pessoa;

public class Programa {

	public static void main(String[] args) throws ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		Scanner sc = new Scanner(System.in);
		
		Pessoa p1 = new Pessoa("Maria", "1515666164", sdf.parse("23/07/2000 01:03:59"),"Rua- A" , "F","564615645", "maria@gmail.com", "0759999999",
				"Casada", "Gerente");
		
		System.out.println(p1);
		int ano, mes, dia;
		String data;
		//data.substring(0,1); 0 1 2 3 4 5 6 7 8 9
						  //   2 5 / 0 1 / 2 0 0 0
		
		data = sc.nextLine();
		//while(data.length() )
		dia = Integer.parseInt(data.substring(0,2));
		
		System.out.println(dia);
		sc.close();
	}

}
