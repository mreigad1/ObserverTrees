package studentBackup.mrutil;

public interface NodeSubject {
	/**
	 * @param n - NodeObserver to register to listener list
	 * Method registers an observer from the collection of observers
	 * */
	public void registerNode(NodeObserver n);
	
	/**
	 * @param n - NodeObserver to remove from listener list
	 * Method removes an observer from the collection of observers
	 * */
	public void removeNode(NodeObserver n);
	
	/**
	 * @param val - the integer value to insert into the other trees
	 * @param insertedNode - the child node in this tree to which new nodes should be subscribed
	 * Method updates all NodeObservers with new children containing val
	 * */
	public void updateWithNewChild(int val, NodeSubject insertedNode);
	
	/**
	 * Method updates the value of listening nodes with this node's value
	 * */
	public void updateAll();
}
