package daoImpl;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import beans.Answer;
import beans.Answers;
import dao.AnswersDao;
import dao.DaoFactory;

public class AnswersDaoImpl implements AnswersDao {
	private DaoFactory daoFactory;
	 public AnswersDaoImpl() {
	        super();
	   }
	  public AnswersDaoImpl(DaoFactory daoFactory) {
	        this.daoFactory = daoFactory;
	   }
	   
	   public void ajouter( Answers answers) {
	        Connection connexion = null;
	        PreparedStatement preparedStatement = null;

	        try {
	            connexion = daoFactory.getConnection();
	            preparedStatement = connexion.prepareStatement("INSERT INTO answers (id_answers,title_questionnaire,date,id_employe) VALUES(?, ? ,? ,?);");
	            preparedStatement.setInt(1, answers.getId_answers());
	            preparedStatement.setString(2, answers.getTitle_questionnaire());
	            preparedStatement.setString(3, answers.getDate());
	            preparedStatement.setInt(4, answers.getId_employe());
	            preparedStatement.executeUpdate();
	            List<Answer> list_answers = answers.getList_answers();
	            for( Answer answer:list_answers) {
	            	preparedStatement = connexion.prepareStatement("INSERT INTO answer (id_answers,id_question,value) VALUES(?, ? , ?);");
	            	preparedStatement.setInt(1, answer.getId_answers());
		            preparedStatement.setInt(2,answer.getId_question());
		            preparedStatement.setBoolean(3, answer.isValue());
		            preparedStatement.executeUpdate();
	            }
	            
	            
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }

	    }
	   
