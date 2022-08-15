package entities3;

public class Produto {
	private String name;//private serve para o encapsulamento
	private double price;
	private int quantity;
	
	public Produto() {	
	}
	public Produto(String name,double price, int quantity ) {//construtor
		this.name = name;
		this.price = price;
		this.quantity = quantity;
	}
	public Produto(String name,double price ) {//construtor
		this.name = name;
		this.price = price;
		//quantity = 0;
	}
	public String getName() {//get acesso
		return name;
	}
	public void setName(String name) {// set alterar
		this.name = name;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public int getQuantity() {
		return quantity;
	}
	public double totalValueInStock() {
		return price * quantity;
	}
	public void addProducts(int quantity) {
		this.quantity += quantity; // this referencia o objeto
	}
	public void removeProducts( int quantity) {
		this.quantity -= quantity;
	}
	public String toString() {
		return name + ", $ " + String.format("%.2f", price) +
				", " + quantity + " units, Total: $ "
				+ String.format("%.2f", totalValueInStock());
	}
}
