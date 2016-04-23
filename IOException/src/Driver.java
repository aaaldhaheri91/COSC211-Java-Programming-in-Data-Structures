/*
 * Exception Handling
 */

import java.util.*;
import java.io.*;

public class Driver {
	public static int readData(Scanner keyb) throws MyArithmeticException{
		int n2 = 0;
		try{
			n2 = keyb.nextInt();
		}catch(InputMismatchException e){
			throw new MyMismatchException("inavalid inpu");
		}
		
		if(n2 == 0)
			throw new MyArithmeticException();
		return n2;
	}
	public static void main(String[] args) {
		
		int n1 = 0, n2 = 0;
		String entry = "";
		int result = 0;
		boolean done = false;
		
		Scanner keyb = new Scanner(System.in);
		
		do{
			try{
				
				System.out.println("Enter two integers: ");
				try{
					n1 = keyb.nextInt();
				}
				catch(InputMismatchException e){
					throw new MyMismatchException("ahmed");
				}
				n2 = readData(keyb);
				
				result = n1 / n2;
				done = true;
			}
			
			catch(MyArithmeticException e){
				System.out.println(e.getMessage());
				result = 0;
			}
			catch(MyMismatchException e){
				keyb.nextLine();
				System.out.println(e.getMessage());
				
			}
			catch(Exception e){
				e.printStackTrace();
				System.out.println(e.getMessage());
				done = true;
			}
		
		}while(!done);
		keyb.close();
		
		
		System.out.println("The result is: " + result);
		

	}

}
