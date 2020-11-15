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
import java.beans.XMLDecoder;
import java.beans.XMLEncoder;

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
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;

/**
 * tile holds my shape values such as 0 is a yellow circle to 9 which is a bluesquare
 * @author Matt
 *also handles passing of data around for my load and write functions 
 *also has some constructors
 */
class Tile{
	static Random rand = new Random();
	private static int rand1 = rand.nextInt(10);
	private static int rand2 = rand.nextInt(10);
	private static int rand3 = rand.nextInt(10);
	private static int rand4 = rand.nextInt(10);
	private static String shapes;
	public static String loadedShapes;
	private static int count = 0;
	private static String getShapes = String.valueOf(rand1) + "\t" + String.valueOf(rand2) + "\t" + String.valueOf(rand3) + "\t" +String.valueOf(rand4);	
	public static String getRandomly() {
		//if (count == 0) {
			//JOptionPane.showMessageDialog(null, "yay");
		return String.valueOf(rand1) + "\t" + String.valueOf(rand2) + "\t" + String.valueOf(rand3) + "\t" +String.valueOf(rand4);	
		//} //else {
		//return getShapes(shapes);
		//}
	}
	public static String getShapes() {
		
		return loadedShapes;	
	}
	public static void setShapes(String shapes) {
		 System.out.println(shapes);
		String loadedShapes = 	shapes;
		count = 1;
	}
public static int getCount() {
		return count = 0;	
	}
	 public static String tostring() {
		 String shapes = String.valueOf(rand1) + "\t" + String.valueOf(rand2) + "\t" + String.valueOf(rand3) + "\t" +String.valueOf(rand4);	;
		 return shapes;
		 }	
	 
		public void Tilexy() {
			int x;
			int y;
		}
		public void Tilexy(int x,int y) {
			setX(x);
			setY(y);
		}
		public static void setY(int y) {
			
			
		}
		public static void setX(int x) {
			
			
		}
	}
/**
 * this displays the shapes with the given number from Tile and this also will handle changing a tile on mouse click 	 
 * @author Matt
 *
 */
class TilePanel extends JPanel implements MouseListener, MouseMotionListener{  
	public int loadRandTile = 0;
	private String mouseStatus;
	public int whatTile = 0;
	public int newTilex;
	public int stopAfter1;
	public TilePanel() {
		addMouseListener(this);
		addMouseMotionListener(this);
	}
	//addMouseMotionListener(this);
	public void randTile(Graphics g) {
		
    	    	Random rand = new Random();
    	    	int randomnum = rand.nextInt(10);
    	 if (randomnum == 0) {
    	 	} else if (randomnum == 1){
	   		   // String Color = yellow;
   		       // g.fillRect(newTilex, 100, 100, 100);	 
	   	 } else if (randomnum == 2){
		    g.setColor(Color.green);
	        g.fillOval(newTilex, 100, 100, 100);	 
		 } else if (randomnum == 3){
		    g.setColor(Color.green);
	        g.fillRect(newTilex, 100, 100, 100);	 
		 } else if (randomnum == 4){
			    g.setColor(Color.orange);
		        g.fillOval(newTilex, 100, 100, 100);	
		 } else if (randomnum == 5){
				    g.setColor(Color.orange);
			        g.fillRect(newTilex, 100, 100, 100);	
		 } else if (randomnum == 6){
			    g.setColor(Color.red);
		        g.fillOval(newTilex, 100, 100, 100);
		 } else if (randomnum == 7){
			    g.setColor(Color.red);
		        g.fillRect(newTilex, 100, 100, 100);	
	    } else if (randomnum == 8){
		    g.setColor(Color.blue);
	        g.fillOval(newTilex, 100, 100, 100);
	    } else if (randomnum == 9){
			    g.setColor(Color.blue);
		        g.fillRect(newTilex, 100, 100, 100);
	      }   		
    	    
	    	}
		
	
    @Override
    /**
     * this paints my JPanel and also handles mouse click events
     */
	 public void paintComponent(Graphics g) {	
    	    String shapes = Tile.getRandomly();
    	    String shape [] = shapes.split("\t");
    	    if (Tile.getCount() == 1) {
    	    	 shape = Tile.getShapes().split("\t");
    	    	 JOptionPane.showMessageDialog(null,shape);
    	    }
    	    if (loadRandTile == 1) {
    	    	shape[0] = Integer.toString(10);
    	    } else if (loadRandTile == 2) {
    	    	shape[1] = Integer.toString(10);
    	    }else if (loadRandTile == 2) {
    	    	shape[2] = Integer.toString(10);
    	    }else if (loadRandTile == 3) {
    	    	shape[3] = Integer.toString(10);
    	    }
	    	super.paintComponent(g);
	    
	    	
	    	//addMouseListener(this);
	    	
	   
	    	
	    	//String shape [] = Tile.getShapes().split("\t");
	    	// setloadTile(shapes);
	    	//Yellow Circle 0 Square 1
	    	//Green Circle 2 Square 3
	    	//Orange Circle 4 Square 5
	    	//Red Circle 6 Square 7
	    	//Blue CIrcle 8  Square 9
	  
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
	   } else if (shape[0].equals("10")) {
		   randTile(g);
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
	    repaint();
	 }

