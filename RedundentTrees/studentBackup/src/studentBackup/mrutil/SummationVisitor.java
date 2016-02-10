package studentBackup.mrutil;

import studentBackup.bst.BST;
import studentBackup.bst.Node;

public class SummationVisitor implements MRVisitor{

	/**
	 * Constructor
	 * */
	public SummationVisitor(){
		debugAssistant.ConstructorPrint("SummationVisitor");
	}

	/**
	 * @return the sum of the node values in the subtree
	 * @param n - the root node to visit with this algorithm
	 * @param UPDATE_VALUE - does nothing meaningful for this implementation (leave as 0)
	 * Method returns the sum of node values in the sub tree
	 * */
	public int visit(Node n, int UPDATE_VALUE){
		int retVal = 0;
		if(n != null){
			if(n.getLeft() != null){
				retVal += visit(n.getLeft(), 0);
			}
			if(n.getRight() != null){
				retVal += visit(n.getRight(), 0);
			}
			retVal += n.getData();
		}
		return retVal;
	}
	/**
	 * @return the sum of the node values in the BST
	 * @param n - the BST to visit with this algorithm
	 * @param UPDATE_VALUE - does nothing meaningful for this implementation (leave as 0)
	 * Method returns the sum of node values in the tree
	 * */
	public int visit(BST n, int UPDATE_VALUE) {
		return visit(n.getRoot(), 0);
	}
}
