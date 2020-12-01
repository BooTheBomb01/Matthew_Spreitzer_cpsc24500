import java.awt.Color;
import java.io.Serializable;
import java.util.Random;

public class Tile implements Serializable {
//	private static final Color[] colors = {Color.YELLOW, Color.GREEN, Color.ORANGE, Color.RED, Color.BLUE};
	//private static final String[] colorNames = {"yellow","green","orange","red","blue"};
	//private static final String[] shapes = {"circle","square"};
	private static int color; //0 - yellow, 1 - green, 2 - orange, 3 - red, 4 - blue
	private static int shape; // 0 - circle, 1 - square, 2 - diamond
	public Tile() {
		color = 3;
		shape = 0;
	}
	/**
	 * gets and sets the color for the tilerandomizer class
	 * @return
	 */
	public static int getColor() {
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
	
	/**
	 * gets and sets the shape for tilerandomizer
	 * @return
	 */
	public static int getShape() {
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
	
	@Override
	/**
	 * makes the color and shape into a string for tile randomizer
	 */
	public String toString() {
		return String.format("%d %d",color,shape);
	}
	public int getCode() {
		return color*10+shape;
	}
}
