import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Iterator;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
/**
 * this reads the questions into an arraylist with the object so i can print them and test the user
 * @author Matt
 *
 */
public class QuestionReader  {	
		public static String MCQ,questionLetterA,questionLetterB,questionLetterC,questionLetterD,answer;
		public ArrayList<Question> readFromJSON(String fname) {
			ArrayList<Question> jsonArraylist = new ArrayList<Question>();
			try {
				FileReader reader = new FileReader(new File(fname));
				JSONParser praser = new JSONParser();
				JSONObject all = (JSONObject) praser.parse(reader);
				JSONArray arr = (JSONArray) all.get("questions");
				Iterator itr = arr.iterator();
				JSONObject questionObject;
					while (itr.hasNext()) {
					questionObject = (JSONObject) itr.next();
					MCQ = questionObject.get("question").toString();
					questionLetterA = questionObject.get("a").toString();
					questionLetterB = questionObject.get("b").toString();
					questionLetterC = questionObject.get("c").toString();
					questionLetterD = questionObject.get("d").toString();
					answer = questionObject.get("answer").toString();
					jsonArraylist.add(new Question(MCQ,questionLetterA,questionLetterB,questionLetterC,questionLetterD,answer));
				}	
				reader.close();			
				return jsonArraylist;				
			} catch (Exception ex) {
				return null;			
			}
		}
	}


