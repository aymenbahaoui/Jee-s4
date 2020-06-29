package beans;

public class Question {
	private int id_question;
	private String questionnaire_title;
	private String content;
	public int getId_question() {
		return id_question;
	}
	public void setId_question(int id_question) {
		this.id_question = id_question;
	}
	public String getQuestionnaire_title() {
		return questionnaire_title;
	}
	public void setQuestionnaire_title(String questionnaire_title) {
		this.questionnaire_title = questionnaire_title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	
	
}
