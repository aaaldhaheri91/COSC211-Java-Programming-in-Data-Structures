package finalReview;
import javax.swing.*;
import java.awt.*;
public class MyPanel extends JPanel {
	private Color c = null;
	private char shape = ' ';
	JPanel pan = new JPanel();
	public MyPanel(){
		super();
		c = Color.black;
		shape = 'r';
		
	}
	
	public void setColorName(Color x){
		c = x;
	}
	
	public void setShape(char s){
		shape = s;
	}
	
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		g.setColor(c);
		switch(shape){
		case 'o': g.fillOval(50, 50, 75, 75);break;
		case 'r': g.fillRect(50, 50, 75, 100);
		}
		
		
	}
	
}
