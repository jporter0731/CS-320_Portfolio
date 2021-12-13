package classes;

public class ContactService {
	//Create the search tree used to organize the list of contacts
	private BST contactSearchTree = new BST();
	
	//Add the contact with a unique ID
	public void addContact(Contact addedContact) {
		if (contactSearch(addedContact.getContactID())) {
			System.out.println("Contact ID Already Exists");
		}
		else {
			contactSearchTree.insert(addedContact);
		}
	}
	
	//Delete a contact given the string ID
	public void deleteContact(String contactID) {
		contactSearchTree.deleteKey(contactID);
	}
	
	//Update contact information
	public void updateContactInformation(String contactID, String updatedFirstName,
								String updatedLastName, String updatedNumber, String updatedAddress) {
		//Search for contact ID
		Contact contactToUpdate = contactSearchTree.search(contactID);
		//If contact is found
		if (contactToUpdate != null) {
			contactToUpdate.setFirstName(updatedFirstName);
			contactToUpdate.setLastName(updatedLastName);
			contactToUpdate.setPhoneNumber(updatedNumber);
			contactToUpdate.setAddress(updatedAddress);
		}
		//If no contact is found
		else {
			System.out.println("Contact was not found or updated.");
		}
		
	}
	
	//Search for contact information (Used for testing)
	public Boolean contactSearch(String contactID) {
		Boolean foundContact = false;
		Contact searchedContact = contactSearchTree.search(contactID);
		if (searchedContact != null) {
			foundContact = true;
		}
		return foundContact;
	}
}
