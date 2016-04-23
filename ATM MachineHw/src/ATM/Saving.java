package ATM;
import java.io.*;
import java.util.*;
public class Saving {
	
	private double balance;
	private BankAccount account;
	private Scanner fin = null;
	private File inputFile = null;
	private PrintWriter fout = null;
	private String[] line = new String[4];
	private String firstLine;
	private String delimeter = null;
	private int accountNum;
	
	public Saving(){
		this.account = new BankAccount();
		this.inputFile = new File("src\\ATM\\bankData.txt");
		this.delimeter = this.account.getDelimeter();
		this.firstLine = "Account		Pin		Checking	Saving";
		
		//connect file to stream
		try{
			fin = new Scanner(inputFile);
		}catch(FileNotFoundException e){
			System.exit(0);
		}
		
		//read through file to search for account
		int i = 0;
		fin.nextLine();	//gets rid of columns titles
		
		while(fin.hasNextLine()){
			this.line[i] = fin.nextLine();
			i++;
		}
		
	}//end constructor
	
	public double getBalance(){
		this.balance = runThroughData();
		return this.balance;
	}
	
	public void deposit(double amount){
		this.balance += amount;
		writeToFile();
	}
	
	public void withdraw(double amount){
		this.balance -= amount;	
		writeToFile();
	}
	
	public double runThroughData(){
		//account.line[1].replace(String.valueOf(account.getAccountNum()), String.valueOf(this.balance));
		double balance = 0;
		
		for(int i = 0; i < this.line.length; i++){
			String temp = this.line[i].split(this.delimeter)[0];
			if(this.accountNum == Integer.valueOf(temp)){
				temp = this.line[i].split(this.delimeter)[3];
				balance = Integer.valueOf(temp);
				return balance;
			}//end if
		}//end for loop
		return 0;
	}
	
	public void setAccountNum(int accountNum){
		this.accountNum = accountNum;
	}
	
	
	public void writeToFile(){
		try{
			fout = new PrintWriter(inputFile);
		}catch(FileNotFoundException e){
			System.exit(0);
		}
		
		ArrayList<String> writeToFileArray = new ArrayList<String>();
		//convert string array to array list
		for(int i = 0; i < line.length; i++){
			writeToFileArray.addAll(Arrays.asList(this.line[i].split(this.delimeter)));
		}
		
		//modify account balance
		for(int i = 0; i < writeToFileArray.size(); i++){
			if(this.accountNum == Integer.valueOf(writeToFileArray.get(i).trim()))
				writeToFileArray.set(i+3, String.valueOf(String.format("%.0f", this.balance)));	
		}
		
		//write modified data to file
		fout.println(firstLine);
		for(int i = 0; i < writeToFileArray.size(); i++){
			if(i != 0 && i % 4 == 0)
				fout.println();
			fout.print(writeToFileArray.get(i) + "\t\t");
	
		}
		fout.close();
	}
}//end class
