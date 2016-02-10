Matthew Reigada

PURPOSE:
	Program will utilize observer pattern to manage multiple redundant trees to insure proper data integrity of trees.


	To utilize both visitor and observer design patterns in creating and maintaining a Binary Search Tree.
	The program is to implement visitor objects that will increment all the contents of the BST, as well as
	maintaining equality amongst duplicate Binary Search Trees whom's Nodes observe the Nodes of the primary
	Binary Search Tree to maintain the correct values.


DESIGN CHOICES:

	Node objects implement both observer and subject interfaces so as to allow one concrete object type.
	In addition to maintaining Node values with the observer pattern, duplicate BST's insert new data items	via 
	utilization of the observer pattern.  Therefore insert(...) methods invoked upon the master tree
	automatically alert the parent of the new node in the master tree to update it's listeners with new children.
	This means that user code in the driver class and in the BSTBuilder class never needs to insert into the
	duplicate trees directly (with the exception being insertion of the root node in each tree requiring manual
	creation and registration in the BSTBuilder class)

	For debug, there is
	0-Standard output for manually comparing output of visitor and observer implementor effects
	1-Print whenever an object is created, and state invoking class
	2-Print whether the trees are (roughly) equal (checks size, smallest values, largest values)
	3-Prints when Observers call update because a new object needs to be inserted
	4-Prints when Subjects call updateAll to let Observer Nodes know to insert new data


PERCENT COMPLETE:

	The Program is 100% done.
	


PARTS THAT ARE NOT COMPLETE:
	
	None.
	


BUGS:

	None known.
	


FILES:

	There are seven java files required to run this program (8 required files if input is included):
		1.)	Driver.java	(Driver code)
		2.)	Node.java	(Nodes contained in BST)
		3.)	BST.java	(Binary Search Tree, mostly just a root node manager)
		4.)	BSTBuilder.java	(Builder Object for Binary Search Tree and Duplicate BST Vector)
		5.)	debugAssistant.java	(Container for Static Debug data and print functionality)
		6.)	FileReaderManager.java	(Manager for input file)
		7.)	MRVisitor.java		(Visitor Pattern interface for visiting BST's and Nodes)
		8.)	NodeObserver.java	(Observer interface for Nodes)
		9.)	NodeSubject.java	(Subject interface for Nodes)
		10.)	IncrementVisitor.java	(Visitor implementation for incrementing all values of trees)
		11.)	SummationVisitor.java	(Visitor implementation for adding together all values in tree)
		12.)	Input file		(User chosen input file with integers stored line by line)

SAMPLE OUTPUT:

	[java] Program Start.
	[java] Constructing BST's
	[java] 
	[java] Size of BST: 101
	[java] BST contents:
	[java] (2) (5) (7) (11) (13) (17) (19) ...
			...
	[java] INCREMENTING ALL CONTENTS:
	[java] BST contents:
	[java] (27) (30) (32) (36) ...
			...
		...(1344) (1346) (1352) (1386) (1392) (1398) 
	[java] Program End.

	

TO COMPILE:

	extract the files
	enter directory reflection (where build.xml is located)
	compile with "ant compile"


TO RUN:

	command line parameters:	[INPUT FILE NAME] [UPDATE_VALUE] [DEBUG VALUE]

					INPUT FILE NAME:  name of input file
					UPDATE_VALUE:  value to increment BST Nodes with
					DEBUG VALUE:  integer between [0, 4] (less than 0 runs as 0, greater than 4 runs as 4)


EXTRA CREDIT:



BIBLIOGRAPHY:

	Matthew Reigada

ACKNOWLEDGEMENT:

	None.


