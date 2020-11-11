import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import java.io.File;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Random;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;

/**
 * public static int getshape1() {
		return shape1;
	}
	public static void setshape1(int a) {
		shape1 = a;
	}
	public static int getshape2() {
		return shape2;
	}
	public static void setshape2(int a) {
		shape2 = a;
	}
	public static int getshape3() {
		return shape3;
	}
	public static void setshape3(int a) {
		shape3 = a;
	}
	public static int getshape4() {
		return shape4;
	}
	public static void setshape4(int a) {
		shape4 = a;
	}
	
	
	
	
	public static int getshape1() {
		return shape1;
	}
	public static void setshape1(int a) {
		shape1 = a;
	}
	public static void setshape2(int a) {
		shape2 = a;
	}
	public static void setshape3(int a) {
		shape3 = a;
	}
	public static void setshape4(int a) {
		shape4 = a;
	}
 * @author Matt
 *
 */

class Tile extends JPanel{
	static Random rand = new Random();
	private static int rand1 = rand.nextInt(10);
	private static int rand2 = rand.nextInt(10);
	private static int rand3 = rand.nextInt(10);
	private static int rand4 = rand.nextInt(10);
	private static String shapes;
	public static void setRandomly() {	
	    shapes = rand1 + "\t" + rand2 + "\t" + rand3 + "\t" + rand4;
	   // System.out.println(shapes);
		TilePanel.setshapes(shapes);
	 } 
	
	public static String getShapes() {
		
		return rand1 + "\t" + rand2 + "\t" + rand3 + "\t" + rand4;
		
	}
	
	 public String toString() {
			return null;
		 }
	 
}

class TilePanel extends JPanel{ 
	// private int shape1;
	private static String shapes = Tile.getShapes();;
	private static int shape1;
	private static int shape2;
	private static int shape3;
	private static int shape4;
	public static void setshapes(String shapes2) {
		// TODO Auto-generated method stub
		
	}
	

