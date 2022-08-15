package entities2;

public class Produto {
	public String name;
	public double price;
	public int quantity;
	
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