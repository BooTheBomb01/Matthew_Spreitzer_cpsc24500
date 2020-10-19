/**
 * Matthew Spreitzer this program reads a file containing countries and deaths and will print them for the user
 */
import java.io.File;
import java.util.LinkedHashMap;
import java.util.Scanner;
import javax.swing.JFrame;
import org.math.plot.Plot2DPanel;
import org.math.plot.plotObjects.BaseLabel;
import java.awt.Container;
import java.awt.BorderLayout;
import java.awt.Color;

public class CovidPlotter {
	
	/**
	 * 
	 * @param fsc
	 * @return
	 * this reads all the data in a linked hashmap we can use for printing
	 */
	public static LinkedHashMap<String,double[]> readData(Scanner fsc, boolean daily){
		LinkedHashMap<String,double[]> result = new LinkedHashMap<String,double[]>();
		fsc.hasNextLine(); 
		String country; 
		String line; 
		double dailyDeaths;
		String [] parts;
		double [] values; 
		while (fsc.hasNextLine()) {
			line = fsc.nextLine();
			parts = line.split("\t");
			
			country = parts[0];
			if (daily == false) {
			values = new double[parts.length-1];
			
			for (int i = 1; i < parts.length; i++) {
				values[i-1] = Double.parseDouble(parts[i]);
				
			}
			
			result.put(country,values);
		}else {			
			values = new double[parts.length-1];			
			for (int i = 1; i < parts.length; i++) {				
				values[i-1] = Double.parseDouble(parts[i]);				
			}			
			result.put(country,values);
		}
		} 
		return result;
	}
	 public static double [] getDay(int days) {
		 double[] result = new double[days];
		 for (int i = 0; i < days; i++) {
			 result[i] = i;
		 }
		 return result;
	 }

	 
	 	 
	 public static void main(String[] args) {
		 System.out.println("*******************************************************");
		 System.out.println("*	INTERNATIONAL COVID-19 MORTALITY RATES        *");
		 System.out.println("*******************************************************");
		 LinkedHashMap<String,double[]>countriesDead;
		 String userCountries = null;
		 String userChoice;
		 String[] countrynames;
		 boolean daily = false; // it would be better to use the other one since we dont start out daily but i dont like spelling it.
		 Scanner sc = new Scanner(System.in);
		 double [] countryValues;
		 //D:\Fall.2020\OOP\countries_deaths.txt
		 System.out.println("Enter the name of the file: ");
		 String ronaFile = sc.nextLine();//String fname = "D:\\Fall.2020\\OOP\\countries_deaths.txt"; 
		 do {
			 System.out.print("Enter the names of countries separated by commas: (quit to stop)  ");
			 userCountries = sc.nextLine();
			 if (userCountries.equalsIgnoreCase("quit")) {
				 break;
			 }
			 System.out.println("[D]aily or [C]ulmulative deaths: case is non-sensitive ");
			 userChoice = sc.nextLine(); 
			 userChoice = userChoice.toUpperCase();
			 if (userChoice.equals("C") || userChoice.equals("D")) {//gets the user choices and does some case management for them along with making sure it wont crash the program if they decide not to play nice
				 if (userChoice.contentEquals("C")) {
					 daily = false;
				 } else {
					 daily = true;
				 }
			 } else {
				 System.out.println("Please enter a D or a C");
			 }
		 try {
			 Scanner fsc = new Scanner(new File(ronaFile));
			 countriesDead = readData(fsc,daily);
		 } catch (Exception ex) {
			 countriesDead = null;
		 }// if this is empty then something went wrong and we will try again 
		 if (countriesDead == null) {
			 System.out.println("Couldn't read the file please try again. ");
		 } else {
			
			 
			 boolean nooDontPrinnttttt = false;
				 if (userCountries.equalsIgnoreCase("quit") == false) {
					 Plot2DPanel plot = new Plot2DPanel();
					 
					 countrynames = userCountries.split(",");
					 for (String cntyName : countrynames) {
						 cntyName = cntyName.trim(); 
						 if (countriesDead.containsKey(cntyName) == false) {
							 System.out.println("the name " + cntyName + " is not present in the data ");
							 nooDontPrinnttttt = true;
						 }else {
							 nooDontPrinnttttt = false;
							 countryValues = countriesDead.get(cntyName);
							 
							 
							 plot.addLinePlot(cntyName, getDay(countryValues.length), countryValues);
						 }
					 }
					 if (nooDontPrinnttttt == false) {//Since i dont want to show an empty plot 
					 JFrame Frame = new JFrame();
					 Frame.setBounds(100,100,500,500);
					 if (daily == false) {
					 BaseLabel title = new BaseLabel("Culumulative",Color.red,0.5,1.1,1);
					 plot.addPlotable(title);
					 } else {
					 BaseLabel title = new BaseLabel("Daily",Color.red,0.5,1.1,1);
					 plot.addPlotable(title);
					 }
					 
					 Frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE); 
					 Container c = Frame.getContentPane();
					 c.setLayout(new BorderLayout());
					 plot.addLegend("SOUTH");
					 plot.setAxisLabels("Day","Deaths");
					 c.add(plot, BorderLayout.CENTER);
					 Frame.setVisible(true);
					 }
				 }
			 
			 
		 }
		 } while (userCountries.equalsIgnoreCase("quit") == false);
		 System.out.println("Stay safe and wear a mask out there! ");
		 sc.close();
	 }
}