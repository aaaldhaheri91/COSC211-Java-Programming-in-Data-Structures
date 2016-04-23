/*
 * Author: Ahmed Aldhaheri
 * Course#: COSC 221 MW 10am - 11:50
 * Semester: Winter 2016
 * Description: purpose of the program is to add and subtract two 8-bit binary numbers
 */

import java.util.*;
public class AddSubBinary {
	
	public static void main(String[] args) {
		//declare variables 
		String num1 = "";
		String num2 = "";
		int userChoice;
		String result = "";
		boolean isNeg1, isNeg2;
		
		Scanner input = new Scanner(System.in);
		
		//Ask user for operation choice
		System.out.println("Please choose one of the following:\n(1) Add\n(2) Subtract\n(3) Exit: ");
		userChoice = input.nextInt();
		input.nextLine();
		
		//start do while
		while(userChoice != 3){
			
			//Ask user for two 8-bit binary numbers
			System.out.println("Enter 8-bit signed binary number: ");
			num1 = input.nextLine();
			System.out.println("Enter another binary number: ");
			num2 = input.nextLine();
			
			//check if numbers are 8-bit binary
			if(num1.length() != 8 || num2.length() != 8){
				System.out.println("Please enter 8-bit binary number!\n");
				continue;
			}
			
			//check if addition or subtraction
			if(userChoice == 1){
				//pass to operation method to return result
				result = performOperation(num1, num2, userChoice);
			}//end if statement
			
			//check if subtraction
			else{
				//check if one of the numbers or both are negative
				isNeg1 = isNegative(num1);
				isNeg2 = isNegative(num2);
				if(isNeg1 && isNeg2)
					num2 = flipBinary(num2); //if both negative flip second one
				else if(isNeg2)
					num2 = flipBinary(num2); //if second number is negative flip it
				else if(isNeg1){
					num2 = flipBinary(num2); //if first number is negative flip second number
				}
				else
					num2 = flipBinary(num2); //if both positive flip second number to subtract them
				
				//pass to operation method to return result
				result = performOperation(num1, num2, userChoice);
			}//end else	
			
			System.out.println("The sum in Binary is: " + result);
			System.out.println("\nPlease choose one of the following:\n(1) Add\n(2) Subtract\n(3) Exit: ");
			userChoice = input.nextInt();
			input.nextLine();
		}//end while
		
		input.close();
		System.out.println("Thank You");
	
	}//end main

	public static String performOperation(String num1, String num2, int userChoice){
		//takes two 8-bit bianry numbers and adds them
		String result = "";
		int temp1 = 0, temp2 = 0, carry = 0, sum = 0;
		
		//loop through two numbers to add them
		for(int i = num1.length() - 1; i >= 0; --i){
			//assign numbers to temp variables to perform addition 
			if(num1.charAt(i) == '0')
				temp1 = 0;
			else
				temp1 = 1;
			if(num2.charAt(i) == '0')
				temp2 = 0;
			else
				temp2 = 1;
			//add the two temp variables
			sum = temp1 + temp2 + carry;
			if(sum == 3){
				result += '1';
				carry = 1;
			}
			else if(sum == 2){
				result += '0';
				carry = 1;
			}
			else if(sum == 1){
				result += '1';
				carry = 0;
			}
			else{
				result += '0';
				carry = 0;
			}
		}//end for loop
		
		//create a buffer object to reverse numbers
		StringBuffer buffer = new StringBuffer(result);
		result = buffer.reverse().toString();
		return result;
	}//end method
	
	public static String flipBinary(String num){
		//Negation of binary number
		
		String temp = "";	//temp variable to store result
		int index = 0;
		//look for first one in the binary number and save it
		for(int i = num.length() - 1; i >= 0; --i){
			if((num.charAt(i)) == '1'){
				index = i;
				break;
			}
		}//end for loop
		
		//add sub of Array to index place to the temp variable
		for(int i = num.length() - 1; i >= index; --i){
			temp += num.charAt(i);
			
		}
		//flip the rest of the numbers
		for(int i = index - 1; i >= 0; --i){
			if(num.charAt(i) == '1')
				temp += "0";
			else
				temp += "1";
		}
		
		//since started from end of string we need to reverse temp to have correct result
		StringBuffer buffer = new StringBuffer(temp);	//reverse temp
		temp = buffer.reverse().toString();
		return temp;
	}//end method
	
	public static boolean isNegative(String num){
		//checks if any of the numbers is negative to perform subtraction
		
		if(num.charAt(0) == '1')
			return true;
		else
			return false;
		
	}//end method
	

}//end class