	/**
	 * all the methods needed for the mouse click
	 * @return
	 */
    public String getMouseStatus() {
		return mouseStatus;
	}
	public void setMouseStatus(String ms) {
		mouseStatus = ms;
	}
	public void mouseEntered(MouseEvent e) { 
		mouseStatus = "Entered the window.";
		repaint();
	}
	public void mouseExited(MouseEvent e) {
		mouseStatus = "Exited the window.";
		repaint();
	}
	public void mousePressed(MouseEvent e) {
		mouseStatus = String.format("Mouse pressed at (%d, %d)", e.getX(), e.getY());
		repaint();
	}
	public void mouseReleased(MouseEvent e) {
		mouseStatus = String.format("Mouse released at (%d, %d)", e.getX(), e.getY());
		repaint();
	}
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		mouseStatus = String.format("Mouse clicked at (%d, %d)", e.getX(), e.getY());
		if ((e.getX() >= 50 && e.getX() <= 150) && (e.getY() >= 50 && e.getY() <= 150)) {
			loadRandTile=1;
			whatTile = 0;
			newTilex = 100;
			//stopAfter1 = 1;
		} 		
		if ((e.getX() >= 200 && e.getX() <= 300) && (e.getY() >= 50 && e.getY() <= 150)) {
			loadRandTile=1;
			whatTile = 1;
			newTilex = 250;
		}		
		if ((e.getX() >= 350 && e.getX() <= 450) && (e.getY() >= 50 && e.getY() <= 150)) {
			loadRandTile=1;
			whatTile = 2;
			newTilex = 400;
		}		
		if ((e.getX() >= 500 && e.getX() <= 600) && (e.getY() >= 50 && e.getY() <= 150)) {
			loadRandTile=1;
			whatTile = 3;
			newTilex = 550;
		}	
		
		repaint();
	}
	
	public void mouseMoved(MouseEvent e) { 
		mouseStatus = String.format("Mouse moved at (%d, %d)", e.getX(), e.getY());
		repaint();
		
	}
	public void mouseDragged(MouseEvent e) { 
		mouseStatus = String.format("Mouse dragged at (%d, %d)", e.getX(), e.getY());
		repaint();
	}




	
	 
	      
}
/**
 * this is my reading class which reads files ending in txt xml or bin and sends the data to the Tile class
 * @author Matt
 *
 */
class TileReader{
public String readFromText(File f) {
	try {
	String line = null;	
	Scanner sc = new Scanner(f);
	while (sc.hasNextLine()) {
	line = sc.nextLine();
	//System.out.println(line);
	//JOptionPane.showMessageDialog(null, "yay");
	}
		sc.close();
		return line;
	} catch (Exception ex) {
		//ex.printStackTrace();
		JOptionPane.showMessageDialog(null, "oops");
		return null;
	}
	
}
public String readFromBinary(String fname) {
	File f = new File(fname);
	return readFromBinary(f);
}
public String readFromBinary(File f) {
	try {
		String getShapes;
		ObjectInputStream ois = new ObjectInputStream(new FileInputStream(f));
		getShapes = (String)ois.readObject();
		ois.close();
		return getShapes;
	} catch (Exception ex) {
		return null;
	}
}
public String readFromXML(String fname) {
	File f = new File(fname);
	return readFromXML(f);
}
public String readFromXML(File f) {
	try {
		String getShapes;
		XMLDecoder dec = new XMLDecoder(
				new BufferedInputStream(new FileInputStream(f)));
		getShapes = (String)dec.readObject();
		dec.close();
		return getShapes;
	} catch (Exception ex) {
		return null;
	}
}
public String read(String fname) {
	File f = new File(fname);
	return read(f);
}
public String read(File f) {
	String fname = f.getName().toUpperCase();
	if (fname.endsWith(".TXT")) {
		
		return readFromText(f);
		
	}
	
	if (fname.endsWith(".BIN")) {
		return readFromBinary(f);
	}
	if (fname.endsWith(".XML")) {
		return readFromXML(f);
	}
	return null;  
	
}
}

