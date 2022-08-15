package entities;

public final class BusinessAccount extends Account {

	private Double loanLimit;

	public BusinessAccount() {
		super();
	}

	public BusinessAccount(Integer number, String holder, Double balance, Double loanLimit) {
		super(number, holder, balance);
		this.loanLimit = loanLimit;
	}

	public Double getLoanLimit() {
		return loanLimit;
	}

	public void setLoanLimit(Double loanLimit) {
		this.loanLimit = loanLimit;
	}

	public void loan(double amount) {
		if (loanLimit <= amount) {
			balance += amount - 10.0;
		}
	}

	public  void wthdraw(double amount) {
		super.wthdraw(amount);
		balance -= 2.0;
	}

}
