package dmacc.beans;

import javax.persistence.Embeddable;

@Embeddable
public class Employee {
	private String firstname;
	private String lastname;
	
	public Employee() {
		super();
	}
	
	public Employee(String firstName, String lastName) {
		super();
		this.firstname = firstName;
		this.lastname = lastName;
	}

	public String getFirstName() {
		return firstname;
	}

	public void setFirstName(String firstName) {
		this.firstname = firstName;
	}

	public String getLastName() {
		return lastname;
	}

	public void setLastName(String lastName) {
		this.lastname = lastName;
	}

	@Override
	public String toString() {
		return "Employee [firstName=" + firstname + ", lastName=" + lastname + "]";
	}
}