	   public List<Answers> lister() {
	        List<Answers> list_answers = new ArrayList<Answers>();
	        Connection connexion = null;
	        Statement statement = null;
	        ResultSet resultat = null;
	        try {
	            connexion = daoFactory.getConnection();
	            statement = connexion.createStatement();
	            resultat = statement.executeQuery("SELECT * FROM answers;");

	            while (resultat.next()) {
	                int id_answers = resultat.getInt("id_answers");
	                String date = resultat.getString("date");
	                String title_questionnaire  = resultat.getString("title_questionnaire");
	                int id_employe  = resultat.getInt("id_employe");
	                Answers answers = new Answers();
	                answers.setId_answers(id_answers);
	                answers.setDate(date);
	                answers.setTitle_questionnaire (title_questionnaire);
	                answers.setId_employe(id_employe);
	               list_answers.add(answers);
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	        return list_answers;
	    }

	    public Answers find (int id_answers) {
	        Answers answers = new Answers();
	        List<Answer> list_answer = new ArrayList<Answer>();
	        Answer answer = null;
	        Connection connexion = null;
	        Statement statement = null;
	        ResultSet resultat = null;
	        ResultSet resultat_answer = null;

	        try {
	        	System.out.println("jygjh");
	            connexion = daoFactory.getConnection();
	            System.out.println("bababab");
	            statement = connexion.createStatement();
	            resultat = statement.executeQuery("SELECT * FROM answers where id_answers = '"+id_answers+"';");
	            statement = connexion.createStatement();
	            resultat_answer = statement.executeQuery("select * from answer,question where id_answers = '"+id_answers+"' and answer.id_question = question.id_question ;");
	            while (resultat.next()) {
		            String date = resultat.getString("date");
		            String title_questionnaire  = resultat.getString("title_questionnaire");
		            int id_employe  = resultat.getInt("id_employe");
		            answers.setId_answers(id_answers);
	                answers.setDate(date);
	                answers.setTitle_questionnaire (title_questionnaire);
	                answers.setId_employe(id_employe);
	                answers.setId_employe(id_employe);
	                while(resultat_answer.next()) {
	                	answer = new Answer();
	                	answer.setId_answers(id_answers);
	                	answer.setId_question(resultat_answer.getInt("id_question"));
	                	answer.setQuestion_content(resultat_answer.getString("content"));
	                	answer.setValue(resultat_answer.getBoolean("value"));
	                	list_answer.add(answer);
	                }
	            }
	            answers.setList_answers(list_answer);
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	        return answers;
	    }
	    
	    public List<Answers> lister_nonTraite() {
	        List<Answers> list_answers = new ArrayList<Answers>();
	        Connection connexion = null;
	        Statement statement = null;
	        ResultSet resultat = null;
	        try {
	            connexion = daoFactory.getConnection();
	            statement = connexion.createStatement();
	            resultat = statement.executeQuery("SELECT * FROM answers where id_answers not in (select id_answers from recommendation) ;");

	            while (resultat.next()) {
	                int id_answers = resultat.getInt("id_answers");
	                String date = resultat.getString("date");
	                String title_questionnaire  = resultat.getString("title_questionnaire");
	                int id_employe  = resultat.getInt("id_employe");
	                Answers answers = new Answers();
	                answers.setId_answers(id_answers);
	                answers.setDate(date);
	                answers.setTitle_questionnaire (title_questionnaire);
	                answers.setId_employe(id_employe);
	               list_answers.add(answers);
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	        return list_answers;
	    }

	@Override
	public long addAnswers(String title_questionnaire, Date date, int id_employe) {
	
		try {
			// Everything needed to connect to the DB
			Connection con= DatabaseConnection.connect(); 
			String query = "INSERT INTO Answers ( title_questionnaire, date, id_employe)"
	        		+ " VALUES ('"+title_questionnaire+"','"+date+"',"+id_employe+");";
	        PreparedStatement s = con.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
	        
	   
	        
	        // Execute the Query
	       s.executeUpdate();
	       try (ResultSet generatedKeys = s.getGeneratedKeys()) {
	            if (generatedKeys.next()) {
	              return(generatedKeys.getLong(1));
	            }
	            else {
	                throw new SQLException("Creating user failed, no ID obtained.");
	            }
	       }

		} 
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0l;
	}
	
	
	

	@Override
	public List<Answers> getAllAnswers() {
		Connection con= DatabaseConnection.connect(); 
		List <Answers> answers = new ArrayList<Answers>();

		try {

	        
	        // Used to issue queries to the DB
	        
	        // Sends queries to the DB for results
	        Statement s = con.createStatement();
	        
	        // Add a new entry
	        String query = "SELECT * FROM Answers ;";
	        
	        // Execute the Query
	        ResultSet rs = s.executeQuery(query);
	        
	        while (rs.next())
	        {
	          Answers a= new Answers();
	          a.setId_answers(rs.getInt("id_answers"));
	          a.setTitle_questionnaire(rs.getString("title_questionnaire"));
	          a.setDate(rs.getString("date"));
	          a.setId_employe(rs.getInt("id_employe"));
	          answers.add(a);
	       
	        }

		} 
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return answers;
}

	@Override
	public List<Answers> getAnswersbyId(int id_employe) {
		Connection con= DatabaseConnection.connect(); 
		List <Answers> answers = new ArrayList<Answers>();

		try {
	        
	        // Sends queries to the DB for results
	        Statement s = con.createStatement();
	        
	        // Add a new entry
	        String query = " select id_answers, title_questionnaire, max(date), id_employe" + 
	        		"  from answers" + 
	        		"   where id_employe = "+id_employe+"" + 
	        		"   group by title_questionnaire, id_employe;";
	        
	        // Execute the Query
	        ResultSet rs = s.executeQuery(query);
	        
	        while (rs.next())
	        {
	          Answers a= new Answers();
	          a.setId_answers(rs.getInt("id_answers"));
	          a.setTitle_questionnaire(rs.getString("title_questionnaire"));
	          a.setDate(rs.getString("max(date)"));
	          a.setId_employe(rs.getInt("id_employe"));
	          answers.add(a);
	       
	        }

		} 
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return answers;
	}

	@Override
	public List<Integer> getAnswersValue(int id_answers) {
		List<Integer> list = new ArrayList<Integer>();
		;
		List <Answer> l_a;
		AnswerDaoImpl a = new AnswerDaoImpl();
		l_a=a.getAnswerByAnswers(id_answers);
		for (Answer ans : l_a) {

			int val = ans.isValue()? 1 : 0;

			list.add(val);
		}
		return list;
	}
	@Override
	public int FindSameAnswer(int id_answers) {
		List <Integer> thisAnswerValue= getAnswersValue(id_answers);
		List <Answers> list = getAllAnswers();
		for(Answers ans :list) {
			List <Integer> AnswerValue= getAnswersValue(ans.getId_answers());
			if (thisAnswerValue.equals(AnswerValue)) {
				return ans.getId_answers();
			}

		}
		
		
		
		return 0;
	}




	@Override
	public Answers getAnswer(String title_questionnaire, Date date, int id_employe) {
		Connection con= DatabaseConnection.connect(); 

		try {
	        
	        // Sends queries to the DB for results
	        Statement s = con.createStatement();
	        
	        // Add a new entry
	        String query = "SELECT * FROM Answers where id_employe"+id_employe+" and date = '"+date+"' and"
	        		+ "title='"+title_questionnaire+"' ;";
	        
	        // Execute the Query
	        ResultSet rs = s.executeQuery(query);
	          Answers a= new Answers();

	        while (rs.next())
	        {
	          
	          a.setId_answers(rs.getInt("id_answers"));
	          a.setTitle_questionnaire(rs.getString("title_questionnaire"));
	          a.setDate(rs.getString("date"));
	          a.setId_employe(rs.getInt("id_employe"));
	          
	        }
	        return a;
	        

		} 
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}


}
