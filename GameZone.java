import java.util.Random;
import java.util.Scanner;
public class GameZone {
	/** 
	 * this is a simple heading for the game.
	 */
	public static void printHeading() {
		System.out.println("*****************************************");
		System.out.println("*	Welcome to the Game Zone	*");
		System.out.println("*****************************************");
	}
	/**
	 * This function will test the users total and the computers number and see who won
	 * @param Usertotal
	 * @param CompNum
	 */
	public static void twenty1Winner(int Usertotal, int CompNum) {	
		if (Usertotal > CompNum) {
			System.out.println("You win you drew " + Usertotal + " and the computer drew " + CompNum);
		} else if (Usertotal < CompNum) {
			System.out.println("You lose you drew " + Usertotal + " and the computer drew " + CompNum);
		} else {
			System.out.println("Its a tie you drew " + Usertotal + " the computer drew " + CompNum);
		}		
	}
	/**
	 * This will print the choices banner again 
	 */
	public static void printChoices() {
	    System.out.print("1. Twenty-one \n");
	    System.out.print("2. Rock Paper Scissors \n");
	    System.out.print("3. Neither -I'm done! \n");
	}
	/**
	 * Main body which runs the heading banner and menu banner takes in input and starts going to work 
	 * @param args
	 */
	public static void main(String[]args){
	Scanner sc = new Scanner(System.in);
	Random RoShamBo = new Random();
	Random CompRoShamBo = new Random();
	Random UserTwenty1 = new Random();
	Random CompTwenty1 = new Random();
	printHeading();
	int userChoice = 1;
	System.out.print("What would you like to play? \n");
	printChoices();
    System.out.print("Please enter your choice \n");
    userChoice = sc.nextInt();
	do {
	if (userChoice == 1) {//testing the users choice
	int UserNum = UserTwenty1.nextInt(11)+1;
	int  CompNum = CompTwenty1.nextInt((0) + (int) 8)+13; 
	int Usertotal = 0;

	Usertotal = UserNum + Usertotal;
	System.out.println("You drew " + UserNum);
	System.out.println("Do you want to draw another card? (y/n) ");
	char yesorno = sc.next().charAt(0);
	if (yesorno == 'y' || yesorno == 'Y') {
		boolean lose = true;
		do {
		UserNum = UserTwenty1.nextInt(11) + 1;
		System.out.println("You drew " + UserNum);
		Usertotal = UserNum + Usertotal;
		
		if (Usertotal > 21) {			
			System.out.println("You lose you went past 21 with " + Usertotal);
			yesorno = 'n';
			lose = true;
			break;
		} else if (Usertotal == 21) {
			System.out.println("You win you hit 21");
			lose = false;
			break;
		} else {	
		System.out.println("Current total " + Usertotal);
		System.out.println("Do you want to draw another card? (y/n) ");		
	    yesorno = sc.next().charAt(0);
	    lose = false;
		}
		
		} while (yesorno == 'y' ) ;
		if (lose == false) {
			twenty1Winner(Usertotal, CompNum);	
		}
		
	} else if (yesorno == 'n' || yesorno == 'N') {
		twenty1Winner(Usertotal, CompNum);	
	} else {
		System.out.println("Please enter a y or n");
	}
	
	} else if  (userChoice == 2) {//testing the users choice 	
	int RoShamBoNum = RoShamBo.nextInt(3);
	int CompRoShamBoNum = CompRoShamBo.nextInt(3);
	if (RoShamBoNum == CompRoShamBoNum) { //Rock = 1 Paper = 2 Scissor = 3
		if (RoShamBoNum == 1) {
			System.out.println("You both played rock ");
		} else if (RoShamBoNum == 2) {
			System.out.println("you both played paper ");
		} else {
			System.out.println("you both played scissors ");
		}
		System.out.print("Its a tie! \n");
	} else if (RoShamBoNum == 1) { 
		if (CompRoShamBoNum == 2) {
			System.out.println("You lose, you played rock the computer played paper \n");
		} else {
			System.out.println("You win, you played rock the computer played scissors \n");
		}	
	} else if (RoShamBoNum == 2) { 
		if (CompRoShamBoNum == 3) {
			System.out.println("You lose, you played paper the computer played scissors \n");
		} else {
			System.out.println("You win, you played paper the computer played rock \n");
		}
	
	} else if (RoShamBoNum == 3) { 
		if (CompRoShamBoNum == 1) {
			System.out.println("You lose, you played scissors the computer played rock \n");
		} else {
			System.out.println("You win, you played scissors the computer played paper \n");
		}
	}
	} else if  (userChoice == 3) {//testing the users choice 
		System.out.println("Good bye I hope you had fun!!");
		sc.close();
		break;
	} else {
		System.out.println("Please enter 1 2 or 3 for your choice");			
	}
	printChoices();
	System.out.print("What would you like to play? ");
    userChoice = sc.nextInt();
	} while (userChoice == (1) || userChoice == (2) || userChoice == (3));
	}	
	
}
