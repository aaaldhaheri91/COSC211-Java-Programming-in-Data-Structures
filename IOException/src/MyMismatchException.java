import java.util.*;

public class MyMismatchException extends InputMismatchException {
	private String msg = "";
	
	public MyMismatchException(){
		super();
		msg = "Input is invalid";
	}
	
	public MyMismatchException(String msg){
		super();
		this.msg = msg;
	}
	
	@Override
	public String getMessage(){
		return msg;
	}
}
