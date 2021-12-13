package classes;

public class BST {
	//Node class used in the BST
	private class Node{
		//Instance variables
		private Contact key;
		private Node left, right;
		
		public Node(Contact data) {
			key = data;
			left = right = null;
		}
	}
	
	//Root node
	Node root;
	
	//Private string used for testing
	String inOrderList = "";
	
	//Default constructor for empty tree
	public BST(){
		root = null;
	}
	
	//Delete node from tree
	public void deleteKey(String key) {
		root = deleteRecursive(root, key);
	}
	
	//Recursive delete function
	private Node deleteRecursive(Node root, String key) {
		//Check if tree is empty
		if (root == null) {
			return root;
		}
		
		//get the integer difference between the two values
		int difference = key.compareTo(root.key.getContactID());
		
		//Traverse the tree
		if (difference < 0) { //Traverse Left Subtree
			root.left = deleteRecursive(root.left, key);
		}
		else if (difference > 0){ //Traverse Right Subtree
			root.right = deleteRecursive(root.right, key);
		}
		//Delete the node
		else {
			//only 1 child
			if (root.left == null) {
				return root.right;
			}
			else if (root.right == null) {
				return root.left;
			}
			
			//Node has 2 children
			//Get the in order successor
			root.key = minValue(root.right);
			
			//Remove the in order successor
			root.right = deleteRecursive(root.right, root.key.getContactID());
		}
		return root;
	}
	
	//Find the min value
	private Contact minValue(Node root) {
		//initial min value
		Contact minValue = root.key;
		while (root.left != null) {
			minValue = root.left.key;
			root = root.left;
		}
		//Return the minimum value Contact
		return minValue;
	}
	
	//Add node to a tree
	public void insert(Contact key) {
		root = insertRecursive(root, key);
	}
	
	//Recursive add to a tree
	private Node insertRecursive(Node root, Contact key) {
		//Tree is empty
		if (root == null) {
			root = new Node(key);
			return root;
		}
		//get the integer difference between the two values
		int difference = key.getContactID().compareTo(root.key.getContactID());
		//Traverse the tree
		if (difference < 0) {//Insert into the left subtree
			root.left = insertRecursive(root.left, key);
		}
		else {//Insert into the right subtree
			root.right = insertRecursive(root.right, key);
		}
		return root;
	}
	
	//Search for a value
	public Contact search(String key) {
		Node foundValue = searchRecursive(root, key);
		if (root == null) {
			return null;
		}
		else {
			return foundValue.key;
		}
	}
	
	//Recursive search for a value
	private Node searchRecursive(Node root, String key) {
		//Check the base cases
		if (root == null || root.key.getContactID() == key) {
			return root;
		}
		
		//get the integer difference between the two values
		int difference = key.compareTo(root.key.getContactID());
		
		//If the root value is greater than the key
		if (difference < 0) {
			return searchRecursive(root.left, key);
		}
		//If the root value is less than the key
		return searchRecursive(root.right, key);
	}
	
	//In order traversal used for testing
	public String inOrder() {
		if(!inOrderList.equals("")) {
			inOrderList = "";
		}
		recursiveInOrderTraversal(root);
		return inOrderList;
	}
	
	//Recursive in order traversal used for testing
	private void recursiveInOrderTraversal(Node root) {
		if (root != null) {
			recursiveInOrderTraversal(root.left);
			inOrderList = inOrderList.concat(root.key.getContactID() + " ");
			recursiveInOrderTraversal(root.right);
		}
		
	}
}
