package application3;

import entities.Client;

public class Program {

	public static void main(String[] args) {

		Client c = new Client("Maria", "maria@gmail.com");
		Client c1 = new Client("Maria", "alex@gmail.com");

		String s1 = "Test";
		String s2 = "Test";
		
		String s3 = new String("Test");
		String s4 = new String("Test");

		System.out.println(c.hashCode());
		System.out.println(c1.hashCode());
		System.out.println(c.equals(c1));
		System.out.println(c == c1);
		System.out.println(s1 == s2);
		System.out.println(s3 == s4);
	}
}
