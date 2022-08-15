package m.entities;

import java.security.InvalidParameterException;

public class UsalInterestService implements InterestService{
	
	private Double interestRate;

	public UsalInterestService(Double interestRate) {
		this.interestRate = interestRate;
	}
	@Override
	public double getInterestRate() {
		return interestRate;
	}
}
