import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JOptionPane;
import java.awt.Graphics;
/**
 * 
 * @author Matt
 *This creates the Panel the pumpkin will be drawn on
 *also functions so we can pass the paint component data
 */
class pumpkinPanel extends JPanel {
	private int pLft;
	private int pTop;
	private int pWidth;
	private int pHeight;

	private String pNose;
	private String pEyes;
	private String pMouth;
	public void setPumpkinLft(int r) {
		pLft = r;
		
	}
	public int getPumpkinLft() {
		return pLft;
	}
	public void setPumpkinTop(int a) {
		pTop = a;
	}
	public int getPumpkinTop() {
		return pTop;
	}
	public void setPumpkinWidth(int t) {
		pWidth = t;
	}
	public int getPumpkinWidth() {
		return pWidth;
	}
	public void setPumpkinHeight(int s) {
		pHeight = s;
	}
	public int getPumpkinHeight() {
		return pHeight;
	}
	public void setPumpkinMouth(String s) {
		pMouth = s.toUpperCase();
	}
	public String getPumpkinMouth() {
		return pMouth;
	}
	public void setPumpkinEye(String s) {
		pEyes = s.toUpperCase();
	}
	public String getPumpkineye() {
		return pEyes;
	}
	public void setPumpkinNose(String s) {
		pNose = s.toUpperCase();
	}
	public String getPumpkinNose() {
		return pNose;
	}
	public pumpkinPanel() {
		pLft = 200;
		pTop = 100;
		pWidth = 100;
 		pHeight = 100;
 		pEyes = "C";
 		pMouth = "O";
 		pNose = "S";
	}
	/**
	 * This will pain the pumpkin and repaint when the user enters data and clicks draw
	 */
	@Override
	 public void paintComponent(Graphics g) {
    	super.paintComponent(g);
    	
    	
    	
    	g.setColor(Color.orange);
    	g.fillOval(pLft, pTop, pWidth, pHeight);
    	
    	
    	
    	//Eyes and does error handling
    	if (pEyes.contentEquals("C")) {
    	g.setColor(Color.white);
    	g.fillOval((int) (pLft+pLft*.3), (int) (pTop+pTop *.2), (int) (pWidth-pWidth *.9), (int) (pHeight-pHeight *.9));
    	g.setColor(Color.white);
    	g.fillOval((int) (pLft+pLft*.1), (int) (pTop+pTop *.2), (int) (pWidth-pWidth *.9), (int) (pHeight-pHeight *.9));
    	} else if (pEyes.contentEquals("S")) {
    		g.setColor(Color.white);
    		g.fillRect((int) (pLft+pLft*.3), (int) (pTop+pTop *.2), (int) (pWidth-pWidth *.9), (int) (pHeight-pHeight *.9));
        	g.setColor(Color.white);
        	g.fillRect((int) (pLft+pLft*.1), (int) (pTop+pTop *.2), (int) (pWidth-pWidth *.9), (int) (pHeight-pHeight *.9));	
    	} else if (pEyes.contentEquals("T")) {
    		int[] eye1TriangleEyesx = {pLft+17,pLft+27,pLft+37};
        	int[] eye1TriangleEyesy = {pTop+33,pTop+13,pTop+33};
      
        	int[] eye2TriangleEyesx = {pLft+57,pLft+67,pLft+77};
        	int[] eye2TriangleEyesy = {pTop+33,pTop+13,pTop+33};
        	g.setColor(Color.white);
    		g.fillPolygon(eye1TriangleEyesx, eye1TriangleEyesy, 3);
    		g.fillPolygon(eye2TriangleEyesx, eye2TriangleEyesy, 3);
    		
    	} else {
    		JOptionPane.showMessageDialog(null,"Please enter a C S T");
    	}
    	
    	//used to draw the nose and does some error handling
    	if (pNose.contentEquals("S")) {
    	g.setColor(Color.white);
    	g.fillRect((int) (pLft+pLft *.2), (int) (pTop+pTop *.45), (int) (pWidth-pWidth *.9), (int) (pHeight-pHeight *.9));
    	} else if (pNose.contentEquals("C")) {
    	g.setColor(Color.white);
        g.fillOval((int) (pLft+pLft *.2), (int) (pTop+pTop *.45), (int) (pWidth-pWidth *.9), (int) (pHeight-pHeight *.9));
    	} else if (pNose.contentEquals("T")) {
    	int[] noseTriangleEyesx = {pLft+37,pLft+47,pLft+57};
        int[] noseTriangleEyesy = {pTop+53,pTop+33,pTop+53};
        g.fillPolygon(noseTriangleEyesx, noseTriangleEyesy, 3);
    	} else {
    		JOptionPane.showMessageDialog(null,"Please enter a C S T");
    	}
    	//used to draw the mouth and does some error handling	
    	if (pMouth.contentEquals("O")) {
    	g.setColor(Color.white);
    	g.fillOval((int) (pLft+pLft*.15), (int) (pTop+pTop *.7), (int) (pWidth-pWidth *.6), (int) (pHeight-pHeight *.8));
    	} else if (pMouth.contentEquals("R")) { 
    	g.setColor(Color.white);
    	g.fillRect((int) (pLft+pLft*.15), (int) (pTop+pTop *.7), (int) (pWidth-pWidth *.6), (int) (pHeight-pHeight *.8));
    	} else {
    		JOptionPane.showMessageDialog(null,"Please enter a O R");
    	}
    	
    	
    	g.setColor(Color.white);
    	g.fillRect((int) (pLft+pLft*.22), (int) (pTop-pTop *.1), (int) (pWidth-pWidth *.9), (int) (pHeight-pHeight *.9));
    }
}
/**
 * Sets up the frame and the panels inside the frame
 * @author Matt
 *
 */
