import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.JPanel;
/**
 * this displays the tiles and also checkes for if the user clicked on the tile and will change it
 * @author Matt
 *
 */
public class TilePanel extends JPanel implements MouseListener {
	private static ArrayList<TileRandomizer> tiles;
	private Random rnd;
	
	public void mouseEntered(MouseEvent e) {}
	public void mouseExited(MouseEvent e) {}
	public void mousePressed(MouseEvent e) {}
	public void mouseReleased(MouseEvent e) {}
	public void mouseClicked(MouseEvent e) {
		int whichTile = e.getX()/(this.getWidth()/4);
		TileRandomizer tile = tiles.get(whichTile);
		tile.setRandomly(rnd);
		repaint();
	}
	/**
	 * makes an arraylist for the tilepanel
	 */
	public TilePanel() {
		tiles = new ArrayList<TileRandomizer>();
		TileRandomizer tile;
		rnd = new Random();
		for (int i = 0; i < 4; i++) {
			tile = new TileRandomizer();
			tile.setRandomly(rnd);
			tiles.add(tile);
			
		
		}
		addMouseListener(this);
	}
	/**
	 * get and set for the tiles arraylist
	 * @return
	 */
	public static ArrayList<TileRandomizer> getTiles() {
		return tiles;
	}
	public static TileRandomizer returnTiles() {
		return tiles.get(1);
	}
	public void setTiles(ArrayList<TileRandomizer> tiles) {
		this.tiles = tiles;
	}
	/**
	 * paints the tiles to the screen 
	 */
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		int cellWidth = this.getWidth() / 4;
		int tileSize = 4*cellWidth/5;
		int shape;
		Color color;
		TileRandomizer tile;
		/**
		 * prints the tiles from the arraylist
		 */
		for (int i = 0; i < tiles.size(); i++) {
			
			tile = tiles.get(i);
			shape = tile.getShape();
			color = tile.getActualColor();
			g.setColor(color);/////
			
			if (shape == 0) {
				g.fillOval(i*cellWidth + cellWidth/10, cellWidth/10, tileSize, tileSize); 
			} else if (shape == 1) {
				g.fillRect(i*cellWidth + cellWidth/10, cellWidth/10, tileSize, tileSize);
			} 
			
		}
	}
}

