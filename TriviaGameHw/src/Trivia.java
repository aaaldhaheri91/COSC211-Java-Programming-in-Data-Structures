
public class Trivia {
	//declare instance variables
	private String question;
	private String answer;
	private int points;
	
	//constructors
	public Trivia(){
		question = "";
		answer = "";
		points = 0;
	}
	
	public Trivia(String question, String answer, int points){
		this.question = question;
		this.answer = answer;
		this.points = points;
	}
	
	//start gets
	public String getQuestion(){
		return question;
	}
	
	public String getAnswer(){
		return answer;
	}
	
	public int getPoints(){
		return points;
	}
	
	//start sets
	public void setQuestion(String question){
		this.question = question;
	}
	
	public void setAnswer(String answer){
		this.answer = answer;
	}
	
	public void setPoints(int points){
		this.points = points;
	}
	
}//end class
