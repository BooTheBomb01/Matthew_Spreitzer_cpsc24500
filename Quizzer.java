import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;
/**
 * quizzer quizzes the user by asking random questions and comparing their input to my input and telling them how many they got right after they finish 
 * @author Matt
 *
 */
public class Quizzer {	
	public static void printQuestions(ArrayList<Question> jsonArraylist) {
		Random rand = new Random();
		int total = 0;
		Scanner sc = new Scanner(System.in);
		int howMuchSuffering = QuizApp.howMuchQuestion;
		for (int i = 0; i < howMuchSuffering; i++) {
			int randQuestion = rand.nextInt(18);
			System.out.println(jsonArraylist.get(randQuestion).getQuestion());
			String theQuestion = jsonArraylist.get(randQuestion).getAnswer();
			System.out.println("A: " + jsonArraylist.get(randQuestion).getquestionLetterA());
			System.out.println("B: " + jsonArraylist.get(randQuestion).getquestionLetterB());
			System.out.println("C: " + jsonArraylist.get(randQuestion).getquestionLetterC());
			System.out.println("D: " + jsonArraylist.get(randQuestion).getquestionLetterD());
			System.out.println("Type the letter of your choice (non-case sensitive): ");
			String userAnswer = sc.nextLine();
		//	System.out.println();
			if (userAnswer.toLowerCase().equals(theQuestion)) {;//Question.getAnswer())) {
				System.out.println("Correct nice one!");
				total = total + 1;
			} else if (userAnswer.toLowerCase().equals(theQuestion) == false){
				System.out.println("Incorrect the answer is " + theQuestion);
			}
			System.out.println();
		}
		System.out.println("you answered " + total + " correct out of " + howMuchSuffering + " questions asked.");
	}
}
