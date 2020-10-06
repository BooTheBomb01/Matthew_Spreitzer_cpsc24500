/**
 *@author matthew spreitzer.
 *This program reads a tab delimated file of current 
 *baseball standings and prints them 
 *
 */
import java.util.Scanner;
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map.Entry;
import java.util.NavigableMap;
import java.util.NavigableSet;
import java.util.TreeMap;
public class BaseballStandings {
	/**
	 * calculates winning percent of each team. :0
	 * @param win
	 * @param lose
	 * @return
	 * 
	 */
	 static float Calcwinningpercent (String win, String lose) {
		float winPercent = Float.parseFloat(win)/(Float.parseFloat(lose)+Float.parseFloat(win));
		return winPercent;
	}
	 /**
		 * prints the header all nice and pretty like :D
		 * 
		 */
	public static void Printheading(){
		System.out.println("*********************************");
		System.out.println("* BASEBALL STANDINGS ANALYZER 	*");
		System.out.println("*********************************");
	}
	/**
	 * prints the league header all nice and pretty like :D
	 * 
	 */
	public static void PrintLeagues() {
		System.out.println("What Standings would you like to see?");
		System.out.println("1. AL East");
		System.out.println("2. AL Central");
		System.out.println("3. AL West");
		System.out.println("4. NL East");
		System.out.println("5. NL Central");
		System.out.println("6. NL West");
		System.out.println("7. Overall");
		System.out.println("8. Exit");		
	}
	/**
	 * gets the average so we can insert the teams in order from least to most bad :)
	 * @param line
	 * @return
	 */
	public static float getAvg (String line) {
		String stripper [] = line.split("\t");
		float pct = ((Float.parseFloat(stripper[1])/(Float.parseFloat(stripper[2])+Float.parseFloat(stripper[1])))); 
		
		
		return pct;
	}
	/**
	 * inserts the teams from least to most bad :)
	 * @param teams
	 * @param line
	 */
	public static void insertByAverage(ArrayList<String> teams, String line) {		
		float thisPct = getAvg(line);
		float otherPct;
		int pos = -1;
		for (int i = 0; i < teams.size(); i++) {
			otherPct = getAvg(teams.get(i));
			if (thisPct > otherPct) {
				pos = i;
				break;
			}
		}
		if (pos < 0) {
			teams.add(line);
		} else {
			teams.add(pos,line);
		}
	}
	public static void main(String[]args){
			try {
				Printheading();	
				System.out.println("");
			Scanner sc = new Scanner(System.in);
			//D://baseball_standings_windows.txt
			System.out.println("This program reads a file that contains \ncurrent baseball standings and adds to \nmore detailed statistics. It also prints \noverall standings in the American and \nnational leagues.");
			System.out.println("");
			System.out.println ( "Enter the name of the standings file ");
			String filename = sc.nextLine();
			String line;
			int userChoice;
			PrintLeagues();
			System.out.println("Enter the number of your choice ");
			userChoice = sc.nextInt();
					
			do {
		
					
				
				String startLeagueat = null;			
				if (userChoice == 1) {
					 startLeagueat = "League	AL East";										 
				} else if (userChoice == 2) {
					 startLeagueat = "League	AL Central";										 
				} else if (userChoice == 3) {
					 startLeagueat = "League	AL West";					 					 
				} else if (userChoice == 4) {
					 startLeagueat = "League	NL East";					 					 
				} else if (userChoice == 5) {
					 startLeagueat = "League	NL Central";										 
				} else if (userChoice == 6) {
					 startLeagueat = "League	NL West";
				}	
				
			
			Scanner fsc = new Scanner(new File(filename));
			
				
			if (userChoice == 7) {
				System.out.println("Team		 Wins  Losses");
				System.out.println("*****************************");
				ArrayList<String> teams = new ArrayList<String>();
				
				while (fsc.hasNextLine()) {					
					line = fsc.nextLine().trim();
					String[] parts= line.split("	");
					
					if (parts[0].contentEquals("League")) {						
						continue;
					} else {	
						
						insertByAverage(teams, line);
						
						}
 						
					}
					for (int x = 0; x < teams.size(); x++) {
						String [] printDaStuffAllNiceAndPurdy = (teams.get(x)).split("\t");
						//printDaStuffAllNiceAndPurdy 
						System.out.printf("%-13s %5s %5s \n",printDaStuffAllNiceAndPurdy[0],printDaStuffAllNiceAndPurdy[1],printDaStuffAllNiceAndPurdy[2] );
					}
					

			} else {
			System.out.println("Team 		Wins  Losses Pct.   Behind");
			System.out.println("------------------------------------------");
			while (fsc.hasNextLine()) {
				line = fsc.nextLine().trim();
				if (line.contentEquals(startLeagueat)) {
					float gamesBackNumOneTeam = 0;
					float gamesBackCurTeam = 0;
					for(int i= 1; i <= 5; i++) {					
						line = fsc.nextLine().trim();
						String[] parts= line.split("	");
						if (i == 1) {
						  gamesBackNumOneTeam = Float.parseFloat(parts[1]) - Float.parseFloat(parts[2]);						  
						} 						
						gamesBackCurTeam = Float.parseFloat(parts[1])-Float.parseFloat(parts[2]);
						String win = parts[1];
						String lose = parts[2];
						float gamesBack = (gamesBackNumOneTeam- gamesBackCurTeam)/2;
						if (i == 1) {
							System.out.printf("%-13s %4s %5s %9.3f  \n" , parts[0] , parts[1] , parts[2], Calcwinningpercent(win , lose));
						} else {
						System.out.printf("%-13s %4s %5s %9.3f %5.1f \n" , parts[0] , parts[1] , parts[2], Calcwinningpercent(win , lose),gamesBack);
						}
					}
				} else {			
					continue;
				}								
			}
			}	
			fsc.close();
			System.out.println("Enter the number of your choice ");
			userChoice = sc.nextInt();	
			
			} while (userChoice == 1 ||userChoice == 2 ||userChoice == 3 ||userChoice == 4 ||userChoice == 5 ||userChoice == 6 ||userChoice == 7 );
			sc.close();
			} catch (Exception ex) {
				
				System.out.println("Something happened.");
				}	
			
			System.out.println("Thanks for using my program!");
			}
			
}
