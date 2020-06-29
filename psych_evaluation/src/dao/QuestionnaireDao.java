package dao;

import beans.Questionnaire;
import java.util.List;;

public interface QuestionnaireDao {
	List<Questionnaire> getAllQuestionnaires();
	Questionnaire getQuestionnaire(String title);
	List<Questionnaire> getUnansweredQuestionnaires(int id_employe);
	void ajouter( Questionnaire questionnaire );
	List<Questionnaire> lister();
	public Questionnaire find (String titre);
	public void delete( String del);
	
}
