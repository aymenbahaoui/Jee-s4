package dao;

import beans.Recommendation;

public interface RecommendationDao {
	public void ajouter( Recommendation recommendation) ;
	public Recommendation findByAnswers (int id_answers);
}
