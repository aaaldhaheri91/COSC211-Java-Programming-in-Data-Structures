import java.text.NumberFormat;

public class SavingsAccount extends Account {
	private double interest;
	private double balance;
	NumberFormat formatter = NumberFormat.getCurrencyInstance(); //format output to currency form
	
	//constructor
	public SavingsAccount(int acctNum){
		super(acctNum);
		interest = 0.0;
	}
	
	//deposit method to add interest
	@Override
	public void deposit(double amt){
		if(interest > 0){
			this.balance = amt;
			this.balance += this.balance * interest;
		}
		else
			super.deposit(amt);
			
		
	}
	
	//set interest
	public void setInterest(double interest){
		this.interest = interest;
		deposit(super.getBalance());
		
	}
	
	//get interest
	public double getInterest(){
		return interest;
	}
	
	
	@Override
	public String toString(){
		//displays balance with interest
		if(interest != 0)
			return super.toString() + "\nInterest: %" + (interest * 100) + "\nBalance after interest: " 
					+ formatter.format(balance);
		else
			return super.toString();
	}
	
}//end class
