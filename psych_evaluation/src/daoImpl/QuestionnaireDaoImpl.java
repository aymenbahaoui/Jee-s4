package daoImpl;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import beans.Question;
import beans.Questionnaire;
import dao.DaoFactory;


public class QuestionnaireDaoImpl implements dao.QuestionnaireDao {
	 private DaoFactory daoFactory;
	 public QuestionnaireDaoImpl() {
	        super();
	   }
	   public QuestionnaireDaoImpl(DaoFactory daoFactory) {
	        this.daoFactory = daoFactory;
	   }

	    @Override
	    public void ajouter( Questionnaire questionnaire) {
	        Connection connexion = null;
	        PreparedStatement preparedStatement = null;

	        try {
	            connexion = daoFactory.getConnection();
	            preparedStatement = connexion.prepareStatement("INSERT INTO questionnaire (title, length, date_creation) VALUES(?, ? ,?);");
	            preparedStatement.setString(1, questionnaire.getTitle());
	            preparedStatement.setInt(2, questionnaire.getLength());
	            preparedStatement.setString(3, questionnaire.getDate_creation());
	            preparedStatement.executeUpdate();
	            List<Question> questions = questionnaire.getQuestions();
	            for( Question question:questions) {
	            	preparedStatement = connexion.prepareStatement("INSERT INTO question (questionnaire_title,content) VALUES(?, ?);");
	            	preparedStatement.setString(1, questionnaire.getTitle());
		            preparedStatement.setString(2, question.getContent());
		            preparedStatement.executeUpdate();
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }

	    }

	    @Override
	    public List<Questionnaire> lister() {
	        List<Questionnaire> questionnaires = new ArrayList<Questionnaire>();
	        Connection connexion = null;
	        Statement statement = null;
	        ResultSet resultat = null;
	        try {
	            connexion = daoFactory.getConnection();
	            statement = connexion.createStatement();
	            resultat = statement.executeQuery("SELECT * FROM questionnaire;");

	            while (resultat.next()) {
	                String title = resultat.getString("title");
	                String date_creation = resultat.getString("date_creation");
	                int length = resultat.getInt("length");
	                Questionnaire questionnaire = new Questionnaire();
	                questionnaire.setTitle(title);
	                questionnaire.setDate_creation(date_creation);
	                questionnaire.setLength(length);
	                questionnaires.add(questionnaire);
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	        return questionnaires;
	    }

	    public Questionnaire find (String titre) {
	        Questionnaire questionnaire = new Questionnaire();
	        List<Question> questions = new ArrayList<Question>();
	        Question question = null;
	        Connection connexion = null;
	        Statement statement = null;
	        ResultSet resultat = null;
	        ResultSet resultat_question = null;

	        try {
	            connexion = daoFactory.getConnection();
	            statement = connexion.createStatement();
	            resultat = statement.executeQuery("SELECT * FROM questionnaire where title = '"+titre+"';");
	            statement = connexion.createStatement();
	            resultat_question = statement.executeQuery("SELECT content FROM question where questionnaire_title= '"+titre+"';");
	            while (resultat.next()) {
	            	
	            	
	                String title = resultat.getString("title");
	                String date_creation = resultat.getString("date_creation");
	                int length = resultat.getInt("length");
	                questionnaire.setTitle(title);
	                questionnaire.setDate_creation(date_creation);
	                questionnaire.setLength(length);
	                while(resultat_question.next()) {
	                	question = new Question();
	                	question.setContent(resultat_question.getString("content"));
	                	questions.add(question);
	                }
	            }
	            questionnaire.setQuestions(questions);
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	        return questionnaire;
	    }

	    public void delete( String del) {
	        Connection connexion = null;
	        PreparedStatement preparedStatement = null;

	        try {
	            connexion = daoFactory.getConnection();
	            preparedStatement = connexion.prepareStatement("delete from recommendation where id_answers in (select id_answers from answers where title_questionnaire = ? );");
	            preparedStatement.setString(1, del);
	            preparedStatement.executeUpdate();
	            preparedStatement = connexion.prepareStatement("delete from answer where id_question in (select id_question from question where questionnaire_title = ? );");
	            preparedStatement.setString(1, del);
	            preparedStatement.executeUpdate();
	            preparedStatement = connexion.prepareStatement("delete from answers where title_questionnaire = ? ;");
	            preparedStatement.setString(1, del);
	            preparedStatement.executeUpdate();
	            preparedStatement = connexion.prepareStatement("delete from question where  questionnaire_title = ? ;");
	            preparedStatement.setString(1, del);
	            preparedStatement.executeUpdate();
	            preparedStatement = connexion.prepareStatement("delete from questionnaire where  title = ? ;");
	            preparedStatement.setString(1, del);
	            preparedStatement.executeUpdate();
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }

	    }
	@Override
	public List<Questionnaire> getAllQuestionnaires() {
		Connection con= DatabaseConnection.connect(); 
		List <Questionnaire> questionnaires = new ArrayList<Questionnaire>();

		try {
	        Statement s = con.createStatement();

	        
	        // Add a new entry
	        String query = "SELECT * FROM questionnaire ;";
	        
	        // Execute the Query
	        ResultSet rs = s.executeQuery(query);
	        
	        while (rs.next())
	        {
	          Questionnaire q= new Questionnaire();
	          q.setTitle(rs.getString("title"));
	          q.setLength(rs.getInt("length"));
	          questionnaires.add(q);
	       
	        }

		} 
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return questionnaires;
}

	@Override
	public Questionnaire getQuestionnaire(String title) {
		Connection con= DatabaseConnection.connect(); 
		try {
			// Everything needed to connect to the DB
	
	        Statement s = con.createStatement();


	        
	        // Add a new entry
	        String query = "SELECT * FROM questionnaire WHERE title ='"+title+"' ;";
	        
	        // Execute the Query
	        ResultSet rs = s.executeQuery(query);
	        
	        while (rs.next())
	        {
	          Questionnaire q= new Questionnaire();
	          q.setTitle(rs.getString("title"));
	          q.setLength(rs.getInt("length"));
	        
	          return q ;
	        }

		} 
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<Questionnaire> getUnansweredQuestionnaires(int id_employe) {
		Connection con= DatabaseConnection.connect(); 
		List <Questionnaire> questionnaires = new ArrayList<Questionnaire>();

		try {
	        Statement s = con.createStatement();

	        
	        // Add a new entry
	        String query = "SELECT * FROM questionnaire where title not in (select title_questionnaire from answers where id_employe="+id_employe+") ;";
	        
	        // Execute the Query
	        ResultSet rs = s.executeQuery(query);
	        
	        while (rs.next())
	        {
	          Questionnaire q= new Questionnaire();
	          q.setTitle(rs.getString("title"));
	          q.setLength(rs.getInt("length"));
	          questionnaires.add(q);
	       
	        }

		} 
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return questionnaires;
	}


}



