import java.util.*;
import javax.swing.*;
public class Roman {
	private String roman;
	private int digits;
	private int[] intArray = {1000, 500, 100, 50, 10, 5, 1};
	private char[] romanArray = {'M', 'D', 'C', 'L', 'X', 'V', 'I'};

	public Roman(){
		roman = "";
		digits = 0;
	}//end constructor
	
	//set roman
	public void setRoman(String roman){
		this.roman = roman;
		//send to validation method
		validateRoman(roman);
	}
	
	//get roman
	public String getRoman(){
		
		return roman;
	}
	
	public int convertRomanToInt(String rom){
		//send to validation method
		validateRoman(rom);
		
		//convert roman to integer
		for(char c: rom.toCharArray()){
			for(int i = 0; i < romanArray.length; ++i )
				if(c == romanArray[i])
					digits += intArray[i];
		}//end for loop
		
		return digits;
	}
	
	public void convertIntToRoman(int digits){
		//convert int to roman
		this.digits = digits;
		int division;		//division variable
		
        for(int i = 0; digits > 0; ++i){
            division = digits / intArray[i];		//divide to check if one or greater
            for(int j = 1; j <= division; ++j){
                roman += romanArray[i];		//add as long division is one or greater
            }
            digits %= intArray[i];			//the remainder of digits after dividing by index element
        }    
	}
	
	public void displayRoman(){
		
		System.out.println(roman);
	}
	
	public void validateRoman(String roman){
		//validate if roman notation is legal
		ArrayList<Integer> checkArray = new ArrayList();
		
		//convert roman to an integer arraylist
		for(char c: roman.toCharArray()){
			for(int i = 0; i < romanArray.length; ++i)
				if(c == romanArray[i])
					checkArray.add(intArray[i]);	//add number to list
		}
		for(int i = 0; i < checkArray.size(); i++){
			System.out.print(checkArray.get(i) + " ");
		}
		//use sort algorithm to see if legal
		outerloop:
		for(int i = 0; i < checkArray.size(); ++i){
			for(int j = i + 1; j < checkArray.size(); ++j){
				if(checkArray.get(i).compareTo(checkArray.get(j)) < 0){
					JOptionPane.showMessageDialog(null, "Illegal roman number!, please try again");
					break outerloop;
				}
			}//end inner loop
		}//end outer loop		
	}
	
}//end class
