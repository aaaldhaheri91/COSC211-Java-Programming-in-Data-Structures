/*
 *	Author: Ahmed Aldhaheri
 * 	Course: COSC211
 * 	Assignment #2
 * 	Description: Purpose of program to create objects of child classes
 * 				 holding bank accounts and updating bank account balance
 * 				 by depositing money or withdrawing
 *
 */
import java.util.*;
public class Bank {
	
	static Scanner input = new Scanner(System.in);
	
	public static void main(String[] args) {
		//create a reference array to Account
		Account[] bankAccount = new Account[2];
		int account1 = 0, account2 = 0;
		
		//ask user for account number
		System.out.println("Please enter your account number: ");
		account1 = input.nextInt();
		System.out.println("Please enter second account number: ");
		account2 = input.nextInt();
		
		//create objects of SavingsAccount class and CheckingAccount class
		bankAccount[0] = new SavingsAccount(account1);
		bankAccount[1] = new CheckingAccount(account2);
		
		//Test 1 for SavingsAccount class
		System.out.println("\nTest #1 for deposit 1000 SavingsAccount class");
		bankAccount[0].deposit(1000);
		bankAccount[0].print();
		
		
		//Test 2 for SavingsAccount class
		System.out.println("\nTest #2 to with withdraw 800 SavingsAccount class");
		bankAccount[0].withdraw(800);
		bankAccount[0].print();
		
		
		//Test 1 for CheckingAccount class
		System.out.println("\nTest #1 deposit a negative number for CheckingAccount class");
		bankAccount[1].deposit(-300);
		bankAccount[1].print();
		
		//Test 2 for CheckingAccount class
		System.out.println("\nTest #2 deposit 1500 amount to CheckingAccount class");
		bankAccount[1].deposit(1500);
		bankAccount[1].print();
		
		update(bankAccount);
		
	}//end main
	
	public static void update(Account[] bankAccount){
		//Updates the bank accounts with interest added to balance and if account is overdrafted
		System.out.println("\nUpdate");
		
		double interest = 0, amount = 0;
		SavingsAccount account0 = (SavingsAccount)bankAccount[0];
		CheckingAccount account1 = (CheckingAccount)bankAccount[1];
		
		//iterate through accounts and update them
		for(int i = 0; i < bankAccount.length; ++i){
			if(i == 0){
				System.out.println("Please enter interest rate for account number: " + bankAccount[i].getAccountNumber());
				interest = input.nextDouble();
				account0.setInterest(interest);
				account0.print();
			}//end if statement
			else{
				System.out.println("\nPlease enter withdraw amount for account number: " + bankAccount[i].getAccountNumber());
				amount = input.nextDouble();
				account1.withdraw(amount);
				account1.print();
			}//end else statement
		}//end for loop
		input.close();
	}

}//end class
