/*
k * Sirepnski Triangle
 */
package projRecursion3_4;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import java.awt.*;
import java.awt.event.*;
public class Driver extends JFrame implements ChangeListener {
	
	//private JComboBox tf = new JComboBox(new Object[] {0,1,2,3,4,5,6,7,8,9,10});
	//private JTextFiled tf = new JTextFiled("0", 5);
	private JSlider tf = new JSlider(JSlider.HORIZONTAL);		//creates horizontal slider
	private SierTriangle pan = new SierTriangle();
	
	public Driver(){
		
		this.getContentPane().add(pan, BorderLayout.CENTER);//PUT it in middle of frame
		
		JPanel orderPan = new JPanel();
		orderPan.add(new JLabel("Enter a level: "));
		orderPan.add(tf);
		/*JPanel panel = new JPanel();
		JPanel centerPan = new JPanel();
		centerPan.setBackground(Color.PINK);
		this.add(centerPan, BorderLayout.CENTER);
		panel.setPreferredSize(new Dimension(100,100));
		//panel.setLayout(new BoxLayout(panel, BoxLayout.PAGE_AXIS));
		this.add(panel, BorderLayout.WEST);
		panel.setBackground(Color.BLUE);*/	//practicing panels
		//tf.addItemListener(this);		//for jcombobox
		tf.setMaximum(10);
		tf.setValue(0);
		tf.setPaintTicks(true);
		tf.setPaintLabels(true);
		tf.setMajorTickSpacing(10);
		tf.addChangeListener(this);		//for slider 
		//tf.setSelectedItem("0");
		tf.setBackground(Color.red);
		tf.setForeground(Color.black);
		//tf.setEditable(false);
		//tf.setHorizontalAlignment(SwingConstants.RIGHT);
		this.getContentPane().add(orderPan, BorderLayout.SOUTH);
		
		this.setPreferredSize(new Dimension(400, 400));
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.pack();
		this.setVisible(true);
		
	}
	
	@Override
	public void stateChanged(ChangeEvent e) {
		//for slider
		pan.setLevel(tf.getValue());
		
	}
	
	/*@Override
	public void itemStateChanged(ItemEvent arg0) {
		pan.setLevel(Integer.parseInt(tf.getSelectedItem().toString())); //for jcomboBox
		
	}*/
	
	public static void main(String[] args) {
		Driver fr = new Driver();
		
	}//end main
	
	private class SierTriangle extends JPanel{
		private int level = 0;
		
		public SierTriangle(){
			/*JTextField text = new JTextField(15);
			this.add(text);*/
			//this.setPreferredSize(new Dimension(150,150));
			
			//this.setBackground(Color.RED);
		}
		public void setLevel(int level){
			this.level = level;
			repaint();
		}
		
		public void paintComponent(Graphics g){
			super.paintComponent(g); //super does paint 
			Point p1 = new Point(this.getWidth() / 2, 10);
			Point p2 = new Point(10, this.getHeight() - 10);
			Point p3 = new Point(this.getWidth() - 10, this.getHeight() - 10);
			
			displayTriangle(g, level, p1, p2, p3);
		}
		
		public Point midPoint(Point point1, Point point2){
			Point temp = new Point();
			temp.x = (point1.x + point2.x) / 2;
			temp.y = (point1.y + point2.y) / 2;
			return temp;
		}
		
		public void displayTriangle(Graphics g, int level, Point p1, Point p2,  Point p3){
			if(level == 0){
				g.drawLine(p1.x, p1.y, p2.x, p2.y);
				g.drawLine(p2.x, p2.y, p3.x, p3.y);
				g.drawLine(p3.x, p3.y, p1.x, p1.y);
			}//end if
			else{
				
				Point p12 = midPoint(p1, p2);
				Point p23 = midPoint(p2, p3);
				Point p31 = midPoint(p3, p1);
				
				displayTriangle(g, level - 1, p1, p12, p31);
				displayTriangle(g, level - 1, p12, p2, p23);
				displayTriangle(g, level - 1, p31, p23, p3);
				
			}
		}
		
	}//end sierTriangle class

}//end class
