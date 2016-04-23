/*
 * Author: Ahmed Aldhaheri
 * Course: COSC211, Winter 2016
 * Date: 2/12/2016
 * Description: Roman calculator app that performs operations based on Roman notation
 */
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class RomanCalculator extends JFrame implements ActionListener, FocusListener {
	
	//set Roman class instance
	Roman romanObject = new Roman();
	String text = "";		//variable to save text
	int num1 = 0, num2 = 0, total = 0;
	
	//instance of textfield objects
	JTextField roman1 = new JTextField(15);
	JTextField roman2 = new JTextField(15);
	JTextField result = new JTextField(15);
	JTextField previouslyFocusedTextBox = roman1;
	
	//instance of labels
	JLabel integer1 = new JLabel("Integer1");
	JLabel integer2 = new JLabel("Integer2");
	JLabel integer3 = new JLabel("Integer3");
	
	//instance of button objects
	JButton buttonI = new JButton("I");
	JButton buttonV = new JButton("V");
	JButton buttonX = new JButton("X");
	JButton buttonL = new JButton("L");
	JButton buttonC = new JButton("C");
	JButton buttonD = new JButton("D");
	JButton buttonM = new JButton("M");
	JButton buttonCE = new JButton("CE");
	JButton minus = new JButton("-");
	JButton addition = new JButton("+");
	JButton divison = new JButton("/");
	JButton modulous = new JButton("%");
	JButton multiplication = new JButton("*");
	JButton equal = new JButton("=");
	
	public RomanCalculator(){
		//start design of interface
		super("Roman Calculator");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(355, 335);
		
		setResizable(false);
		setLayout(new FlowLayout(FlowLayout.LEADING));
		setLocationRelativeTo(null);
		setVisible(true);
		Dimension size = new Dimension(80, 50);
		Dimension size2 = new Dimension(160, 20);
		
		//set both fields focusable and add action listener
        roman1.setFocusable(true);		//set focusable to save where focus was
        roman1.addFocusListener(this);

        roman2.setFocusable(true);
        roman2.addFocusListener(this);
		
        //set result not editable and background wo white
        result.setEditable(false);
        result.setBackground(Color.white);
        //result.setText("Integer1");
        //set label background to white, and size
        integer1.setOpaque(true);
        integer1.setPreferredSize(size2);
		integer1.setBackground(Color.white);
		
        integer2.setOpaque(true);
        integer2.setPreferredSize(size2);
		integer2.setBackground(Color.white);
		
		integer3.setOpaque(true);
		integer3.setPreferredSize(size2);
        integer3.setBackground(Color.white);
        
        //add textfields and labels
		add(roman1);
		add(integer1);
		add(roman2);
		add(integer2);
		add(result);
		add(integer3);
		
		//add buttons frame
		add(buttonI).setPreferredSize(size); 
		add(buttonV).setPreferredSize(size);
		add(buttonX).setPreferredSize(size);
		add(buttonL).setPreferredSize(size);
		add(buttonC).setPreferredSize(size);
		add(buttonD).setPreferredSize(size);
		add(buttonM).setPreferredSize(size);
		add(buttonCE).setPreferredSize(size);
		add(minus).setPreferredSize(size);
		add(addition).setPreferredSize(size);
		add(divison).setPreferredSize(size);
		add(modulous).setPreferredSize(size);
		add(multiplication).setPreferredSize(size);
		add(equal).setPreferredSize(size);
		
		//set default text as result in result text field
		result.setText("Result");
		
		//add action listeners
		buttonI.addActionListener(this);
		buttonV.addActionListener(this);
		buttonX.addActionListener(this);
		buttonL.addActionListener(this);
		buttonC.addActionListener(this);
		buttonD.addActionListener(this);
		buttonM.addActionListener(this);
		buttonCE.addActionListener(this);
		minus.addActionListener(this);
		addition.addActionListener(this);
		divison.addActionListener(this);
		modulous.addActionListener(this);
		multiplication.addActionListener(this);
		equal.addActionListener(this);
		
	}//end constructor
	
	public static void main(String[] args) {
		
		Roman obj = new Roman();
		RomanCalculator frame = new RomanCalculator();
			
		
			
	}//end main

	@Override
	public void actionPerformed(ActionEvent event) {
		
		Object source = event.getSource();
		
		//check
		if(source == buttonI)
			text = "I";
		else if(source == buttonV)
			text = "V";
		else if(source == buttonX)
			text = "X";
		else if(source == buttonL)
			text = "L";
		else if(source == buttonC)
			text = "C";
		else if(source == buttonD)
			text = "D";
		else if(source == buttonM)
			text = "M";
		
		//check last focus to add text 
		if(previouslyFocusedTextBox.equals(roman1)){
			roman1.setText(roman1.getText() + text);
			text = "";
		}
		else if(previouslyFocusedTextBox.equals(roman2)){
			roman2.setText(roman2.getText() + text); 
			text = "";
		}
		
		//if clear button
		if(source == buttonCE){
			//clear all text fields and labels
			reset();
		}
		
		//check what operator button clicked
		else if(source == minus)
			operation("subtraction");
		else if(source == addition)
			operation("addition");
		else if(source == divison)
			operation("divison");
		else if(source == modulous)
			operation("modulous");
		else if(source == multiplication)
			operation("multiplication");
		else if(source == equal)
			result();
	}//end actionPerformed

	@Override
	public void focusGained(FocusEvent event) {
		//set last focus to previouslyFocusedTextBox instance
		if(event.getSource() instanceof JTextField) 
            previouslyFocusedTextBox = (JTextField) event.getSource();
	}
	
	@Override
	public void focusLost(FocusEvent arg0) {
		//have to override every method in interface but dont need this one
		
	}
	
	public void reset(){
		//resets values when clear button is clicked
		roman1.setText("");
		roman2.setText("");
		result.setText("result");
		integer1.setText("Integer1");
		integer2.setText("Integer2");
		integer3.setText("Integer3");
		num1 = 0;
		num2 = 0;
		total = 0;
		text = "";
	}
	
	public void operation(String oper){
		
		num1 = romanObject.convertRomanToInt(roman1.getText());
		integer1.setText(String.valueOf(num1));
		num2 = romanObject.convertRomanToInt(roman2.getText());
		num2 = num2 - num1;
		integer2.setText(String.valueOf(num2));
		
		//check for operation
		if(oper.equals("addition"))
			total = num1 + num2;
		else if(oper.equals("subtraction"))
			total = num1 - num2;
		else if(oper.equals("multiplication"))
			total = num1 * num2;
		else if(oper.equals("divison"))
			total = num1 / num2;
		else if(oper.equals("modulous"))
			total = num1 % num2;

	}
	
	public void result(){
		//outputs result on equal sign click
		
		integer3.setText(String.valueOf(total));
		romanObject.convertIntToRoman(total);
		
		text = romanObject.getRoman();
		result.setText(text);
		
	}
	
}//end class
