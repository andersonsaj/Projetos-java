import java.util.Locale;
import java.util.Scanner;
public class Main {

	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		System.out.println("Digite uma String");
		String x;
		x = sc.nextLine();
		System.out.println("Voc� digitou: " + x);
		int y;
		y = sc.nextInt();
		System.out.println("Voc� digitou: " + y);
		double z;
		z = sc.nextDouble();
		System.out.println("Voc� digitou: " + z);
		char c;
		c = sc.next().charAt(0);
		System.out.println("Voc� digitou: " + c);
		sc.close();
	}

}
