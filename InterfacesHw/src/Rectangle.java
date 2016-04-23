
public class Rectangle implements Shape{
	private int height;
	private int width;
	
	//constuctor
	public Rectangle(){
		this.height = 1;
		this.width = 1;
	}
	
	//set methods
	public void setHeigth(int height){
		this.height = height;
	}
	
	public void setWidth(int width){
		this.width = width;
	}
	
	//get methods
	public int getHeight(){
		return height;
	}
	
	public int getWidth(){
		return width;
	}
	
	@Override
	public double calcArea() {
		return width * height;
	}
}
