package daoImpl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import beans.Answer;
import dao.AnswerDao;

public class AnswerDaoImpl implements AnswerDao{

	@Override
	public List<Answer> getAnswerByAnswers(int id_answers) {
		Connection con = null;
		List <Answer> answers = new ArrayList<Answer>();

		try {
			
			con = DatabaseConnection.connect();
	        Statement s = con.createStatement();
	        
	        // Add a new entry
	        String query = "SELECT * FROM answer where id_answers="+id_answers+";";
	        
	        // Execute the Query
	        ResultSet rs = s.executeQuery(query);
	        
	        while (rs.next())
	        {
	          Answer q= new Answer();
	          q.setId_answer(rs.getInt("id_answer"));
	          q.setId_answers(rs.getInt("id_answers"));
	          q.setId_question(rs.getInt("id_question"));
	          answers.add(q);
	       
	        }

		} 
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return answers;
}

	@Override
	public boolean addAnswer(int id_answers, int id_question, int value) {
		// TODO Auto-generated method stub
		Connection con = null;

		try {
			
			con = DatabaseConnection.connect();
	        Statement s = con.createStatement();
	        
	        // Add a new entry
	        String query = "insert into answer(id_answers, id_question, value) values ("+id_answers+", "+id_question+""
	        		+ ","+value+");";
	        
	        // Execute the Query
	         s.executeUpdate(query);
	         return true;
	        


		} 
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

}
