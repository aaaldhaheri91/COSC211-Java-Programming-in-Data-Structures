import java.util.*;
import javax.swing.*;

public class Driver {

	public static void main(String[] args) {
		//its a template: means arraylist of any type, cannot be primitive type, only class
		ArrayList<Integer> grades = new ArrayList<Integer>(); 
		ArrayList<String> states = new ArrayList<String>(50);	//if specified resereved memory when you add it goes to index 51
		String[] names = {"1","2","3","4","5","6","7","8","9","0",".","C"};
		ArrayList<JButton> numericButn = new ArrayList<JButton>(12);
		
		for(int i = 0; i < 12; i++){
			numericButn.add(new JButton(names[i]));
			System.out.println(numericButn.get(i));
		}
		
		//loop to create strings in arraylist cuz we only added space for 50 objects, we never created objects
		for(int i = 0; i < 50; i++)
			states.add(new String(""));
		
		//example that when you add it puts it in 51
		states.add("MI");
		System.out.println("The states size is: " + states.size()); //gives size of how many filled
		states.set(3, "OH");
		System.out.println("The states size is: " + states.size()); //gives size of how many filled
		
		//loop through string arraylist
		int n = 0;
		states.remove("OH");	//removes object
		//states.remove(3);	//removes index
		for(String str: states){
			
			if(n % 10 == 0)
				System.out.println();
			System.out.print(str + ", ");
			n++;
		}
		
		
		
		
		grades.add(89);
		grades.add(77);
		grades.add(95);
		
		grades.sort(null);		//to sort them by default
		
		
		//System.out.println(grades.indexOf(78));
		
		System.out.println("\nThe size is: " + grades.size());
		for(Integer e: grades)
			System.out.println(e);
		System.out.println("Second grades is " + grades.get(1));
		
		grades.set(2, 100);
		System.out.println("The third grade now is: " + grades.get(2));
		
		if(grades.contains(95))					//if using variable make sure you cast it to an object of class type of array
			System.out.println("Yes 95 is in the list");
		else
			System.out.println("Not found");
		
	}

}
