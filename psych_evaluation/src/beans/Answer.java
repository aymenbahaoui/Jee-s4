package beans;

public class Answer {
	private int id_answer;
	private int id_answers;	
	private int id_question;
	private String question_content;
	public String getQuestion_content() {
		return question_content;
	}
	public void setQuestion_content(String question_content) {
		this.question_content = question_content;
	}
	private boolean value;
	
	public int getId_answer() {
		return id_answer;
	}
	public void setId_answer(int id_answer) {
		this.id_answer = id_answer;
	}
	public int getId_answers() {
		return id_answers;
	}
	public void setId_answers(int id_answers) {
		this.id_answers = id_answers;
	}
	public int getId_question() {
		return id_question;
	}
	public void setId_question(int id_question) {
		this.id_question = id_question;
	}
	public boolean isValue() {
		return value;
	}
	public void setValue(boolean value) {
		this.value = value;
	}
	
	
	
	
}
