package tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import classes.Contact;
import classes.ContactService;

class ContactServiceTest {

	@Test
	void testIfContactIsAddedThenRemoved() {
		Contact testContact = new Contact("contactID", "fName", "lName", "pNumber", "This is a long address.");
		ContactService testContactService = new ContactService();
		testContactService.addContact(testContact);
		assertTrue(testContactService.contactSearch(testContact.getContactID()));
		testContactService.deleteContact("contactID");
		assertTrue(!testContactService.contactSearch(testContact.getContactID()));
	}
	
	@Test
	void testIfContactIDAlreadyExists() {
		Contact testContact = new Contact("contactID", "fName", "lName", "pNumber", "This is a long address.");
		ContactService testContactService = new ContactService();
		testContactService.addContact(testContact);
		assertTrue(testContactService.contactSearch(testContact.getContactID()));
		testContactService.addContact(testContact);
		assertTrue(testContactService.contactSearch(testContact.getContactID()));
		testContactService.deleteContact("contactID");
		assertTrue(!testContactService.contactSearch(testContact.getContactID()));
	}
	
	@Test
	void testUpdateContact() {
		Contact testContact = new Contact("contactID", "fName", "lName", "pNumber", "This is a long address.");
		ContactService testContactService = new ContactService();
		testContactService.addContact(testContact);
		testContactService.updateContactInformation("contactID", "fName2", "lName3", "pNumber4", "This is a long address5.");
		assertTrue(testContact.getContactID().equals("contactID"));
		assertTrue(testContact.getFirstName().equals("fName2"));
		assertTrue(testContact.getLastName().equals("lName3"));
		assertTrue(testContact.getPhoneNumber().equals("pNumber4"));
		assertTrue(testContact.getAddress().equals("This is a long address5."));
	}
	
	@Test
	void testUpdateContactNotFound() {
		ContactService testContactService = new ContactService();
		testContactService.updateContactInformation("contactID", "fName", "lName", "pNumber", "This is a long address.");
	}
}
