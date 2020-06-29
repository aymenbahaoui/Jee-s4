package tests;
import daoImpl.UserDaoImpl;

import static org.junit.Assert.*;

import org.junit.Test;

import beans.User;
import dao.UserDao;

public class GetUserByIdTest {

	@Test
	public void testGetUserById() {
		
		User u= new User();
		UserDao I = new UserDaoImpl();
        
		u.setId_employe(123);
        u.setPassword("gaga");
        u.setName("kisuke");
        
        User u2 = I.getUserbyId(123);
        System.out.println(u2.getName());
        
        assertEquals(u.getName(),u2.getName());
	}

}
