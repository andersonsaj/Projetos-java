package entities;

public class Product{

	private String name;
	private Double price;

	public Product(String name, Double price) {
		this.name = name;
		this.price = price;

	}

	public String getName() {
		return name;

	}

	public void setName(String name) {
		this.name = name;

	}

	public Double getPrice() {
		return price;

	}

	public void setPrice(Double price) {
		this.price = price;

	}
	public static boolean staticProductPreticate( Product p) {
		return p.getPrice() >= 100.0;
	}
	public boolean noStaticProductPreticate() {
		return price >= 100.0;
	}
	public static void staticPriceUpdate(Product p) {
		 p.setPrice(p.getPrice() * 1.1);
	}
	public void noStaticPriceUpdate() {
		price *= 1.1;
		//setPrice(price * 1.1);
	}
	public static String staticUpperCaseName(Product p) {
		return p.getName().toUpperCase();
	}
	public  String nostaticUpperCaseName() {
		return name.toUpperCase();
	}
	@Override
	public String toString() {
		return name + ", " + String.format("%.2f", price);

	}
}
