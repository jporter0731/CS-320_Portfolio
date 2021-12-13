package classes;

public class Contact {
	//Instance variables
	private String contactID;
	private String firstName;
	private String lastName;
	private String phoneNumber;
	private String address;
	
	//constructor
	public Contact(String contactID, String firstName, String lastName, String phoneNumber, String address) {
		//Make sure the contact ID is valid length and not null
		if (contactID == null || contactID.length() > 10) {
			throw new IllegalArgumentException("Invalid ID");
		}
		
		//Make sure the first name is valid length and not null
		if (firstName == null || firstName.length() > 10) {
			throw new IllegalArgumentException("Invalid First Name");
		}
		
		//Make sure the last name is valid length and not null
		if (lastName == null || lastName.length() > 10) {
			throw new IllegalArgumentException("Invalid Last Name");
		}
		
		//Make sure the phone number is valid length and not null
		if (phoneNumber == null || phoneNumber.length() > 10) {
			throw new IllegalArgumentException("Invalid Phone Number");
		}
		
		//Make sure the address is valid length and not null
		if (address == null || address.length() > 30) {
			throw new IllegalArgumentException("Invalid Address");
		}
		
		//Assign values to the instance variables
		this.contactID = contactID;
		this.firstName = firstName;
		this.lastName = lastName;
		this.phoneNumber = phoneNumber;
		this.address = address;
	}
	
	//Contact ID accessor
	public String getContactID() {
		return contactID;
	}
	
	//First Name accessor
	public String getFirstName() {
		return firstName;
	}
	
	//First Name Mutator
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	//Last Name accessor
	public String getLastName() {
		return lastName;
	}
	
	//Last Name Mutator
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	//Phone number accessor
	public String getPhoneNumber() {
		return phoneNumber;
	}
	
	//Phone Number Mutator
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	
	//Address accessor
	public String getAddress() {
		return address;
	}
	
	//Address mutator
	public void setAddress(String address) {
		this.address = address;
	}
}
