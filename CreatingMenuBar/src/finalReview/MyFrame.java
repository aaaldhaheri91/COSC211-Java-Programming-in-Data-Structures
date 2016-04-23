package finalReview;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
public class MyFrame extends JFrame implements ActionListener {
	
	private MyPanel pan = null;
	private JMenuBar bar = null;
	private JMenu mnuFile = null, mnuColor = null;
	private JMenu mnuColorBack = null, mnuColorFore = null;
	private JMenuItem exitItem = null;
	private JMenuItem redItem = null, greenItem = null,
			yellowItem = null, blueItem = null,
			bOrange = null, fOrange = null; // one for background and foregrund
	private JMenuItem saveAsItem = null, colorItem = null;
	
	public MyFrame(){
		super();
		pan = new MyPanel();
		bar = new JMenuBar();
		mnuFile = new JMenu("File");
		
		mnuColor = new JMenu("Color");
		mnuColorBack = new JMenu("Background");
		mnuColorFore = new JMenu("Forground");
		
		saveAsItem = new JMenuItem("SaveAs...");
		saveAsItem.addActionListener(this);
		
		colorItem = new JMenuItem("color...");
		colorItem.addActionListener(this);
		
		//menu items are created
		KeyStroke stroke = KeyStroke.getKeyStroke(KeyEvent.VK_X, Toolkit.getDefaultToolkit().getMenuShortcutKeyMask());
		exitItem = new JMenuItem("Exit");
		exitItem.addActionListener(this);
		//exitItem.setMnemonic('x');	//when you click x it exist, key shortcut to exit
		exitItem.setAccelerator(stroke);
		
		stroke = KeyStroke.getKeyStroke(KeyEvent.VK_R, Toolkit.getDefaultToolkit().getMenuShortcutKeyMask());
		redItem = new JMenuItem("Red");
		redItem.addActionListener(this);
		redItem.setAccelerator(stroke);
		greenItem = new JMenuItem("Green");
		greenItem.addActionListener(this);
		greenItem.setToolTipText("will set background to green");//tooltip
		
		yellowItem = new JMenuItem("Yellow");
		yellowItem.addActionListener(this);
		
		blueItem = new JMenuItem("Blue");
		blueItem.addActionListener(this);
		
		bOrange = new JMenuItem("Orange");
		bOrange.addActionListener(this);
		bOrange.setEnabled(false);
		
		fOrange = new JMenuItem("orange");
		fOrange.addActionListener(this);
		
		//add backwords, take items add to menu
		//add menu to bar, add bar to fram
		
		
		mnuFile.add(saveAsItem);
		mnuFile.add(colorItem);
		mnuFile.addSeparator();
		mnuFile.add(exitItem);
		
		mnuColor.add(mnuColorBack);
		mnuColor.add(mnuColorFore);
		
		mnuColorBack.add(redItem);
		mnuColorBack.add(greenItem);
		mnuColorBack.addSeparator();
		mnuColorBack.add(bOrange);
		
		mnuColorFore.add(blueItem);
		mnuColorFore.add(yellowItem);
		mnuColorFore.add(fOrange);
		
		bar.add(mnuFile);
		bar.add(mnuColor);
		
		this.add(pan);
		this.setJMenuBar(bar);
		this.setSize(300, 300);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setVisible(true); // always the last thing
		
		
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		
		String cmd = e.getActionCommand();
		
		switch(cmd){
		case "Exit": System.exit(0);break;
		case "SaveAs...":  
			JFileChooser fileChooser = new JFileChooser();
			fileChooser.showSaveDialog(null);
			break;
		case "color...": 
			Color c = JColorChooser.showDialog(null,"choose a color", Color.CYAN);
			pan.setColorName(c);
			pan.repaint();
			break;
		case "Red": pan.setBackground(Color.RED);break;
		case "Green": pan.setBackground(Color.GREEN);break;
		case "Blue": pan.setColorName(Color.BLUE);
			pan.repaint();
			pan.setShape('r');
			break;
		case "Yellow": pan.setColorName(Color.YELLOW);
			pan.setShape('o');
			pan.repaint();
			break;
		case "Orange": pan.setBackground(Color.ORANGE);break;
		case "orange": pan.setColorName(Color.ORANGE);
			pan.repaint();
			pan.repaint();
			break;
		default: break;
		}
	}
}
	