class PumpkinFrame extends JFrame {
		public void setUpFrame() {
			setTitle("Pumpkin");
			setDefaultCloseOperation(EXIT_ON_CLOSE);
			setBounds(100,100,800,480);
			Container c = getContentPane();
			c.setLayout(new BorderLayout());
			pumpkinPanel panCenter = new pumpkinPanel();
			c.add(panCenter,BorderLayout.CENTER);
			JPanel panSouth = new JPanel();
			c.add(panSouth,BorderLayout.SOUTH);
			panSouth.setLayout(new FlowLayout());
			
			panSouth.add(new JLabel("Left: "));
	    	JTextField textLeft = new JTextField(3);
	    	panSouth.add(textLeft);
	    	
	    	panSouth.add(new JLabel("Top: "));
	    	JTextField textTop = new JTextField(3);
	    	panSouth.add(textTop);
	    	
	    	panSouth.add(new JLabel("Width: "));
	    	JTextField textWidth = new JTextField(3);
	    	panSouth.add(textWidth);
	    	
	    	panSouth.add(new JLabel("Height: "));
	    	JTextField textHeight = new JTextField(3);
	    	panSouth.add(textHeight);
	    	
	    	panSouth.add(new JLabel("Eye (C S T) "));
	    	JTextField textOjos = new JTextField(1);
	    	panSouth.add(textOjos);
	    	
	    	panSouth.add(new JLabel("Nose (C S T) "));
	    	JTextField textNose = new JTextField(1);
	    	panSouth.add(textNose);
	    	
	    	panSouth.add(new JLabel("Mouth (O R) "));
	    	JTextField textMouth = new JTextField(1);
	    	panSouth.add(textMouth);
	    	

	    	JButton btnChange= new JButton("DRAW");
	        panSouth.add(btnChange);
	        
	        btnChange.addActionListener(new ActionListener() {
	        	

				public void actionPerformed(ActionEvent e) {//handles the button click action event 
					try {
	        		//panCenter.setPumpkinLft(Integer.parseInt(textLeft.getText()));
					int pLft = (Integer.parseInt(textLeft.getText()));
	        		int pTop = Integer.parseInt(textTop.getText());
	        		int pWidth = Integer.parseInt(textWidth.getText());
	        		int pHeight = Integer.parseInt(textHeight.getText());
	        		String pOjos = textOjos.getText();
	        		String pNose = textNose.getText();
	        		String pMouth = textMouth.getText();
	        		panCenter.setPumpkinLft(pLft);
	        		panCenter.setPumpkinTop(pTop);
	        		panCenter.setPumpkinWidth(pWidth);
	        		panCenter.setPumpkinHeight(pHeight);
	        		panCenter.setPumpkinEye(pOjos);
	        		panCenter.setPumpkinMouth(pMouth);
	        		panCenter.setPumpkinNose(pNose);
	        		
	        		repaint();
	        		//JOptionPane.showMessageDialog(null,pTop + ", " + pWidth + ", " + pHeight + ", " + pOjos + ", " + pNose + ", " + pMouth);
					} 
					catch (Exception ex){
						JOptionPane.showMessageDialog(null,"Please enter an integer in the first 4 boxes and characters in the last 3");
					}
	        		
	        		
	        	}
	        });
		}
		public PumpkinFrame() {
			setUpFrame();
			setDefaultCloseOperation(EXIT_ON_CLOSE);
			
		}
	}
/**
 * 
 * @author Matt
 *sets the frame to be visible and centered on the screen
 */
public class PumpkinDrawer {
	public static void main(String[] args ) {
		PumpkinFrame Frame = new PumpkinFrame();
		Frame.setVisible(true);
		Frame.setLocationRelativeTo(null);//centers the frame on the users screen
	}
}

