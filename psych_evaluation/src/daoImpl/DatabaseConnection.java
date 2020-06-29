package daoImpl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;



public class DatabaseConnection {
	static private String url="jdbc:mysql://localhost:3306/jee?useTimezone=true&serverTimezone=UTC ";// a changer
	static private String user = "root";
	static private String pw = ""; // a changer
	
	public static Connection connect()
	{
	
	Connection con = null;

	try {
		// Everything needed to connect to the DB
		Class.forName("com.mysql.cj.jdbc.Driver");

        
        // Used to issue queries to the DB
        con = DriverManager.getConnection(url, user, pw);
        

        
        return con;
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
