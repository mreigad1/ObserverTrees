package studentBackup.mrutil;

public class debugAssistant {
	private static int debugVal;
	private static boolean debugging = false;
	
	public static int getDebugVal(){
		return debugVal;
	}
	
	public static void setDebugVal(int d){
		debugVal = Math.max(0, Math.min(4, d));
	}
	
	public static boolean testing(){
		return debugging;
	}
	
	/**
	 * @param information - the information to print
	 * Method prints information from driver code when debug is configured appropriately
	 * */
	public static void driverPrint(String information){
		printVal0(information);
	}
	private static void printVal0(String information){
		if(debugVal == 0){
			System.out.print(information);
		}
	}
	
	/**
	 * Method prints output for constructors when 
	 * debug value is set to print constructors
	 * */
	public static void ConstructorPrint(String invoker){
		printVal1(invoker);
	}
	private static void printVal1(String invoker){
		if(debugVal == 1){
			System.out.print("\tConstructor called from: " + invoker  + "\n");
		}
	}
	
	/**
	 * Method prints whether duplicated arrays were equal when
	 * checked and debug value is set to check for equality
	 * */
	public static void duplicatesCorrect(String invoker, int numTrees){
		printVal2(invoker, numTrees);
	}
	private static void printVal2(String invoker, int numTrees){
		if(debugVal == 2){
			System.out.print("\tAll " + numTrees + " trees are equal: " + invoker + "\n");
		}
	}
	
	/**
	 * Method prints when duplicated data structure nodes receive
	 * update messages and the debug value is set to print this
	 * */
	public static void updatePrint(String invoker){
		printVal3(invoker);
	}
	private static void printVal3(String invoker){
		if(debugVal == 3){
			System.out.print("\tUpdate received by: " + invoker + "\n");
		}		
	}
	
	/**
	 * Method prints when subject nodes in base tree send
	 * an update message to all observers
	 * */
	public static void updateAllPrint(String invoker){
		printVal4(invoker);
	}
	private static void printVal4(String invoker){
		if(debugVal == 4){
			System.out.print("\tUpdate sent by: " + invoker + "\n");
		}
	}
}
