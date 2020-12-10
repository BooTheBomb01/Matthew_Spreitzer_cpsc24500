import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;
public class QuizApp {
	public static int howMuchQuestion;
	/**
	 * This program reads a Json file that contains questions and answers and my asnwer and gets user input for what they want to do then either quizzes them or shows them what I put
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println("*  What could possibly be more fun than this?  *");
		System.out.println("************************************************");
		System.out.println("* 	OOP Theory and Concept Questions       *");
		System.out.println("************************************************");
		System.out.println("*  Nothing. Nothing at all. Nope. Nada. Nunca. *");
		ArrayList<Question> jsonArraylist = new ArrayList<Question>();
		Scanner sc = new Scanner(System.in);
		QuestionReader qr = new QuestionReader();
		QuestionPrinter qp = new QuestionPrinter();
		Quizzer quiz = new Quizzer();
		System.out.print("Enter the name of the file: ");//E:\Java\QuizApp\src\questions_without_answers.json
		String mrJson = sc.nextLine();
		
		int userInput = 1;
		jsonArraylist = qr.readFromJSON(mrJson);
		if (jsonArraylist == null) {
			System.out.println("Couldn't read articles.");
			System.exit(0);
		} 
		/**
		 * testing user input and having it loop till they want to quit 
		 */
		while (userInput != 3){
			System.out.println("Here are your choices: ");
			System.out.println("1. Take a quiz. ");
			System.out.println("2. See questions and answers");
			System.out.println("3. Exit");
			System.out.println("Enter the number of your choice: ");
		    userInput = sc.nextInt();
		    
		    
		if (userInput == 1) {
			System.out.println("How many questions? ");
			howMuchQuestion = sc.nextInt();
			Quizzer.printQuestions(jsonArraylist);
			
		} else if (userInput == 2){
			QuestionPrinter.printQuestions(jsonArraylist);
		} else if (userInput == 3) {
			System.out.println("************************************************");
			System.out.println("       Thank you for taking CPSC 24500 ");
			System.out.println("************************************************");
			System.exit(0);
		}	
		}		
	}
}

