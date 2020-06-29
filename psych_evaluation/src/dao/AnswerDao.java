package dao;

import java.util.List;

import beans.Answer;
import beans.Answers;

public interface AnswerDao {
	List<Answer> getAnswerByAnswers(int id_answers);
	boolean addAnswer(int id_answers,int id_question, int value);
	
	
}
