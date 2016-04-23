/*
 * Ahmed Aldhaheri
 * COSC 221 / Section 27450/ Winter 2016
 * Machine Problem #1 (Conversion)
 * The purpose of the program is to convert a decimal number
 * (0 - 255) to 8-bit binary number and to convert 8-bit binary to decimal
 */

package firstAssignment;
import java.util.*;
import java.lang.Math;

public class DecimalToBinary {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int index = 0, number, userChoice;
		Scanner input = new Scanner(System.in);
		do{
			System.out.println("1.Convert decimal (0 - 255) to binary\n2.Convert binary to decimal\n3.Exit");
			userChoice = input.nextInt();
			input.nextLine();
			
			index = 0;
			if(userChoice == 1){
				System.out.println("Please enter decimal number (0 - 255): ");
				number = input.nextInt();
				
				if(number < 0 || number > 255){
					System.out.println("Number is not valid, please enter number from (0 - 255)");
					System.out.println("-----------------------------------------------------");
					System.out.println("-----------------------------------------------------");
					continue;
				}//end if
				
				int[] binary = new int[8];
				while (number != 0){
					int temp = number % 2;
					binary[binary.length - 1 - index] = temp;
					number /= 2;
					index++;	
				}//end while loop
				System.out.println("The 8-bit binary number is: " + 
									Arrays.toString(binary).replaceAll("\\,|\\[|\\] | |]",""));
				System.out.println("-----------------------------------------------------");
				System.out.println("-----------------------------------------------------");
			}//end if statement
			
			else if(userChoice == 2){
				System.out.println("Please enter 8-bit binary number: ");
				String binary = input.nextLine();
				int decimal = 0;
	
				if(binary.length() != 8){
					System.out.println("Number is not valid, please enter 8-bit number (01010010)");
					System.out.println("-----------------------------------------------------");
					System.out.println("-----------------------------------------------------");
					continue;
				}//end if
				index = 0;
				int i = 7;
				while(index < 8){
					char digit = binary.charAt(index);
					if(digit == '1')
						decimal += Math.pow(2, (i - index));
					index++;
				}//end while loop 
				System.out.println("\nThe decimal number is: " + decimal);
				System.out.println("-----------------------------------------------------");
				System.out.println("-----------------------------------------------------");
			}//end else if
					
			}while(userChoice != 3);
			input.close();
			System.out.println("Good bye");
			
	}//end main

}//end class
