package daoImpl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import beans.User;
import dao.UserDao;


public class UserDaoImpl implements UserDao {

	@Override
	public boolean addUser(String name, String phone, String login, String password, int user_id, String email) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public User login(String login, String password) {
		
		Connection con = null;
		try {
			// Everything needed to connect to the DB
			Class.forName("com.mysql.cj.jdbc.Driver");
			String url = "jdbc:mysql://localhost:3306/jee?useTimezone=true&serverTimezone=UTC ";
			String user= "root";
			String pw = "";
	        
	        // Used to issue queries to the DB
	        con = DriverManager.getConnection(url, user, pw);
	        
	        // Sends queries to the DB for results
	        Statement s = con.createStatement();
	        
	        // Add a new entry
	        String query = "SELECT * FROM user WHERE login ='"+login+"'AND password='"+password+"' ;";
	        
	        // Execute the Query
	        ResultSet rs = s.executeQuery(query);
	        
	        if(rs.next()== false) {
	            System.out.println("incorrect id or password");
	            return null;
	        }
	        else {
		          User u= new User();
		          u.setId_employe(rs.getInt("id_employe"));
		          u.setPassword(rs.getString("password"));
		          u.setName(rs.getString("name"));
		          System.out.println("user is "+u.getId_employe());
		          
		          return u;

		}
		}
		catch (ClassNotFoundException e) {
			e.printStackTrace();
		} 
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
		
	}

	@Override
	public boolean Verify(User user) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public User getUserbyId(int id) {
		Connection con = null;
		try {
			// Everything needed to connect to the DB
			Class.forName("com.mysql.cj.jdbc.Driver");
			String url = "jdbc:mysql://localhost:3306/jee?useTimezone=true&serverTimezone=UTC ";
			String user= "root";
			String pw = "";
	        
	        // Used to issue queries to the DB
	        con = DriverManager.getConnection(url, user, pw);
	        
	        // Sends queries to the DB for results
	        Statement s = con.createStatement();
	        
	        // Add a new entry
	        String query = "SELECT * FROM user WHERE id_employe ="+id+" ;";
	        
	        // Execute the Query
	        ResultSet rs = s.executeQuery(query);
	        
	        if(rs.next()== false) {
	            System.out.println("incorrect id or password");
	            return null;
	        }
	        else {
		          User u= new User();
		          u.setId_employe(rs.getInt("id_employe"));
		          u.setPassword(rs.getString("password"));
		          u.setName(rs.getString("name"));
		          System.out.println("user is "+u.getId_employe());
		          return u;

		}
		}
		catch (ClassNotFoundException e) {
			e.printStackTrace();
		} 
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
		
		
	}

}
