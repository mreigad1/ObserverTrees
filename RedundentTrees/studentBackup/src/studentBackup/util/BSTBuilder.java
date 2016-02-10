package studentBackup.util;
import java.util.Vector;

import studentBackup.mrutil.debugAssistant;
import studentBackup.mrutil.FileReaderManager;
import studentBackup.bst.BST;
import studentBackup.bst.Node;

public class BSTBuilder {
	private FileReaderManager frm;
	private BST binTree;
	private Vector<BST> duplicates;
	private static int DUPE_NUM;
	
	/**
	 * @param fileName - the name of the file from which to pull input
	 * @param b - the base bst to construct
	 * @param d - the Vector<BST> of duplicates to populate
	 * Constructor for BSTBuilder object
	 * */
	public BSTBuilder(String fileName, BST b, Vector<BST> d){
		debugAssistant.ConstructorPrint("BSTBuilder");
		frm = new FileReaderManager(fileName);
		binTree = b;
		duplicates = d;
		DUPE_NUM = duplicates.size();
	}
	
	/**
	 * Method uses contained file to populate stored BST
	 * */
	public BST populateBST(){
		String line;
		if((line = frm.getLine()) != null){
			int val = Integer.parseInt(line);
			Node bstRoot = binTree.insert(val);
			for(int i = 0; i < DUPE_NUM; i++){
				Node root = duplicates.get(i).insert(val);
				bstRoot.registerNode(root);
			}
			
		}
		while((line = frm.getLine()) != null){
			int lineVal = Integer.parseInt(line);
			binTree.insert(lineVal);
		}
		boolean allEqual = true;
		for(BST dupe : duplicates){
			boolean equalFlag = true;
			if(dupe.anyDuplicateData() != binTree.anyDuplicateData()){
				equalFlag = false;
			}else if(dupe.getTreeSize() != binTree.getTreeSize()){
				equalFlag = false;
			}else if(dupe.getSmallestElement() != binTree.getSmallestElement()){
				equalFlag = false;
			}else if(dupe.getLargestElement() != binTree.getLargestElement()){
				equalFlag = false;
			}
			allEqual = (allEqual && equalFlag);
		}
		if(!allEqual){
			debugAssistant.duplicatesCorrect("FALSE", (duplicates.size() + 1));
		}else{
			debugAssistant.duplicatesCorrect("TRUE", (duplicates.size() + 1));
		}
		return binTree;
	}
}
