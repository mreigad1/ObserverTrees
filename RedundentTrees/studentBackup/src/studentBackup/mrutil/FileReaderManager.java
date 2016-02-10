package studentBackup.mrutil;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class FileReaderManager {
	private String FileInputName;
	private BufferedReader reader;
	
	/**
	 * @param FileName- the name of the file from which to pull input
	 * Constructor for FileInputManager objects
	 * */
	public FileReaderManager(String FileName){
		debugAssistant.ConstructorPrint("FileReaderManager");
		FileInputName = FileName;
		try{
			reader = new BufferedReader(new FileReader(FileInputName));
		}catch(FileNotFoundException e){
			System.out.print("\nInput file not found for File: " + FileInputName + ", program exiting.\n");
			System.exit(0);
		}
	}
	
	/**
	 * @return the name of the file for input
	 * Method returns the name of the file the manager pulls input from
	 * */
	public String getFileName(){
		return FileInputName;
	}
	
	/**
	 * @return the next line from the input file
	 * Method returns the next line from the file
	 * */
	public synchronized String getLine(){
		String s = null;
		try {
			s = reader.readLine();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return s;
	}
}
