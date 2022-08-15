package application;

import java.util.ArrayList;
import java.util.List;

import entities.Circle;
import entities.Cube;
import entities.Shape;
import entities.Sphere;
import entities.Square;
import entities.Tetrahedron;
import entities.Triangle;

public class Program {

	public static void main(String[] args) {
		
	List<Shape> list = new ArrayList<>();
	
	Circle cir = new Circle("Círculo", 6);
	Square squ = new Square("Quadrado", 6, 12);
	Triangle trian = new Triangle("Triângulo", 6, 12);
	
	Cube cube = new Cube("Cubo", 6);
	Sphere sphere = new Sphere("Esfera", 6);
	Tetrahedron tetra = new Tetrahedron("Tetraedro", 6);
	
	
	list.add(cube);
	list.add(sphere);
	list.add(tetra);
	list.add(cir);
	list.add(squ);
	list.add(trian);
	for(Shape s : list) {
		if(s == cir || s == squ || s == trian) {
			System.out.println(s);
		}else {
			System.out.println("--------------------------");
			System.out.println(s);
			System.out.println("--------------------------");
		}
	}
  }
}	