import java.util.ArrayList;
/**
 * this class checks the tiles for matches and updates the usersmoney
 * @author Matt
 *
 */
public class TileChecker {
	static double playerMoney = 5;
	private static int multiplierAll = 100;
	private static int multiplierSome;
	private static double bet;
	private static int var0 = 0;
	private static int var1 = 1;
	private static int var2 = 2;
	private static int var3 = 3;
	private static boolean lost = false;
	/**
	 * uses a arraylist with the tiles and since the new tiles just get appended onto the end I just add 4 to the var0-3 so they get the next batch of numbers, i was not sure how to clear the arraylist in a good way
	 */
	public static void CheckTiles () {	
		ArrayList<String> tile = (TileRandomizer.getta());
		String [] Tile1 = tile.get(var0).split(" ");
		String [] Tile2 = tile.get(var1).split(" ");
		String [] Tile3 = tile.get(var2).split(" ");
		String [] Tile4 = tile.get(var3).split(" ");
		/**
		 * finds out what button the user clicked on so that we can get the all and some times value
		 */
		if (SlotMachineFrame.getDaButooon() == 1) {
			multiplierAll = 100;
			multiplierSome = 25;
			bet = playerMoney;
		} else if (SlotMachineFrame.getDaButooon() == 2) {
			multiplierAll = 50;
			multiplierSome = 10;
			bet = playerMoney/2;
		} else if (SlotMachineFrame.getDaButooon() == 3) {
		    multiplierAll = 10;
		    multiplierSome = 5;
		    bet = playerMoney/10;
		}
			/**
			 * compares the tiles and checks for matches if no match they get their total minus their bet
			 */
			if (tile.get(var0).equals(tile.get(var1)) && tile.get(var0).equals(tile.get(var2)) && tile.get(var0).equals(tile.get(var3))) {	
				playerMoney = playerMoney * multiplierAll;
			} else if (Tile1[0].equals(Tile2[0]) && Tile1[0].equals(Tile2[0]) && Tile1[0].equals(Tile3[0]) && Tile1[0].equals(Tile4[0] )) {
				playerMoney = playerMoney * multiplierSome;
			} else {
			
				playerMoney = playerMoney - bet;
			}	
		checkTotal();
		var0 = var0 + 4;
		var1 = var1 + 4;
		var2 = var2 + 4;
		var3 = var3 + 4;
	}
	/**
	 * returns the money so we can display it on the panel
	 * @return
	 */
 public static double checkTotal() {
	 		if (playerMoney <= 0) {
	 		return 0;

			} 
	 		return playerMoney;
		
 }
	
}
