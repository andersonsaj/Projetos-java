package entities;

import interfaces.Payable;

public class Invoice implements Payable{
	private final String partNumber;
	private final String partDescription;
	private int quantity;
	private double pricePerItem;
	public Invoice(String partNumber, String partDescription, int quantity, double pricePerItem) throws IllegalAccessException {
		if(quantity < 0)
			throw new IllegalAccessException("Qunatity must be>=0");
		if(pricePerItem < 0.0)
			throw new IllegalArgumentException("Price per item must be >=0");
		this.partNumber = partNumber;
		this.partDescription = partDescription;
		this.quantity = quantity;
		this.pricePerItem = pricePerItem;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) throws IllegalAccessException {
		if(quantity < 0)
			throw new IllegalAccessException("Qunatity must be>=0");
		this.quantity = quantity;
	}
	public double getPricePerItem() {
		return pricePerItem;
	}
	public void setPricePerItem(double pricePerItem) {
		if(pricePerItem < 0.0)
			throw new IllegalArgumentException("Price per item must be >=0");
		this.pricePerItem = pricePerItem;
	}
	public String getPartNumber() {
		return partNumber;
	}
	public String getPartDescription() {
		return partDescription;
	}
	@Override
	public double getPaymentAmount() {
		return quantity * pricePerItem;
	}
	
	@Override
	public String toString() {
		return "Invoice:\nPart number " + partNumber + "("
				+partDescription+")\n" + "Quantity " + quantity
				+"\nPrice per item " + String.format("$%,.2f",pricePerItem);
	}
}
