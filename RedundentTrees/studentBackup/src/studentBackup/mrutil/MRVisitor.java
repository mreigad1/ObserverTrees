package studentBackup.mrutil;
import studentBackup.bst.BST;
import studentBackup.bst.Node;
public interface MRVisitor {
	/**
	 *@param n - the BST to visit
	 *@param UPDATE_VALUE - the integer to use for visiting
	 * Method visits BST structure and provides visitor a value to use to visit tree 
	 * */
	public int visit(BST n, int UPDATE_VALUE);
	/**
	 *@param n - the node root to visit
	 *@param UPDATE_VALUE - the integer to use for visiting
	 * Method visits Node tree structure and provides visitor a value to use to visit tree 
	 * */	
	public int visit(Node n, int UPDATE_VALUE);
}
