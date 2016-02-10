package studentBackup.bst;
import java.util.Vector;

import studentBackup.mrutil.MRVisitor;
import studentBackup.mrutil.NodeObserver;
import studentBackup.mrutil.NodeSubject;
import studentBackup.mrutil.debugAssistant;

public class Node implements NodeObserver, NodeSubject{
	private Node left;
	private Node right;
	private int data;
	private int numInstances;
	private Vector<NodeObserver> observers;
	/**
	 * @param data to be stored in this node object
	 * Constructor for node object
	 * */
	public Node(int Data){
		debugAssistant.ConstructorPrint("Node(" + Data + ")");
		left = null;
		right = null;
		observers = new Vector<NodeObserver>();
		data = Data;
		numInstances = 1;
	}
	
	/**
	 * @return the value stored in this Node
	 * Method returns value stored in Node
	 * */
	public int getData(){
		return data;
	}
	
	/**
	 * @param newData - the new value to store in this Node
	 * Method sets the value of this Node object
	 * */
	public void setData(int newData){
		data = newData;
		updateAll();
	}
	
	/**
	 * @return the left child of this Node (null if no child)
	 * Method returns reference to left child
	 * */
	public Node getLeft(){
		return left;
	}
	
	/**
	 * @return the right child of this Node (null if there isn't one)
	 * Method returns reference to right child Node
	 * */
	public Node getRight(){
		return right;
	}
	/**
	 * @param number to search for
	 * @return false if number not in tree, true if number is in tree
	 * Searches node tree for a number
	 * */
	public boolean search(int num){
		if(data == num){
			return true;
		}else if(data > num){
			if(left != null){
				return left.search(num);
			}
		}else if(data < num){
			if(right != null){
				return right.search(num);
			}
		}
		return false;
	}
	
	/**
	 * @return a reference to the newest node that has been inserted
	 * @return (null if insertion error or duplicated data)
	 * @param num - number to be inserted into tree
	 * Method inserts a number into the tree
	 * */
	public Node insert(int num){
		Node child = null;
		if(data == num){
			numInstances++;
		}else if(data > num){
			if(left == null){
				child = (left = new Node(num));
			}else{
				left.insert(num);
			}
		}else if(data < num){
			if(right == null){
				child = (right = new Node(num));
			}else{
				right.insert(num);
			}
		}
		if(child != this && child != null){
			updateWithNewChild(num, child);
		}
		return child;
	}
	
	/**
	 * @return false if no duplicate children in tree, true if duplicate children in tree
	 * Method returns whether all children are unique or duplicated information
	 * */
	public boolean DuplicateChildren(){
		if(numInstances > 1){
			return true;
		}else{
			boolean rDupe, lDupe;
			if(right == null){
				rDupe = false;
			}else{
				rDupe = right.DuplicateChildren();
			}
			if(left == null){
				lDupe = false;
			}else{
				lDupe = left.DuplicateChildren();
			}
			return (lDupe || rDupe);
		}
	}
	
	/**
	 * @return the smallest number in the tree
	 * get smallest element in tree
	 * */
	public int getSmallestInt(){
		if(left == null){
			return data;
		}else{
			return left.getSmallestInt();
		}
	}
	
	/**
	 * @return the largest number in the tree
	 * get the largest element in the tree
	 * */
	public int getLargestInt(){
		if(right == null){
			return data;
		}else{
			return right.getLargestInt();
		}
	}
	
	/**
	 * @return the number of elements in the tree
	 * Method returns the number of elements in this node's tree
	 * */
	public int getSizeOfTree(){
		int size = 1;
		if(left != null){
			size = size + left.getSizeOfTree();
		}
		if(right != null){
			size = size + right.getSizeOfTree();
		}
		return size;
	}

	/**
	 * Method prints content of node subtree in order
	 * */
	public void printInOrder(){
		if(debugAssistant.getDebugVal() == 0){
			if(left != null){
				left.printInOrder();
			}
			System.out.print("(" + data + ") ");
			if(right != null){
				right.printInOrder();
			}
		}
	}
	
	/**
	 * @param n - the node to register
	 * implemented subject method: registerNode
	 * */
	public void registerNode(NodeObserver n) {
		observers.add(n);
	}

	/**
	 * @param n - the NodeObserver no longer observing
	 * implemented subject method: removeNode
	 * */
	public void removeNode(NodeObserver n) {
		for(int i = 0; i < observers.size(); i++){
			if(observers.get(i).equals(n)){
				observers.remove(i);
				return;
			}
		}
	}

	/**
	 * @param val - the value to add into each listening node's tree
	 * @param insertedNode - the new subject to which new observers should listen
	 * implemented subject method: updateNodes
	 * */
	public void updateWithNewChild(int val, NodeSubject insertedNode) {
		if(observers.size() > 0){
			debugAssistant.updateAllPrint("(Subject Node value: " + data + ")\n");
			for(NodeObserver o : observers){
				o.update(val, insertedNode);
			}
		}
	}

	/**
	 * @param value - the value to construct a new child node with
	 * implemented observer method: update 
	 * */
	public void update(int value, NodeSubject insertedNode) {
		debugAssistant.updatePrint("(Node Value: " + this.data + ", inserted node value: " + ((Node)insertedNode).data + ")\n");
		Node newChild = insert(value);
		insertedNode.registerNode(newChild);
	}

	/**
	 * @param value - the new value of this node
	 * Method updates the value of this node
	 * */
	public void update(int value) {
		data = value;
	}

	/**
	 * Method updates observers with new integer value
	 * */
	public void updateAll() {
		if(observers.size() > 0){
			debugAssistant.updateAllPrint("(Subject Node value: " + data + ")\n");
			for(NodeObserver o : observers){
				o.update(data);
			}
		}		
	}
	
	/**
	 * @param v - the MRVisitor implementor which is operating on the node
	 * @param UPDATE_VALUE - an integer value used by implemented MRVisitor objects
	 * Method accepts visiting object and invokes visit upon it
	 * */
	public void accept(MRVisitor v, int UPDATE_VALUE){
		v.visit(this, UPDATE_VALUE);
	}
}
