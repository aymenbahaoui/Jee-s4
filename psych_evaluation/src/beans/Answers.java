package beans;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class Answers {
	private int id_answers;
	private String title_questionnaire;
	private String date;
	private int id_employe;
	private List<Answer> list_answers ;
	public List<Answer> getList_answers() {
		return list_answers;
	}
	public void setList_answers(List<Answer> list_answers) {
		this.list_answers = list_answers;
	}
	public Answers() {
		LocalDateTime myDate = LocalDateTime.now();
	    DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("yyyy-MM-dd");
	    String formattedDate = myDate.format(myFormatObj);
	    date = formattedDate;
	}
	public int getId_answers() {
		return id_answers;
	}
	public void setId_answers(int id_answers) {
		this.id_answers = id_answers;
	}
	public String getTitle_questionnaire() {
		return title_questionnaire;
	}
	public void setTitle_questionnaire(String title_questionnaire) {
		this.title_questionnaire = title_questionnaire;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public int getId_employe() {
		return id_employe;
	}
	public void setId_employe(int id_employe) {
		this.id_employe = id_employe;
	}
	
	
	
}
