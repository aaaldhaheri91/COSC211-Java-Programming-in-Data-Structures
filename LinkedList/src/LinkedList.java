import java.util.*;
public class LinkedList {

	
	public class Node{
		private int data;
		private Node link;
		
		public Node(){
			this.data = 0;
			this.link = null;
		}
		
		public Node(int item, Node n){
			this.data = item;
			this.link = n;
		}
	}//end class
	
	
	private Node head;
	
	public LinkedList(){
		this.head = null;
	}
	
	public void addToStart(int item){
		this.head = new Node(item, head);
	}
	
	public boolean deleteHeadNode(){
		if(head != null){
			head = head.link;				//head now is linking to next node, to delete head node
			return true;
		}
		return false;
	}
	
	public int size(){
		int counter = 0;
		Node position = head;			//positin point to head that way we dont lose head
		while(position != null){
			counter++;
			position = position.link;
		}
		return counter;
	}
	
	public boolean isEmpty(){
		return head == null;
	}
	
	public boolean delete(int item){
		Node position = head;
		if(position == null)
			return false;
		while(position.link.data != item)
			position = position.link;
		
		position.link = position.link.link;
		return true;
	}
	
	public boolean find(int item){
		Node position = head;
		while(position != null){
			if(item == position.data)
				return true;
			position = position.link;
		}
		return false;
	}
	
	public int findMax(){
		Node position = head;
		int largest = 0;
		
		while(position != null){
			if(largest < position.data)
				largest = position.data;
			position = position.link;
		}
		return largest;
	}
	
	public void clear(){
		head = null;				//to delete whole list, just delete head link
	}
	
	public void print(){
		Node position = head;
		while(position != null){
			System.out.println(position.data);
			position = position.link;
		}
	}
	
	public void addToEnd(int item){
		Node position = head;
		Node newItem = new Node(item, null);
		
		if(head == null){
			head = newItem;
		}
		
		while(position.link != null){
			position = position.link;
		}
		position.link = newItem;
	}
	
	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);
		LinkedList train = new LinkedList();
		
		System.out.println("Enter first passenger");
		train.addToStart(input.nextInt());
		
		System.out.println("Enter first passenger");
		train.addToStart(input.nextInt());
		
		System.out.println("Enter first passenger");
		train.addToStart(input.nextInt());
		
		System.out.println("Enter first passenger");
		train.addToEnd(input.nextInt());
		
		input.close();
		System.out.println(train.findMax());
		train.print();

	}
	
	
}
