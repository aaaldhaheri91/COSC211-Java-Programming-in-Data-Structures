import java.util.*;
import java.io.*;
public class FileInput {

	public static void main(String[] args) {
		
		Scanner inFile = null;
		File inFileStreamName = null;
		
		FileWriter outFileStreamName = null;
		PrintWriter outFile = null;
		
		String fName = "", lName = "";
		int age = 0;
		
		inFileStreamName = new File("src\\name.txt");
		
		
		try{
			inFile = new Scanner(inFileStreamName);
			outFileStreamName = new FileWriter("output.txt", true);
			outFile = new PrintWriter(outFileStreamName);
		}
		catch(FileNotFoundException e){
			System.out.println(e.getMessage());
			System.exit(0);
		}
		catch(IOException e){
			e.printStackTrace();
		}
		outFile.write("hi this is a test");
		
		//reading from  file
		while(inFile.hasNext()){
			fName = inFile.next();
			lName = inFile.next();
			age = inFile.nextInt();
			
			outFile.println(fName + "\t" + lName + "\t" + age);
			
		}
		
		
		inFile.close();
		outFile.close();
		
		//read from file
		Scanner fis = null;
		File readFile = new File("output.txt");
		
		
		try{
			fis = new Scanner(readFile);
			
		}catch(FileNotFoundException e){
			System.out.println(e.getMessage());
			System.exit(0);
		}
		
		while(fis.hasNextLine()){
			String str = fis.nextLine();
			System.out.println(str);
		}
		
		
	}//end main

}//end classs
