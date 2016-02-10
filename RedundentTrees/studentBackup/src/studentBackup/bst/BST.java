package studentBackup.bst;

import studentBackup.mrutil.MRVisitor;
import studentBackup.mrutil.debugAssistant;

public class BST {
	private Node root;
	
	/**
	 * Constructor for binary search tree
	 * */
	public BST(){
		debugAssistant.ConstructorPrint("BST");
		root = null;
	}
	
	/**
	 * @return the root node of the BST
	 * Method returns the root of the BST
	 * */
	public Node getRoot(){
		return root;
	}
	
	/**
	 * @return a reference to the node inserted by method
	 * @param num - number to insert into Binary Search tree
	 * Method inserts data into BST
	 * */
	public Node insert(int num){
		if(root == null){
			return (root = new Node(num));
		}else{
			return root.insert(num);
		}
	}
	
	/**
	 * @return true if num is in tree, false if num is not in tree
	 * @param num - number to search tree for
	 * Method searches tree for parameterized number
	 * */
	public boolean search(int num){
		if(root == null){
			return false;
		}else{
			return root.search(num);
		}
	}
	
	/**
	 * @return false if there is no duplicated nodes in tree, tree if there is
	 * Method checks if all tree data is unique
	 * */
	public boolean anyDuplicateData(){
		if(root == null){
			return false;
		}else{
			return root.DuplicateChildren();
		}
	}
	
	/**
	 * @return true if tree has at least one element, false if no elements
	 * Method states whether tree is empty or not
	 * */
	public boolean treeEmpty(){
		if(root == null){
			return true;
		}else{
			return false;
		}
	}

	/**
	 * @return the number of elements in the tree
	 * Method returns the size of the tree
	 * */
	public int getTreeSize(){
		return root.getSizeOfTree();
	}
	
	/**
	 * @return the single largest element contained in the BST
	 * Method returns largest element in tree
	 * */
	public int getLargestElement(){
		return root.getLargestInt();
	}
	
	/**
	 * Method prints content of tree in order
	 * */
	public void printInOrder(){
		if(debugAssistant.getDebugVal() == 0){
			System.out.print("\n");
			root.printInOrder();
			System.out.print("\n");
		}
	}
	
	/**
	 * @return the single smallest element contained in the BST
	 * Method returns the smallest element in tree
	 * */
	public int getSmallestElement(){
		return root.getSmallestInt();
	}
	
	/**
	 * @param v - the MRVisitor implementor which is operating on the BST
	 * @param UPDATE_VALUE - an integer value used by implemented MRVisitor objects
	 * Method accepts visiting object and invokes visit upon it
	 * */
	public void accept(MRVisitor v, int UPDATE_VALUE){
		v.visit(this, UPDATE_VALUE);
	}
}
