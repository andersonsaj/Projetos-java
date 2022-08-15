package entities;

import java.text.SimpleDateFormat;
import java.util.Date;

public abstract class Employee {
	SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");		
	private  String firstName;
	private  String lastName;
	private  String socialSecurityNumber;
	private Date birthDate;
	
	public Employee() {
	}

	public Employee(String firstName, String lastName, String socialSecurityNumber,Date birthDate) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.socialSecurityNumber = socialSecurityNumber;
		this.setBirthDate(birthDate);
	}

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public String getSocialSecurityNumber() {
		return socialSecurityNumber;
	}
	public Date getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}
	public abstract double earnings(); 
	@Override
	public String toString() {
		return "Employee [firstName=" + firstName + ", lastName=" + lastName + ", socialSecurityNumber="
				+ socialSecurityNumber + "birthDate="+ sdf.format(birthDate)+"]";
	}


	
}
