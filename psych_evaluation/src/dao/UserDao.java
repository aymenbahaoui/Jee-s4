package dao;
import beans.User;

public interface UserDao {
	 boolean addUser(String name, String phone, String login, String password, int user_id , String email);
	 User login(String login, String password);
	 boolean Verify(User user);
	 User getUserbyId(int id);
	
}
