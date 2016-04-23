/*
 * Ahmed Aldhaheri
 * Date: 4/1/2016
 * Course: COSC211, Winter 2016
 * Description: Gets an area of a shape using Shape interface
 */

import java.util.*;
public class ShapeDemo {

	public static void main(String[] args) {
		ArrayList<Shape> arrayShape = new ArrayList<Shape>();
		
		//create objects
		Circle circle1 = new Circle();
		Circle circle2 = new Circle();
		Rectangle rectangle1 = new Rectangle();
		Rectangle rectangle2 = new Rectangle();
		
		//set values
		circle1.setRadius(25);
		circle2.setRadius(10);
		rectangle1.setHeigth(25);
		rectangle1.setWidth(10);
		rectangle2.setHeigth(40);
		rectangle2.setWidth(5);
		
		//add to array
		arrayShape.add(circle1);
		arrayShape.add(circle2);
		arrayShape.add(rectangle1);
		arrayShape.add(rectangle2);
		
		//loop to call display area
		for(Shape arr: arrayShape){
			displayArea(arr);
		}
		
	}//end main
	
	public static void displayArea(Shape s){
		System.out.println("The area of the shape is: " + String.format("%.2f", s.calcArea()));
	}

}//end class

