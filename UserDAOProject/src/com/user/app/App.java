package com.user.app;

import com.user.beans.User;
import com.user.dao.UserDAO;
import com.user.dao.UserJdbcImpl;

public class App 
{

	public static void main(String[] args) 
	{


		UserDAO db = new UserJdbcImpl();
		User user = db.SearchUser(5);
		System.out.println(user.getUserId());
		System.out.println(user.getFirstName());
		System.out.println(user.getLastName());		
		System.out.println("*******************");



		UserDAO db1 = new UserJdbcImpl();
		boolean result = db1.deleteUser(7, "roots");
		if(result == true)
		{
			System.out.println("Profile deleted");
		}
		else
		{
			System.out.println("profile not deleted");
		}
		System.out.println("******************"); 




		UserDAO db2 = new UserJdbcImpl();
		User user1 = new User();
		boolean result1 = db2.createUser(user1);
		if(result1 == true)
		{
			System.out.println("Profile created");
		}
		else
		{
			System.out.println("profile not created");
		}
		System.out.println("******************"); 





		UserDAO db3 = new UserJdbcImpl();
		boolean result2 = db3.updatePassword("def","roots");
		if(result2 == true)
		{
			System.out.println("Password updated");
		}
		else
		{
			System.out.println("Password update fail");
		}
		System.out.println("******************"); 


		UserDAO db4 = new UserJdbcImpl();
		db4.showAllUsers();
	}

}
