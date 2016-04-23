import java.text.NumberFormat;

public class CheckingAccount extends Account {
	private double overDraft;	//overdraft limit variable
	private final double FEES = 35.0;
	NumberFormat formatter = NumberFormat.getCurrencyInstance(); //format output to currency form
	
	public CheckingAccount(int acctNum){
		super(acctNum);
		overDraft = 0;
	}
	
	@Override
	public void withdraw(double amt){
		//Checks if withdraw is greater than balance and displays overdrafted amount
		if(amt > 0 && amt < super.getBalance())
			super.withdraw(amt);
		else{
			overDraft = super.getBalance() - amt;
			System.out.println("You have overdrafted your account");
		}
	}
	
	@Override
	public String toString(){
		if(overDraft != 0)
			return "Account number: " + super.getAccountNumber()+  "\nCurrent balance after overdraft: " + formatter.format(overDraft)
					+ "\nFees: " + formatter.format(FEES) + "\nBalance after fees: " + formatter.format(overDraft - FEES);
		else
			return super.toString();
	}
	
	
	
}//end class
