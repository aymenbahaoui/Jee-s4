package daoImpl;
import dao.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


import beans.*;

public class RecommendationDaoImpl implements RecommendationDao {
	 private DaoFactory daoFactory;

	   public RecommendationDaoImpl(DaoFactory daoFactory) {
	        this.daoFactory = daoFactory;
	   }


	    public void ajouter( Recommendation recommendation) {
	        Connection connexion = null;
	        PreparedStatement preparedStatement = null;

	        try {
	            connexion = daoFactory.getConnection();
	            preparedStatement = connexion.prepareStatement("INSERT INTO Recommendation (id_answers, content) VALUES(?, ?);");
	            preparedStatement.setInt(1, recommendation.getId_answers());
	            preparedStatement.setString(2, recommendation.getContent());
	            preparedStatement.executeUpdate();
	          
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }

	    }
	    
	    public Recommendation findByAnswers (int id_answers) {
	        Recommendation recommendation = new Recommendation();
	        Connection connexion = null;
	        Statement statement = null;
	        ResultSet resultat = null;
	      
	        try {
	            connexion = daoFactory.getConnection();
	            statement = connexion.createStatement();
	            resultat = statement.executeQuery("SELECT * FROM recommendation where id_answers = '"+id_answers+"';");
	            statement = connexion.createStatement();
	            while(resultat.next()) {
		            String content = resultat.getString("content");
		            int id_recommendation  = resultat.getInt("id_recommendation");
		            recommendation.setId_answers(id_answers);
		            recommendation.setContent(content);
	                recommendation.setId_recommendation(id_recommendation);
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	        return recommendation;
	    }

}
