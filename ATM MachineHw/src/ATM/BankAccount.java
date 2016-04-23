package ATM;

import java.io.*;
import java.util.*;

public class BankAccount {
	
	private Scanner fin = null;
	private File inputFile = null;
	private int accountNum;
	private int pin;
	private String [] line = new String[4];
	private String delimeter = null;
	//private Checking checking = null;
	//private Saving saving = null;
	
	public BankAccount(){
		inputFile = new File("src\\ATM\\bankData.txt");
		delimeter = "\t\t";
		//checking = new Checking();
		//saving = new Saving();
		
	}
	
	//checks if account entered by user is in file
	public boolean isAccountInFile(String accountNum){

		this.accountNum = Integer.valueOf(accountNum);
		
		//connect file to stream
		try{
			fin = new Scanner(inputFile);
		}catch(FileNotFoundException e){
			System.out.println("File not found");
			return false;
		}
		
		//read through file to search for account
		int i = 0;
		fin.nextLine();	//gets rid of columns titles
		
		while(fin.hasNextLine()){
			this.line[i] = fin.nextLine();
			i++;
		}
		fin.close();
		//check if account in file
		for(int j = 0; j < line.length; j++){
			String temp = line[j].split(delimeter)[0];
			if(Integer.valueOf(temp) == this.accountNum)
				return true;
		}
	
		return false;
	}
	
	public String getDelimeter(){
		return delimeter;
	}
	
	//checks if pin is correct
	public boolean isPinCorrect(String pin){
		
		this.pin = Integer.valueOf(pin);
		for(int i = 0; i < line.length; i++){
			String temp = line[i].split(delimeter)[1];
			if(Integer.valueOf(temp) == this.pin)
				return true;
		}
		
		return false;
	}
	
}//end class
