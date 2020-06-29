package dao;

import java.sql.Date;
import java.util.List;
import beans.Answers;

public interface AnswersDao {
	long addAnswers( String title_questionnaire, Date date,int id_employe);
	List<Answers> getAllAnswers();

	void ajouter( Answers answer );
	public List<Answers> lister();
	public Answers find (int id_answers);
	public List<Answers> lister_nonTraite();
	public List<Answers> getAnswersbyId(int id_employe);
	public List<Integer> getAnswersValue(int id_answers);
	public int FindSameAnswer(int id_answers);
	Answers getAnswer( String title_questionnaire, Date date,int id_employe);

}
