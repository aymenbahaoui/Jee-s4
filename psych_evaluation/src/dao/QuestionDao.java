package dao;

import java.util.List;

import beans.Question;

public interface QuestionDao {
	boolean addQuestion( String questionnaire_title, String content);
	List<Question> getQuestionsByQuestionnaire(String questionnaire_title);
	
}
