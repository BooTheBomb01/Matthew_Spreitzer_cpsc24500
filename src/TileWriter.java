import java.beans.XMLEncoder;
import java.io.BufferedOutputStream;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
/**
 * this class will write the tiles to files in XML Binary or txt format
 * it sends the data to a different method depending on the file extension the user uses and will write in that file type
 * @author Matt
 *
 */
public class TileWriter {
	public boolean writeToText(String fname, ArrayList<TileRandomizer> tiles) {
		File f = new File(fname);
		return writeToText(f,tiles);  // delegation - lean on another function to do your task
	}

	public boolean writeToText(File f, ArrayList<TileRandomizer> tiles) {
		try {
			PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter(f)));
			for (TileRandomizer tile : tiles) {
				pw.println(tile);
			}
			pw.close();
			return true;
		} catch (Exception ex) {
			return false;
		}
	}
	
	public boolean writeToBinary(String fname, ArrayList<TileRandomizer> tiles) {
		File f = new File(fname);
		return writeToBinary(f,tiles);
	}
	
	public boolean writeToBinary(File f, ArrayList<TileRandomizer> tiles) {
		try {
			ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(f));
			oos.writeObject(tiles);
			oos.close();
			return true;
		} catch (Exception ex) {
			return false;
		}
	}
	
	public boolean write(String fname, ArrayList<TileRandomizer> tiles) {
		File f = new File(fname);
		return write(f,tiles);
	}
	public boolean writeToXML(String fname, ArrayList<TileRandomizer> tiles) {
		File f = new File(fname);
		return writeToXML(f,tiles);
	}
	public boolean writeToXML(File f, ArrayList<TileRandomizer> tiles) {
		try {
			XMLEncoder enc = new XMLEncoder(new 
					BufferedOutputStream(new FileOutputStream(f)));
			enc.writeObject(tiles);
			enc.close();
			return true;
		} catch (Exception ex) {
			return false;
		}
	}
	public boolean write(File f, ArrayList<TileRandomizer> tiles) {
		try {
			String fname = f.getName().toUpperCase();
			if (fname.endsWith(".TXT")) {
				return writeToText(f,tiles);
			} else if (fname.endsWith(".BIN")) {
				return writeToBinary(f,tiles);
			} else if (fname.endsWith(".XML")) {
				return writeToXML(f,tiles);
			} else {
				return false; 
			}
		} catch (Exception ex) {
			return false;
		}
	}
}
