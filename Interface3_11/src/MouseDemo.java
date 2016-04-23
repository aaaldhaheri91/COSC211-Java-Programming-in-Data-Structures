import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class MouseDemo extends JFrame {

	private MyPanel pan = null;
	
	public MouseDemo(){
		pan = new MyPanel();
		this.getContentPane().add(pan);
		this.setTitle("Demo");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(300, 300);
		this.setVisible(true);
		this.setLocationRelativeTo(null); //puts frame in the middle of screen
		
	}//end constructor
	
	public static void main(String[] args) {
		
		MouseDemo fr = new MouseDemo();
		
	}//end main
	
	//create class
	static class MyPanel extends JPanel implements 
							MouseListener, MouseMotionListener, KeyListener{
		
		private int x,y,x2,y2;
		private int shape = 0;
		private Color c = Color.BLACK;
		
		public MyPanel(){
			this.addMouseListener(this);
			this.addMouseMotionListener(this);
			this.addKeyListener(this);
			this.setFocusable(true);
			this.setBackground(Color.CYAN);
		}
		public void paintComponent(Graphics g){
			super.paintComponent(g);
			g.
			g.setColor(c);
			if(shape == 1)
				g.fillOval(x, y, 30, 30);
			else if(shape == 2)
				g.drawLine(x, y, x2, y2);
			
		}
		
		//start abstract methods mouse listener
		@Override
		public void mouseDragged(MouseEvent event) {
			shape = 2;
			c = Color.GREEN;
			x2 = event.getX();
			y2 = event.getY();
			
			repaint();
		}

		@Override
		public void mouseMoved(MouseEvent event) {
			
		}

		@Override
		public void mouseClicked(MouseEvent event) {
			shape = 1;
			x = event.getX();
			y = event.getY();
			repaint();
		}

		@Override
		public void mouseEntered(MouseEvent event) {
			setBackground(Color.RED);
		}

		@Override
		public void mouseExited(MouseEvent event) {
			setBackground(Color.YELLOW);
		}

		@Override
		public void mousePressed(MouseEvent event) {
			shape = 2;
			x = event.getX();
			y = event.getY();
		}

		@Override
		public void mouseReleased(MouseEvent event) {
			x2 = event.getX();
			y2 = event.getY();
			repaint();
		}
		
		//start keyboard listener
		@Override
		public void keyPressed(KeyEvent event) {
			shape = 1;
			switch(event.getKeyCode()){
			case KeyEvent.VK_DOWN: y += 10; break;
			case KeyEvent.VK_UP: y -= 10; break;
			case KeyEvent.VK_RIGHT: x += 10; break;
			case KeyEvent.VK_LEFT: x -= 10; break;
			case KeyEvent.VK_B: c = Color.BLUE; break;
			}
			repaint();
		}
		@Override
		public void keyReleased(KeyEvent event) {
			
			
		}
		@Override
		public void keyTyped(KeyEvent event) {
			
			
		}
	}//end panel class
	
}//end class
