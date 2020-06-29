package daoImpl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import beans.Question;
import dao.QuestionDao;

public class QuestionDaoImpl implements QuestionDao {

	@Override
	public boolean addQuestion( String questionnaire_title, String content) {
		try {
			// Everything needed to connect to the DB
			Connection con= DatabaseConnection.connect(); 
	        Statement s = con.createStatement();
	        
	        // Add a new entry
	        String query = "INSERT INTO question ( questionnaire_title, content)"
	        		+ " VALUES ('"+questionnaire_title+"','"+content+"');";
	        
	        // Execute the Query
	       s.executeUpdate(query);


		} 
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return true;
	}
	

	@Override
	public List<Question> getQuestionsByQuestionnaire(String questionnaire_title) {
			Connection con= DatabaseConnection.connect(); 
			List <Question> questions = new ArrayList<Question>();

			try {
		        Statement s = con.createStatement();

		        
		        // Add a new entry
		        String query = "SELECT * FROM question where questionnaire_title ='"+questionnaire_title+"' ;";
		        
		        // Execute the Query
		        ResultSet rs = s.executeQuery(query);
		        
		        while (rs.next())
		        {
		          Question q= new Question();
		          q.setId_question(rs.getInt("id_question"));
		          q.setQuestionnaire_title(rs.getString("questionnaire_title"));
		          q.setContent(rs.getString("content"));
		          questions.add(q);
		       
		        }

			} 
			catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return questions;
	}
	}


