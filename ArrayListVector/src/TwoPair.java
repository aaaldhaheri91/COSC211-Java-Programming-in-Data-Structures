//when you put <> your are making your own template of any types
public class TwoPair<T1, T2> {
	private T1 first;
	private T2 second;
	
	public TwoPair(){
		first = null;
		second = null;
	}
	
	public TwoPair(T1 f, T2 s){
		first = f;
		second = s;
	}
	
	public void setFirst(T1 f){
		first = f;
	}
	
	public void setSecond(T2 s){
		second = s;
	}
	
	public T1 getFirst(){
		return first;
	}
	
	public T2 getSecond(){
		return second;
	}
	
	public String toString(){
		return ("First is: " + first + " and second is: " + second);
	}
}
