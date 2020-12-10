import java.util.ArrayList;
/**
 * prints the questions in order with my answer 
 * @author Matt
 *
 */
public class QuestionPrinter {
	public static void printQuestions(ArrayList<Question> jsonArraylist) {
		System.out.println("Here are the answers: ");
		int i =0;
		for (Question question : jsonArraylist) {		
			System.out.println((jsonArraylist.get(i)).getAnswer() + "  " + question.getQuestion());	
			i = i + 1;
		}
	}
}
