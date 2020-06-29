package beans;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.* ;
public class Questionnaire {
	private String title ;
	private int length ;
	private String date_creation ;
	public Questionnaire() {
		LocalDateTime myDate = LocalDateTime.now();
	    DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("yyyy-MM-dd");
	    String formattedDate = myDate.format(myFormatObj);
	    date_creation = formattedDate;
	}
	public String getDate_creation() {
		return date_creation;
	}
	public void setDate_creation(String date_creation) {
		this.date_creation = date_creation;
	}
	private List<Question> questions ;
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public int getLength() {
		return length;
	}
	public void setLength(int lenght) {
		this.length = lenght;
	}
	public List<Question> getQuestions() {
		return questions;
	}
	public void setQuestions(List<Question> questions) {
		this.questions = questions;
	}
	
}
