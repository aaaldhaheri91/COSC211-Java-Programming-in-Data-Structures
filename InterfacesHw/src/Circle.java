
public class Circle implements Shape {
	private int radius;
	
	//default constructor
	public Circle(){
		this.radius = 1;
	}
	
	//set metod
	public void setRadius(int radius){
		this.radius = radius;
	}
	
	//get method
	public int getRadius(){
		return radius;
	}
	
	@Override
	public double calcArea() {
		
		return Math.PI * Math.pow(radius, 2);
	}

}
