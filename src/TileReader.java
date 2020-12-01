import java.beans.XMLDecoder;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.Scanner;
/**
 * this class reads the file and works similarly to the TileWriter where it checks for the file extension and will then read in that file type and updtae the tiles on the panel
 * @author Matt
 *
 */
public class TileReader {
	public ArrayList<TileRandomizer> readFromText(String fname) {
		File f = new File(fname);
		return readFromText(f);
	}
	public ArrayList<TileRandomizer> readFromText(File f) {
		try {
			ArrayList<TileRandomizer> tilesRead = new ArrayList<TileRandomizer>();
			Scanner fsc = new Scanner(f);
			String line;
			String[] parts;
			int color, shape;
			//TileRandomizer tile;
			while (fsc.hasNextLine()) {
				line = fsc.nextLine();
				parts = line.split(" ");
				color = Integer.parseInt(parts[0]);
				shape = Integer.parseInt(parts[1]);
				//System.out.println(color);
				TileRandomizer tile = new TileRandomizer();
				tilesRead.add(tile);
			}
			fsc.close();
			return tilesRead;
		} catch (Exception ex) {
			return null;  
						  
		}
	}

	
	public ArrayList<TileRandomizer> readFromBinary(String fname) {
		File f = new File(fname);
		return readFromBinary(f);
	}
	public ArrayList<TileRandomizer> readFromBinary(File f) {
		try {
			ArrayList<TileRandomizer> tilesRead;
			ObjectInputStream ois = new ObjectInputStream(new FileInputStream(f));
			tilesRead = (ArrayList<TileRandomizer>)ois.readObject();
			ois.close();
			return tilesRead;
		} catch (Exception ex) {
			return null;
		}
	}
	public ArrayList<TileRandomizer> readFromXML(String fname) {
		File f = new File(fname);
		return readFromXML(f);
	}
	public ArrayList<TileRandomizer> readFromXML(File f) {
		try {
			ArrayList<TileRandomizer> tilesRead;
			XMLDecoder dec = new XMLDecoder(
					new BufferedInputStream(new FileInputStream(f)));
			tilesRead = (ArrayList<TileRandomizer>)dec.readObject();
			dec.close();
			return tilesRead;
		} catch (Exception ex) {
			return null;
		}
	}
	public ArrayList<TileRandomizer> read(String fname) {
		File f = new File(fname);
		return read(f);
	}
	public ArrayList<TileRandomizer> read(File f) {
		try {
			String fname = f.getName().toUpperCase();
			if (fname.endsWith(".TXT")) {
				return readFromText(f);
			} else if (fname.endsWith(".BIN")) {
				return readFromBinary(f);
			} else if (fname.endsWith(".XML")) {
				return readFromXML(f);
			} else {
				return null;  
			}
		} catch (Exception ex) {
			return null;
		}
	}
}
