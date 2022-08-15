package entities;

public class PieceWorker extends Employee{

	private double wage;
	private int pieceWorker;
	
	public PieceWorker(String firstName, String lastName, String socialSecurityNumber
			, double wage, int pieceWorker) {
		super(firstName, lastName, socialSecurityNumber);
		this.wage =wage;
		this.pieceWorker = pieceWorker;
	}
	
	public double getWage() {
		return wage;
	}
	public void setWage(double wage) {
		this.wage = wage;
	}
	public int getPieceWorker() {
		return pieceWorker;
	}
	public void setPieceWorker(int pieceWorker) {
		this.pieceWorker = pieceWorker;
	}
	@Override
	public double earnings(){
		return wage * pieceWorker;
	}

	@Override
	public String toString() {
		return String.format("hourly employee: %s%n%s: $%,.2f; %s: %d", super.toString(), "wage", getWage(),
				"Piece Worker", pieceWorker);
	}
	
}
