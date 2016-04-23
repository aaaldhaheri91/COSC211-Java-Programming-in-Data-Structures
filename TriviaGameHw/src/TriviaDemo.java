/*
 * Ahmed Aldhaheri
 * Date: 03/3/2016
 * Course: COSC211, Winter 2016
 * Description: Read questions from file and write to a binary file. 
 * 				Read from binary file and start trivia game to ask user 5 questions
 */

import java.util.*;
import java.io.*;
public class TriviaDemo {

	public static void main(String[] args) {
		//declare variables and objects
		Scanner input = new Scanner(System.in);
		Scanner inFile = null;
		File inFileStreamName = null;
		String question = "", answer = "";
		int points = 0;
		Trivia[] triviaObj = new Trivia[5];
		Trivia[] triviaBin = new Trivia[5];
		ArrayList<String> readBinary = new ArrayList<String>();
		
		//creating a binary file using objects
		FileOutputStream binaryCreate = null;
		ObjectOutputStream binaryWrite = null;
		
		//reading from binary file
		FileInputStream binarySave = null;
		ObjectInputStream binaryRead = null;
		
		//assign file 
		inFileStreamName = new File("src\\questionsAnswer.txt");
		
		//assign to scanner
		try{
			inFile = new Scanner(inFileStreamName);
		}catch(FileNotFoundException e){
			System.out.println(e.getMessage());
			System.exit(0);
		}
		
		//read from file
		try{
			int i = 0;
			while(inFile.hasNextLine()){
				String line = inFile.nextLine();
				String[] values = line.split(",");
				question = values[0];
				answer = values[1];
				points = Integer.parseInt(values[2]);
				triviaObj[i] = new Trivia(question, answer, points);
				i++;
			}
		} finally{
			if(inFile != null)
				inFile.close();
		}
		
		//write binary file
		try{
			binaryCreate = new FileOutputStream("src\\binary.dat"); //.dat: data file
			binaryWrite = new ObjectOutputStream(binaryCreate);
			for(int i = 0; i < triviaObj.length; ++i){
				binaryWrite.writeObject(triviaObj[i].getQuestion());
				binaryWrite.writeObject(triviaObj[i].getAnswer());
				binaryWrite.writeObject(triviaObj[i].getPoints());
			}
			binaryWrite.close();
		}
		catch(IOException e){
			System.out.println(e.getMessage());
			System.exit(0);
		}
		
		//read binary file 
		try{
			binarySave = new FileInputStream("src\\binary.dat"); 
			binaryRead = new ObjectInputStream(binarySave);
			
			try{
				
				while(true){
					//loop through file and read data
					String read = binaryRead.readObject().toString();
					//add data to array list
					readBinary.add(read);
				}
			}catch(EOFException e){
				System.out.println("No more data");
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
			binaryRead.close();
			
		}catch(IOException e){
			e.printStackTrace();
		}
		
		//convert array list to string array
		String[] stringBin = new String[readBinary.size()];
		int indx = 0; //iterate through string array
		for(String str: readBinary){
			stringBin[indx] = str;
			indx++;
		}//end for loop
		
		//declare variables used to assign string array values into trivia array object
		indx = 0;
		int indx2 = 0;
		int que = 0, ans = 1; //keep track of each variable(question,answer,points) index
		
		//assign data in stringBin array to Trivia objects
		for(int i = 0; i < 5; ++i){
			indx2 = indx;	
			for(int j = indx; j < indx2 + 3; j++){
				if(j == que)
					question = stringBin[j];
				else if(j == ans)
					answer = stringBin[j];
				else 
					points = Integer.valueOf(stringBin[j]);
				indx++;
			}//end loop
			//increment index variables by 3
			que += 3;
			ans += 3;
			//assign to trivia array of objects
			triviaBin[i] = new Trivia(question, answer, points);
			
		}//end outer loop
		
		//declare random object to pick random question
		Random rd = new Random();
		System.out.println("Game started please answer the following questions: \n");
		points = 0;
		indx = 0;
		double totalPoints = 0;
		ArrayList<Integer> randomArray = new ArrayList<Integer>();
		
		//start game
		while(indx < triviaBin.length){
			//pick a random question
			int random = rd.nextInt(5);
			//check if random number has been chosen before
			if(randomArray.contains(random))
				continue;
			
			System.out.println(triviaBin[random].getQuestion());
			answer = input.nextLine();
			
			//check if answer is correct
			if(answer.equalsIgnoreCase(triviaBin[random].getAnswer())){
				points += triviaBin[random].getPoints();
				System.out.println("Your answer is correct!");
			}
			else{
				System.out.println("Your answer is incorrect!");
				System.out.println("Correct answer is " + triviaBin[random].getAnswer());
			}
			totalPoints += triviaBin[random].getPoints();
			randomArray.add(random);
			indx++;
		}
		//display results
		System.out.println("\nGame is over");
		System.out.println("Your score is: " + points + "/" + totalPoints);
		System.out.println("Your percentage score is: %" + String.format("%.2f", (points / totalPoints) * 100));
		input.close();
	}//end main

}
