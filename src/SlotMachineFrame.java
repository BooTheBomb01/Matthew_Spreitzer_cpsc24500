import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Random;

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
/**
 * this is the settings up of the frame and all the buttons,, menu items it needs 
 * @author Matt
 *
 */
public class SlotMachineFrame extends JFrame {
	public static boolean clicked = false;
	
	private TilePanel tpan;
	public static double moolah = 5.00;
	private JTextField txtBalance;
	static int whatDaButoon;
	private JButton btnMax, btnMid, btnMin;
	public void setupMenu() {
		JMenuBar mbar = new JMenuBar();
		JMenu mnuFile = new JMenu("File");
		JMenuItem miLoad = new JMenuItem("Load");
		//JMenuItem miSave = new JMenuItem("Save");
		JMenuItem miPrint = new JMenuItem("Print");
		/**
		 * reenables the buttons and resets the players money
		 */
		JMenuItem miRestart = new JMenuItem("Restart");
		miRestart.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnMin.setEnabled(true);
				btnMax.setEnabled(true);
				btnMid.setEnabled(true);
				TileChecker.playerMoney = 5;
				txtBalance.setText("5.00");
			}
		});
		/**
		 * this closes and ends the program
		 */
		JMenuItem miExit = new JMenuItem("Exit");
		miExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		/**
		 * loads the tiles from files
		 */
		miLoad.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFileChooser jfc = new JFileChooser();
				TileReader tr = new TileReader();
				ArrayList<TileRandomizer> tiles;
				if (jfc.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
					tiles = tr.read(jfc.getSelectedFile());
					if (tiles != null) {
						tpan.setTiles(tiles);
						repaint();
					} else {
						JOptionPane.showMessageDialog(null,"Tiles could not be read.");
					}
				}
			}
		});
		/**
		 * prints the set of tiles to text
		 */
		miPrint.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFileChooser jfc = new JFileChooser();
				TileWriter tw = new TileWriter();
				if (jfc.showSaveDialog(null) == JFileChooser.APPROVE_OPTION) {
					if (tw.write(jfc.getSelectedFile(),TilePanel.getTiles())) {
						JOptionPane.showMessageDialog(null,"Wrote tiles successfully.");
					} else {
						JOptionPane.showMessageDialog(null,"Could not write tiles.");
					}
				}
			}
		});
		mnuFile.add(miLoad);
		mnuFile.add(miPrint);
		mnuFile.add(miPrint);
		mnuFile.add(miRestart);
		mnuFile.add(miExit);
		mbar.add(mnuFile);
		JMenu mnuHelp = new JMenu("Help");
		JMenuItem miAbout = new JMenuItem("About");
		/**
		 * displays some information about the writier and their github link for the code 
		 */
		miAbout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "Vegas Baby Vegas by Matt Spreitzer.\nCode at https://github.com/BooTheBomb01/Matthew_Spreitzer_cpsc24500");
			}
		});
		mnuHelp.add(miAbout);
		mbar.add(mnuHelp);
		setJMenuBar(mbar);
	}
	public double getMoolah() {
		return moolah;
	}
	/**
	 * This sets up the frame and works with the button click events 
	 */
	public void setupLook() {
		setBounds(100,100,750,300);
		setTitle("Vegas Baby Vegas Slot Machine");
		Container c = getContentPane();
		c.setLayout(new BorderLayout());
		JPanel panSouth = new JPanel();
		panSouth.setLayout(new FlowLayout());
		btnMax = new JButton("Max");
		/**
		 * randomizes the tiles and checks for matches 
		 */
		btnMax.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TileChecker tc = new TileChecker();
				whatDaButoon = 1;
				TileChecker.CheckTiles();
				TilePanel tp = new TilePanel();
				if (TileChecker.checkTotal() == 0) {
					btnMin.setEnabled(false);
					btnMax.setEnabled(false);
					btnMid.setEnabled(false);
				}
			txtBalance.setText(String.format("%.2f", TileChecker.checkTotal()));
			repaint();
			}
		});
		/**
		 * randomizes the tiles and checks for matches 
		 */
		btnMid = new JButton("Mid");
		btnMid.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TileChecker tc = new TileChecker();
				whatDaButoon = 2;
				TileChecker.CheckTiles();
				TilePanel tp = new TilePanel();
				txtBalance.setText(String.format("%.2f", TileChecker.checkTotal()));
				repaint();
				if (TileChecker.checkTotal() == 0) {
					btnMin.setEnabled(false);
					btnMax.setEnabled(false);
					btnMid.setEnabled(false);
				}
			}		
		});
		/**
		 * randomizes the tiles and checks for matches 
		 */
		btnMin = new JButton("Min");
		btnMin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TileChecker tc = new TileChecker();
				whatDaButoon = 3;
				TileChecker.CheckTiles();
				TilePanel tp = new TilePanel();
					
				//txtBalance.setText(Double.toString(TileChecker.checkTotal()));
				txtBalance.setText(String.format("%.2f", TileChecker.checkTotal()));
				repaint();
				if (TileChecker.checkTotal() == 0) {
					btnMin.setEnabled(false);
					btnMax.setEnabled(false);
					btnMid.setEnabled(false);
				}
			}
		});
		/**
		 * adds the balance and the moneyh label
		 */
		panSouth.add(btnMax);
		panSouth.add(btnMid);
		panSouth.add(btnMin);
		c.add(panSouth,BorderLayout.SOUTH);
		tpan = new TilePanel();
		c.add(tpan,BorderLayout.CENTER);
		JLabel lblBalance = new JLabel("$");
		panSouth.add(lblBalance);
		txtBalance = new JTextField(6);
		txtBalance.setEditable(false);
		txtBalance.setText("5.00");
		panSouth.add(txtBalance);
		setupMenu();
	}
	public static int getDaButooon() {
		return whatDaButoon;
	}
	public SlotMachineFrame() {
		setupLook();
	}
	
}
