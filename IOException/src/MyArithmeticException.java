import java.util.*;

public class MyArithmeticException extends ArithmeticException {
	
private String msg = "";
	
	public MyArithmeticException(){
		super();
		msg = "divison by zero is not allowed";
	}
	
	public MyArithmeticException (String msg){
		super();
		this.msg = msg;
	}
	
	@Override
	public String getMessage(){
		return msg;
	}
}
