/*
 * 	Author: Ahmed Aldhaheri
 * 	Course: COSC211
 * 	Assignment #1
 * 	Description: Purpose of program is to find out how many picks are needed 
 * 	before you see one of each suit from a shuffled deck of 52 cards
 *
 */



import java.util.*;
public class CardDriver{

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<Card> deck = new ArrayList<Card>(52);
		
		//Adds an array of objects
		for(int i = 0; i < 52; ++i){
			Card c = new Card();
			deck.add(c);
		}
		System.out.println("deck has size of " + deck.size());
		
		//build the deck
		int i = 0;
		for(int s = 1; s <= 4; ++s){
			
			for(int f = 1; f <= 13; ++f){
				Card c = deck.get(i);
				String face = " ";
				char suit = ' ';
				//call getFace method to get the face of card
				face = getFace(f, face);
				
				//sets suit for each card in the deck
				switch(s){
				case 1: suit = '\u2665';break;
				case 2: suit = '\u2666';break;
				case 3: suit = '\u2663';break;
				case 4: suit = '\u2660'; break;
				}
				c.setCard(face, suit);
				//sets deck object
				deck.set(i, c);
				i++;
			}
		}
		
		//shffle deck of cards
		Random rd = new Random();
		for(int index = 0; index < 52; ++index){
			Card c = deck.get(index);
			deck.remove(index);
			int n = rd.nextInt(52);
			deck.add(n, c);
		}
		
		//initialize variables to keep track of how many suits
		int spades = 0, clubs = 0, diamonds = 0, hearts = 0, indx = 0;
		//keep looping as long as each suit > 1
		while(spades < 1 || clubs < 1 || diamonds < 1 || hearts < 1){
			Card cardChosen = deck.get(indx);
			//check which suit has been chosen
			if(cardChosen.getSuit() == '\u2665')
				hearts++;
			else if(cardChosen.getSuit() == '\u2666')
				diamonds++;
			else if(cardChosen.getSuit() == '\u2663')
				clubs++;
			else
				spades++;
			//increment to choose next card in deck and count how many times it will take
			indx++;
		}
		//displays the result
		String face = " ";
		System.out.print("\n" + getFace(hearts, face) + " of Hearts\n" + getFace(diamonds, face) + " of Diamonds\n"
						+ getFace(clubs, face) + " of Clubs\n" + getFace(spades, face) + " of Spades\n");
		System.out.println("\nTotal number of picks is: " + indx);
		System.out.println("THANK YOU FOR USING AHMED ALDHAHERI PROGRAM");
		
	}//end main
	
	//returns face of a card
	public static String getFace(int f, String face){
		switch(f){
		case 1: face = "Ace"; break;
		case 10: face = "Ten"; break;
		case 11: face = "Jack"; break;
		case 12: face = "Queen"; break;
		case 13: face = "King"; break;
		default: face = String.valueOf((char) (f + '0'));break;
		
		}//end switch statement
		return face;
	}

}//end class