/**
 * to get the data from the file my writer made i want to get the line split it at the tabs and past each shapes code to the TilePanel class where then it goes through
 * if statements that will print each of the 4 parts of the line with a number between 0 and 9
 * @author Matt
 *
 */	
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
	
	public boolean writeToBinary(String fname,String getShapes) {
		File f = new File(fname);
		return writeToBinary(f,getShapes);
	}
	public boolean writeToBinary(File f, String getShapes) {
		try {
			ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(f));
			oos.writeObject(getShapes);
			oos.close();
			return true; // success
		} catch (Exception ex) {
			return false;
		}
	}
	public boolean writeToXML(String fname, String getShapes) {
		File f = new File(fname);
		return writeToXML(f,getShapes);
	}
	public boolean writeToXML(File f, String getShapes) {
		try {
			XMLEncoder enc = new XMLEncoder(new 
					BufferedOutputStream(new FileOutputStream(f)));
			enc.writeObject(getShapes);
			enc.close();			
			return true;
		} catch (Exception ex) {
			return false;
		}
	}	
	public boolean write(String fname, String getShapes) {
		File f = new File(fname);
		return write(f,getShapes);
	}
	public boolean write(File f, String getShapes) {
		String fname = f.getName().toUpperCase();
		if (fname.endsWith(".TXT")) {
			return writeToText(f, getShapes);
		}
		if (fname.endsWith(".BIN")) {
			return writeToBinary(f,getShapes);
		}
		if (fname.endsWith(".XML")) {
			return writeToXML(f,getShapes);
		}
		return false;  // invalid or unrecognized file type
	}
}




/**
 * checks tiles for the game logic - not in use yet
 * @author Matt
 *
 */
class TileChecker{	
}
/**
 * this sets up the jframes menus and everything else that might be necessary for it like the buttons Jtextfields
 * @author Matt
 *
 */
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
		
		
		/**
		 * runs the TileReader class and sends data to TIle
		 */
		miLoad.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFileChooser jfc = new JFileChooser();
				TileReader tr = new TileReader();
				if (jfc.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {					
					String shapes  = tr.read(jfc.getSelectedFile());
					   if (shapes == null) { 					   
							JOptionPane.showMessageDialog(null,"Could not read dots from file.");
						} else {						
							JOptionPane.showMessageDialog(null,shapes);
							Tile.setShapes(shapes);
							repaint();
					}
				}
			}
		});
		
		
		/**
		 * runs when the save meue item is clicked 
		 */
		miSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFileChooser jfc = new JFileChooser();
				TileWriter tw = new TileWriter();
				if (jfc.showSaveDialog(null) == JFileChooser.APPROVE_OPTION) { // the user wants to go ahead
					try {
						//System.out.println(Tile.getGetShapes());
					if (tw.write(jfc.getSelectedFile(),Tile.tostring())) {
						JOptionPane.showMessageDialog(null,"Wrote tiles to file.");
					}
					
					} catch (Exception ex) {
						JOptionPane.showMessageDialog(null, "oops could not write tiles to file");
					}
					}
				
			}
		});
		/**
		 * runs when restart is clicked and resets the users score and randomizes the tiles 
		 */
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
	
	/**
	 * Sets up the frame
	 */
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
	/**
	 * runs the set up look and sets the close operation
	 */
	public SlotMachineFrame() {
		setupLook();
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
}

/**
 * Displays the slot machine frame and also centers it to the screen
 *
 */
public class SlotMachineApp {
	public static void main(String[] args) {
		SlotMachineFrame frm = new SlotMachineFrame();
		frm.setVisible(true);
		
		frm.setLocationRelativeTo(null);
	}

}
