package applicatition;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ExemploList {

	public static void main(String[] args) {
		List<String> names = new ArrayList<>();
		
		names.add("Carlos");
		names.add("Pedro");
		names.add("Juliana");
		names.add("Anderson");
		names.add("Maria");
		names.add("João");
		
		System.out.println(names);
		names.set(2, "Larissa");
		Collections.sort(names); //Ordena
		System.out.println(names);

	}

}
