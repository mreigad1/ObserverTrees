package studentBackup.driver;

import java.util.Vector;

import studentBackup.bst.BST;
import studentBackup.mrutil.IncrementVisitor;
import studentBackup.mrutil.MRVisitor;
import studentBackup.mrutil.SummationVisitor;
import studentBackup.mrutil.debugAssistant;
import studentBackup.util.BSTBuilder;

public class Driver {
	public static int DUPE_NUM = 2;
	public static int UPDATE_VALUE = 0;
	public static void main(String[] args) {
		String fileName;
		if(args.length != 3){
			debugAssistant.setDebugVal(0);
		}else{
			debugAssistant.setDebugVal(Integer.parseInt(args[2]));
		}
		if(args.length != 2 && args.length != 3){
			fileName = "C:\\Users\\matthew\\Downloads\\bstInput.txt";
			UPDATE_VALUE = 100;
		}else{
			fileName = args[0];
			UPDATE_VALUE = Integer.parseInt(args[1]);
		}
		debugAssistant.driverPrint("Program Start.\n");
		if(args.length == 3 || args.length == 2 || debugAssistant.testing()){
			BST base = new BST();
			Vector<BST> duplicates = new Vector<BST>();
			for(int i = 0; i < DUPE_NUM; i++){
				duplicates.add(new BST());
			}

			debugAssistant.driverPrint("Constructing BST's\n");
			BSTBuilder bb = new BSTBuilder(fileName, base, duplicates);
			bb.populateBST();
			
			debugAssistant.driverPrint("\nSize of BST: " + base.getTreeSize());
			debugAssistant.driverPrint("\nBST contents:");
			base.printInOrder();
			for(BST b : duplicates){
				b.printInOrder();
			}
			int[] Sums = new int[6];
			MRVisitor v = new SummationVisitor();
			Sums[0] = v.visit(base, 0);
			Sums[1] = v.visit(duplicates.get(0), 0);
			Sums[2] = v.visit(duplicates.get(1), 0); 
			debugAssistant.driverPrint("\nSUM OF BASE BST VALUES: " + v.visit(base, 0));
			debugAssistant.driverPrint("\nBST contents:");
			base.printInOrder();
			for(BST b : duplicates){
				b.printInOrder();
			}
			debugAssistant.driverPrint("\nINCREMENTING ALL CONTENTS:");
			v = new IncrementVisitor();
			v.visit(base, UPDATE_VALUE);
			debugAssistant.driverPrint("\nBST contents:");
			base.printInOrder();
			for(BST b : duplicates){
				b.printInOrder();
			}
			v = new SummationVisitor();
			Sums[3] = v.visit(base, 0);
			Sums[4] = v.visit(duplicates.get(0), 0);
			Sums[5] = v.visit(duplicates.get(1), 0);
			debugAssistant.driverPrint("NEW SUM OF BASE BST VALUES: " + v.visit(base, 0) + "\n");
			debugAssistant.driverPrint("\nBST contents:");
			base.printInOrder();
			for(BST b : duplicates){
				b.printInOrder();
			}

			for(int i = 0; i < 6; i++){
				debugAssistant.driverPrint("Sum of tree " + i + ": " + Sums[i] + "\n");
			}
		}
		debugAssistant.driverPrint("Program End.\n");
	}
}
