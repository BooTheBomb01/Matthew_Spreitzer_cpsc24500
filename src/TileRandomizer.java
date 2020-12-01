import java.awt.Color;
import java.util.ArrayList;
import java.util.Random;
/**
 * 
 * @author Matt
 *This class randomizes the tile at the start of the game and after the button clicks 
 *
 */
public class TileRandomizer  {
	 private Random rnd;
	 private static final Color[] colors = {Color.YELLOW, Color.GREEN, Color.ORANGE, Color.RED, Color.BLUE};
	 private static final String[] colorNames = {"yellow","green","orange","red","blue"};
	 private static final String[] shapes = {"circle","square"};
	 private int color; //0 - yellow, 1 - green, 2 - orange, 3 - red, 4 - blue
	 private int shape; // 0 - circle, 1 - square, 2 - diamond
	 static ArrayList<String> ta = new ArrayList<String>();
	
		

	 	
	 	/**
	 	 * gives the color and shape for the tile
	 	 * @param color
	 	 * @param shape
	 	 */
		public void TileRandomizer(int color, int shape) {
			setColor(color);
			setShape(shape);
		}
		
		public String getShapeAsString() {
			
			return shapes[shape];
		}
		public String toStringFancy() {
			return String.format("%s %s", getColorName(), getShapeAsString());
		}
		/**
		 * sets the tiles randomly and adds them to the arraylist I uses to check my values
		 * @param rnd
		 */
		public void setRandomly(Random rnd) {
			color = rnd.nextInt(colors.length);
			shape = rnd.nextInt(shapes.length);
			String TheTiles = color + " " + shape;

			ta.add(TheTiles);
		}
		/**
		 * get and set for the color
		 * @return
		 */
		public int getColor() {
			return color;
		}
		public void setColor(int color) {
			if (color < 0) {
				this.color = 0;
			} else if (color > 4) {
				this.color = 4;
			} else {
				this.color = color;
			}
		}
		public Color getActualColor() {
			return colors[color];
		}
		public String getColorName() {
			return colorNames[color];
		}
		/**
		 * getter and setter for shape
		 * @return
		 */
		public  int getShape() {
			return shape; 
		}
		public void setShape(int shape) {
			if (shape < 0) {
				this.shape = 0;
			} else if (shape > 1) {
				this.shape = 1;
			} else {
				this.shape = shape;
			}
		}
		/**
		 * sets the color to a random number and the shape to a random shapeto a random number
		 */
	 public void setRandColor() {
		color = rnd.nextInt(4);
	 }
	 public void setRandShape() {
		shape = rnd.nextInt(4);	
	 }
	 /**
	  * I use this for tile checker 
	  * @return
	  */
	 public static ArrayList<String> getta() {
			
			return ta;
		}
	 
}
