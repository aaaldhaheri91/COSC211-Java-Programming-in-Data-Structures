public class Card {
	//declare fields 
	private String face;
	private char suit;
	
	//constructor to initialize fields
	public Card(){
		face = " ";
		suit = ' ';
		
	}
	
	//set both fields
	public void setCard(String face, char suit){
		this.face = face;
		this.suit = suit;
	
	}
	
	//displays fields
	public void displayCard(){
		System.out.print(" " + face + suit);
	}
	
	//returns suit
	public char getSuit(){
		return suit;
	}
	
}