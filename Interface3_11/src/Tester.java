/*
 * Ahmed Aldhaheri
 * Interfaces
 * 3-11-2016
 * Notes:
 * Interface: is a class like contains only constants methods and abstract method.
 * Abstract class: cannot make an instance of it.
 */
public class Tester {

	public static void main(String[] args) {
		
		Cat whisker = new Cat();
		Apple apple = new Apple();
		
		//Object temp = new Cat();	//you can create cat Object because cat is a child of a father class Object
		Object[] temp = {new Cat(), new Apple()};
		
		System.out.println("The sound is " + whisker.makeSound());
		System.out.println("To eat an apple " + apple.howToEat());
		System.out.println("To eat a cat: " + whisker.howToEat());
		
		//temp[0] = ((Cat)temp[0]);
		//System.out.println(((Cat)temp[0]).makeSound());
		
		for(int i = 0; i < temp.length; ++i){
			if(temp[i] instanceof Animal)
				System.out.println(((Animal)temp[i]).makeSound());
			if(temp[i] instanceof Edible)
				System.out.println(((Edible) temp[i]).howToEat());
		}
	}
	

}
