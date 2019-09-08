package com.dev.application;

import com.dev.beans.User;
import com.dev.daodesign.UserDaoDesign;
import com.dev.daodesign.JDBCImplementation;

public class Application {
	public static void main(String[] args) {

		UserDaoDesign db = new JDBCImplementation();
		User user = db.SearchUserProfile(5);
		System.out.println("User Id: " + user.getUserId());
		System.out.println("First Name: " + user.getFirstName());
		System.out.println("Last Name: " + user.getLastName());	
		System.out.println("*******************");



		UserDaoDesign db1 = new JDBCImplementation();
		boolean result = db1.deleteUserProfile(7, "root");
		if(result == true)
		{
			System.out.println("Profile deleted");
		}
		else
		{
			System.out.println("profile not deleted");
		}
		System.out.println("******************"); 




		UserDaoDesign db2 = new JDBCImplementation();
		User user1 = new User();
		boolean result1 = db2.createUserProfile(user1);
		if(result1 == true)
		{
			System.out.println("Profile created");
		}
		else
		{
			System.out.println("profile not created");
		}
		System.out.println("******************"); 





		UserDaoDesign db3 = new JDBCImplementation();
		boolean result2 = db3.updateUserPassword("root","roots");
		if(result2 == true)
		{
			System.out.println("Password updated");
		}
		else
		{
			System.out.println("Password update fail");
		}
		System.out.println("******************"); 


		UserDaoDesign db4 = new JDBCImplementation();
		db4.showAllUsers();
	}
}