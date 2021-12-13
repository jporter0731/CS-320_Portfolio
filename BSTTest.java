package tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import classes.BST;
import classes.Contact;

class BSTTest {

	@Test
	void testAllInsertOrDeleteBranches() {
		//Create variables for testing
		BST testSearchTree = new BST();
		Contact testContact1 = new Contact("contactID7", "fName", "lName", "pNumber", "This is a long address.");
		Contact testContact2 = new Contact("contactID9", "fName", "lName", "pNumber", "This is a long address.");
		Contact testContact3 = new Contact("contactID3", "fName", "lName", "pNumber", "This is a long address.");
		Contact testContact4 = new Contact("contactID6", "fName", "lName", "pNumber", "This is a long address.");
		Contact testContact5 = new Contact("contactID4", "fName", "lName", "pNumber", "This is a long address.");
		Contact testContact6 = new Contact("contactID1", "fName", "lName", "pNumber", "This is a long address.");
		//Test the insert function
		testSearchTree.insert(testContact1);
		assertTrue(testSearchTree.inOrder().equals("contactID7 "));
		testSearchTree.insert(testContact2);
		assertTrue(testSearchTree.inOrder().equals("contactID7 contactID9 "));
		testSearchTree.insert(testContact3);
		assertTrue(testSearchTree.inOrder().equals("contactID3 contactID7 contactID9 "));
		testSearchTree.insert(testContact4);
		assertTrue(testSearchTree.inOrder().equals("contactID3 contactID6 contactID7 contactID9 "));
		testSearchTree.insert(testContact5);
		assertTrue(testSearchTree.inOrder().equals("contactID3 contactID4 contactID6 contactID7 contactID9 "));
		testSearchTree.insert(testContact6);
		assertTrue(testSearchTree.inOrder().equals("contactID1 contactID3 contactID4 contactID6 contactID7 contactID9 "));
		//Test the delete function
		testSearchTree.deleteKey("contactID3");
		assertTrue(testSearchTree.inOrder().equals("contactID1 contactID4 contactID6 contactID7 contactID9 "));
		testSearchTree.deleteKey("contactID4");
		assertTrue(testSearchTree.inOrder().equals("contactID1 contactID6 contactID7 contactID9 "));
		testSearchTree.deleteKey("contactID9");
		assertTrue(testSearchTree.inOrder().equals("contactID1 contactID6 contactID7 "));
		testSearchTree.deleteKey("contactID1");
		assertTrue(testSearchTree.inOrder().equals("contactID6 contactID7 "));
		testSearchTree.deleteKey("contactID7");
		assertTrue(testSearchTree.inOrder().equals("contactID6 "));
		testSearchTree.deleteKey("contactID6");
		assertTrue(testSearchTree.inOrder().equals(""));
		testSearchTree.deleteKey("contactID6");
		assertTrue(testSearchTree.inOrder().equals(""));
	}
	
	@Test
	void testSearchFunction() {
		//Create variables for testing
		BST testSearchTree = new BST();
		Contact contactToCompare;
		//Test Searching an empty tree
		contactToCompare = testSearchTree.search("NotThere");
		assertTrue(contactToCompare == null);
		//Create variables to add to tree for later testing
		Contact testContact1 = new Contact("contactID7", "fName", "lName", "pNumber", "This is a long address.");
		Contact testContact2 = new Contact("contactID9", "fName", "lName", "pNumber", "This is a long address.");
		Contact testContact3 = new Contact("contactID5", "fName", "lName", "pNumber", "This is a long address.");
		//Add variables for testing
		testSearchTree.insert(testContact1);
		testSearchTree.insert(testContact2);
		testSearchTree.insert(testContact3);
		//Test searching for variables
		contactToCompare = testSearchTree.search("contactID7");
		assertTrue(contactToCompare == testContact1);
		contactToCompare = testSearchTree.search("contactID5");
		assertTrue(contactToCompare == testContact3);
		contactToCompare = testSearchTree.search("contactID9");
		assertTrue(contactToCompare == testContact2);
	}
}
