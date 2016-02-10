package studentBackup.mrutil;

public interface NodeObserver {
	/**
	 * @param value - the value to give to the new child of this node
	 * @param insertedNode - the new subject that new observing children should listen to
	 * Method updates the node with new child storing value
	 * */
	public void update(int value, NodeSubject insertedNode);
	
	/**
	 * @param value - the new value to update this node with 
	 * Method updates the value of this node
	 * */
	public void update(int value);
}