	 public void paintComponent(Graphics g) {	
		 
	    	super.paintComponent(g);
	    	String shape [] = shapes.split("\t");
	    	
	    	//Yellow Circle 0 Square 1
	    	//Green Circle 2 Square 3
	    	//Orange Circle 4 Square 5
	    	//Red Circle 6 Square 7
	    	//Blue CIrcle 8  Square 9
	    System.out.println(shape[0]);
	    if (shape[0].equals("0") ) {
	    		g.setColor(Color.yellow);
	   		    g.fillOval(100, 100, 100, 100);	   		
	   	} else if (shape[0].equals("1") ){
	   		    g.setColor(Color.yellow);
   		        g.fillRect(100, 100, 100, 100);	 
	   	 } else if (shape[0].equals("2") ){
		    g.setColor(Color.green);
	        g.fillOval(100, 100, 100, 100);	 
		 } else if (shape[0].equals("3") ){
		    g.setColor(Color.green);
	        g.fillRect(100, 100, 100, 100);	 
		 } else if (shape[0].equals("4") ){
			    g.setColor(Color.orange);
		        g.fillOval(100, 100, 100, 100);	
		 } else if (shape[0].equals("5") ){
				    g.setColor(Color.orange);
			        g.fillRect(100, 100, 100, 100);	
		 } else if (shape[0].equals("6") ){
			    g.setColor(Color.red);
		        g.fillOval(100, 100, 100, 100);
		 } else if (shape[0].equals("7") ){
			    g.setColor(Color.red);
		        g.fillRect(100, 100, 100, 100);	
	    } else if (shape[0].equals("8") ){
		    g.setColor(Color.blue);
	        g.fillOval(100, 100, 100, 100);
	    } else if (shape[0].equals("9") ){
			    g.setColor(Color.blue);
		        g.fillRect(100, 100, 100, 100);
	      }
	    
	    if (shape[1].equals("0") ) {
    		g.setColor(Color.yellow);
   		    g.fillOval(250, 100, 100, 100);	   		
   	} else if (shape[1].equals("1") ){
   		    g.setColor(Color.yellow);
		        g.fillRect(250, 100, 100, 100);	 
   	 } else if (shape[1].equals("2") ){
	    g.setColor(Color.green);
        g.fillOval(250, 100, 100, 100);	 
	 } else if (shape[1].equals("3") ){
	    g.setColor(Color.green);
        g.fillRect(250, 100, 100, 100);	 
	 } else if (shape[1].equals("4") ){
		    g.setColor(Color.orange);
	        g.fillOval(250, 100, 100, 100);	
	 } else if (shape[1].equals("5") ){
			    g.setColor(Color.orange);
		        g.fillRect(250, 100, 100, 100);	
	 } else if (shape[1].equals("6") ){
		    g.setColor(Color.red);
	        g.fillOval(250, 100, 100, 100);
	 } else if (shape[1].equals("7") ){
		    g.setColor(Color.red);
	        g.fillRect(250, 100, 100, 100);	
    } else if (shape[1].equals("8") ){
	    g.setColor(Color.blue);
        g.fillOval(250, 100, 100, 100);
    } else if (shape[1].equals("9") ){
		    g.setColor(Color.blue);
	        g.fillRect(250, 100, 100, 100);
      }
	   
	    
	    if (shape[2].equals("0") ) {
    		g.setColor(Color.yellow);
   		    g.fillOval(400, 100, 100, 100);	   		
   	} else if (shape[2].equals("1") ){
   		    g.setColor(Color.yellow);
		        g.fillRect(400, 100, 100, 100);	 
   	 } else if (shape[2].equals("2") ){
	    g.setColor(Color.green);
        g.fillOval(400, 100, 100, 100);	 
	 } else if (shape[2].equals("3") ){
	    g.setColor(Color.green);
        g.fillRect(400, 100, 100, 100);	 
	 } else if (shape[2].equals("4") ){
		    g.setColor(Color.orange);
	        g.fillOval(400, 100, 100, 100);	
	 } else if (shape[2].equals("5") ){
			    g.setColor(Color.orange);
		        g.fillRect(400, 100, 100, 100);	
	 } else if (shape[2].equals("6") ){
		    g.setColor(Color.red);
	        g.fillOval(400, 100, 100, 100);
	 } else if (shape[2].equals("7") ){
		    g.setColor(Color.red);
	        g.fillRect(400, 100, 100, 100);	
    } else if (shape[2].equals("8") ){
	    g.setColor(Color.blue);
        g.fillOval(400, 100, 100, 100);
    } else if (shape[2].equals("9") ){
		    g.setColor(Color.blue);
	        g.fillRect(400, 100, 100, 100);
      }
	    
	    if (shape[3].equals("0") ) {
    		g.setColor(Color.yellow);
   		    g.fillOval(550, 100, 100, 100);	   		
   	} else if (shape[3].equals("1") ){
   		    g.setColor(Color.yellow);
		        g.fillRect(550, 100, 100, 100);	 
   	 } else if (shape[3].equals("2") ){
	    g.setColor(Color.green);
        g.fillOval(550, 100, 100, 100);	 
	 } else if (shape[3].equals("3") ){
	    g.setColor(Color.green);
        g.fillRect(550, 100, 100, 100);	 
	 } else if (shape[3].equals("4") ){
		    g.setColor(Color.orange);
	        g.fillOval(550, 100, 100, 100);	
	 } else if (shape[3].equals("5") ){
			    g.setColor(Color.orange);
		        g.fillRect(550, 100, 100, 100);	
	 } else if (shape[3].equals("6") ){
		    g.setColor(Color.red);
	        g.fillOval(550, 100, 100, 100);
	 } else if (shape[3].equals("7") ){
		    g.setColor(Color.red);
	        g.fillRect(550, 100, 100, 100);	
    } else if (shape[3].equals("8") ){
	    g.setColor(Color.blue);
        g.fillOval(550, 100, 100, 100);
    } else if (shape[3].equals("9") ){
		    g.setColor(Color.blue);
	        g.fillRect(550, 100, 100, 100);
      }
	 }

	 
	      
}
/**
 * to get the data from the file my writer made i want to get the line split it at the tabs and past each shapes code to the TilePanel class where then it goes through
 * if statements that will print each of the 4 parts of the line with a number between 0 and 9
 * @author Matt
 *
 */
