/**
 * question class holds my get and set functions so i can work with the users input and json file
 * @author Matt
 *
 */
public class Question {
	String MCQ;
	private String questionLetterA;
	private String questionLetterB;
	private String questionLetterC;
	private String questionLetterD;
	private String answer;
	QuestionReader qr = new QuestionReader();
	/**
	 * question object so I can make it into the arraylist
	 * @param MCQ
	 * @param questionLetterA
	 * @param questionLetterB
	 * @param questionLetterC
	 * @param questionLetterD
	 * @param answer
	 */
	public Question(String MCQ,String questionLetterA,String questionLetterB,String questionLetterC,String questionLetterD, String answer) {
		setQuestion(MCQ);
		setquestionLetterA(questionLetterA);
		setquestionLetterB(questionLetterB);
		setquestionLetterC(questionLetterC);
		setquestionLetterD(questionLetterD);
		setAnswer(answer);
	}
	public String getQuestion() {
		return MCQ;
	}
	public void setQuestion(String MCQ) {
		this.MCQ = qr.MCQ;
	}
	
	public String getquestionLetterA() {
		return questionLetterA;
	}
	public void setquestionLetterA(String questionLetterA) {
		this.questionLetterA = questionLetterA;
	}
	
	public String getquestionLetterB() {
		return questionLetterB;
	}
	public void setquestionLetterB(String questionLetterB) {
		this.questionLetterB = questionLetterB;
	}
	
	public String getquestionLetterC() {
		return questionLetterC;
	}
	public void setquestionLetterC(String questionLetterC) {
		this.questionLetterC = questionLetterC;
	}
	
	public String getquestionLetterD() {
		return questionLetterD;
	}
	public void setquestionLetterD(String questionLetterD) {
		this.questionLetterD = questionLetterD;
	}
	
	public String getAnswer() {
		return answer;
	}
	public void setAnswer(String answer) {
		this.answer = answer;
	}	
	//public String toString() {
		//return  ("%s\n%s\n%s\n%s\n%s\n%s\n%s\n", MCQ,questionLetterA,questionLetterB,questionLetterC,questionLetterD,answer);
	//}
}
