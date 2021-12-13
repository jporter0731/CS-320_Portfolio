package tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import classes.Contact;

class ContactTest {

	@Test
	void contactValidInputTest() {
		Contact testContact = new Contact("contactID", "fName", "lName", "pNumber", "This is a long address.");
		assertTrue(testContact.getContactID().equals("contactID"));
		assertTrue(testContact.getFirstName().equals("fName"));
		assertTrue(testContact.getLastName().equals("lName"));
		assertTrue(testContact.getPhoneNumber().equals("pNumber"));
		assertTrue(testContact.getAddress().equals("This is a long address."));
	}
	
	@Test
	void testContactIDTooLong() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Contact("contactID12", "fName", "lName", "pNumber", "This is a long address.");
		});
	}
	
	@Test
	void testContactIDNull() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Contact(null, "fName", "lName", "pNumber", "This is a long address.");
		});
	}
	
	@Test
	void testFirstNameTooLong() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Contact("contactID", "fName123456", "lName", "pNumber", "This is a long address.");
		});
	}
	
	@Test
	void testFirstNameNull() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Contact("contactID", null, "lName", "pNumber", "This is a long address.");
		});
	}
	
	@Test
	void testFirstNameChange() {
		Contact testContact = new Contact("contactID", "fName", "lName", "pNumber", "This is a long address.");
		testContact.setFirstName("newname");
		assertTrue(testContact.getFirstName().equals("newname"));
	}
	
	@Test
	void testLastNameTooLong() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Contact("contactID", "fName", "lName123456", "pNumber", "This is a long address.");
		});
	}
	
	@Test
	void testLastNameNull() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Contact("contactID", "fName", null, "pNumber", "This is a long address.");
		});
	}
	
	@Test
	void testLastNameChange() {
		Contact testContact = new Contact("contactID", "fName", "lName", "pNumber", "This is a long address.");
		testContact.setLastName("newname");
		assertTrue(testContact.getLastName().equals("newname"));
	}
	
	@Test
	void testPhoneNumberTooLong() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Contact("contactID", "fName", "lName", "pNumber1234", "This is a long address.");
		});
	}
	
	@Test
	void testPhoneNumberNull() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Contact("contactID", "fName", "lName", null, "This is a long address.");
		});
	}
	
	@Test
	void testPhoneNumberChange() {
		Contact testContact = new Contact("contactID", "fName", "lName", "pNumber", "This is a long address.");
		testContact.setPhoneNumber("newnumber");
		assertTrue(testContact.getPhoneNumber().equals("newnumber"));
	}
	
	@Test
	void testAddressTooLong() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Contact("contactID", "fName", "lName", "pNumber", "This is a long address.12345678");
		});
	}
	
	@Test
	void testAddressNull() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Contact("contactID", "fName", "lName", "pNumber", null);
		});
	}
	
	@Test
	void testAddressChange() {
		Contact testContact = new Contact("contactID", "fName", "lName", "pNumber", "This is a long address.");
		testContact.setAddress("This is a new long address.");
		assertTrue(testContact.getAddress().equals("This is a new long address."));
	}
}
