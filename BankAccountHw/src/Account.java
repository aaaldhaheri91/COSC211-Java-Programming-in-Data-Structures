import java.text.NumberFormat;

public class Account {
	
	private double balance;	//The current balance
	private int acctNum;	//The account number
	NumberFormat formatter = NumberFormat.getCurrencyInstance(); //format output to currency form
	
	public Account(int acctNum){
		balance = 0.0;
		this.acctNum = acctNum;
	}
	
	public void deposit(double amt){
		//takes amt and adds it to balance if amount is positive
		if(amt > 0)
			this.balance += amt;
		else
			System.out.println("Invalid deposit amount");
	}
	
	public void withdraw(double amt){
		//Subtracts amt from balance only if positive
		if(amt > 0)
			this.balance -= amt;
	}
	
	public double getBalance(){
		//returns balance
		return balance;
	}
	
	public int getAccountNumber(){
		//returns account number
		return acctNum;
	}
	
	public String toString(){
		//displays account number and balance
		return ("Account number: " + acctNum + "\nBalance: " + formatter.format(balance));
	}
	
	public final void print(){
		//shoul print toString()
		System.out.println(toString());
	}
	
}//end class
