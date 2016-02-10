package studentBackup.mrutil;

import studentBackup.bst.BST;
import studentBackup.bst.Node;

public class IncrementVisitor implements MRVisitor{

	/**
	 * Constructor
	 * */
	public IncrementVisitor(){
		debugAssistant.ConstructorPrint("IncrementVisitor");
	}

	/**
	 * @param n - the root node to visit
	 * @param UPDATE_VALUE - the value to add to all nodes in subtree
	 * @return UPDATE_VALUE (has no meaningful return value)
	 * Implemented visit method to increment contents of all nodes by UPDATE_VALUE
	 * */	
	public int visit(Node n, int UPDATE_VALUE){
		if(n != null){
			if(n.getLeft() != null){
				visit(n.getLeft(), UPDATE_VALUE);
			}
			if(n.getRight() != null){
				visit(n.getRight(), UPDATE_VALUE);
			}
			n.setData(n.getData() + UPDATE_VALUE);
		}
		return UPDATE_VALUE;
	}
	
	/**
	 * @param n - the BST to visit
	 * @param UPDATE_VALUE - the value to add to all nodes
	 * @return UPDATE_VALUE (has no meaningful return value)
	 * Implemented visit method to increment contents of all nodes by UPDATE_VALUE
	 * */
	public int visit(BST n, int UPDATE_VALUE){
		return visit(n.getRoot(), UPDATE_VALUE);
	}
}
