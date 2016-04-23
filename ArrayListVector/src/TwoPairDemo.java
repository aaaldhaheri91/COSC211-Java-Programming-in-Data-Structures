import java.util.*;
import javax.swing.*;
public class TwoPairDemo {

	public static void main(String[] args) {
		
		
		TwoPair<String, Integer> pair = new TwoPair<String, Integer>();
		ArrayList<TwoPair<String, Integer> > students = new ArrayList<TwoPair<String, Integer> >();
		Vector<Integer> exams = new Vector<Integer>();		//this is exactly like vector
		exams.add(99);
		
		pair.setFirst("Anna");
		pair.setSecond(99);
		pair.setFirst("Ahmed");
		pair.setSecond(96);
		
		System.out.println(pair.getFirst() + " and her grade is: " + pair.getSecond());
		
			
		
		students.add(pair);
	}

}