class TileReader{
Scanner sc = new Scanner(System.in);	
public String readFromText(String fname) {
	File f = new File(fname);
	return readFromText(f);
}
public String readFromText(File f) {
	String line = null;
	while (sc.hasNextLine() == true) {
	
	line = sc.nextLine();
	System.out.println(line);
	}
	return line;
	
}
}

	
	 


class TileWriter{
	public boolean writeToText(String fname,String getShapes) {
		File f = new File(fname);
		return writeToText(f,getShapes);
	}
	public boolean writeToText(File f, String getShapes) {
		try {
			
			PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter(f)));
			pw.println(getShapes);
			pw.close();
			return true;
		} catch (Exception ex) {
			//ex.printStackTrace();
			JOptionPane.showMessageDialog(null, "oops");
			return false;
		}
	}
	
	
	
}
class TileChecker{	
}

class SlotMachineFrame extends JFrame {
	public void setupMenu() {
		JMenuBar mbar = new JMenuBar();
		JMenu FileMenu = new JMenu("File");
		JMenuItem miRestart = new JMenuItem("Restart");	
		JMenuItem miExit = new JMenuItem("Exit");
		JMenuItem miLoad = new JMenuItem("Load Tiles");
		JMenuItem miSave = new JMenuItem("Save Tiles");
		JMenuItem miPrint = new JMenuItem("Print");
		miExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		
		
		
		miLoad.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFileChooser jfc = new JFileChooser();
				if (jfc.showSaveDialog(null) == JFileChooser.APPROVE_OPTION) {
					TileReader tr = new TileReader();
				}
			}
		});
		
		
		
		miSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFileChooser jfc = new JFileChooser();
				TileWriter tw = new TileWriter();
				if (jfc.showSaveDialog(null) == JFileChooser.APPROVE_OPTION) { // the user wants to go ahead
					try {
					if (tw.writeToText(jfc.getSelectedFile(),Tile.getShapes())) {
						JOptionPane.showMessageDialog(null,"Wrote tiles to file.");
					}
					
					} catch (Exception ex) {
						JOptionPane.showMessageDialog(null, "oops could not write tiles to file");
					}
					}
				
			}
		});
		
		FileMenu.add(miRestart);
		miRestart.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "Cleared");
			}
		});
		
			
		
		FileMenu.add(miExit);
		FileMenu.add(miLoad);
		FileMenu.add(miSave);
		FileMenu.add(miPrint);
		mbar.add(FileMenu);
		JMenu mnuHelp = new JMenu("Help");
		JMenuItem miAbout = new JMenuItem("About");
		miAbout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "Matthew Spreitzer https://github.com/BooTheBomb01/Matthew_Spreitzer_cpsc24500");
			}
		});
		mnuHelp.add(miAbout);
		mbar.add(mnuHelp);
		setJMenuBar(mbar);
		
	}
	
	
	public void setupLook() {
		//Random rand = new Random();
		Double dollarAmount = 5.00;
		setBounds(100,100,800,500);	
		setupMenu();
		Container c = getContentPane();
		c.setLayout(new BorderLayout());
		TilePanel panCenter = new TilePanel();
		c.add(panCenter,BorderLayout.CENTER);
		JPanel panSouth = new JPanel();
		
		
		JButton btnMAX= new JButton("MAX");
        panSouth.add(btnMAX);
        
        btnMAX.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {			
				
			}
		});
        
        
        JButton btnMID= new JButton("MID");
        panSouth.add(btnMID);
        
        JButton btnMIN= new JButton("MIN");
        panSouth.add(btnMIN);
        
        JLabel Dorra = new JLabel("$");
        panSouth.add(Dorra);
        JTextField Money = new JTextField(3);
        Money.setText(dollarAmount.toString()); 
        panSouth.add(Money);
        c.add(panSouth,BorderLayout.SOUTH);
        
		
	}
	public SlotMachineFrame() {
		setupLook();
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
}


public class SlotMachineApp {
	public static void main(String[] args) {
		SlotMachineFrame frm = new SlotMachineFrame();
		frm.setVisible(true);
		frm.setLocationRelativeTo(null);
	}

}
