package com.dev.ums.application;

import com.dev.ums.beans.User;
import com.dev.ums.service.UserService;
import com.dev.ums.service.ServiceImplementation;

public class Application 
{
	public static void main(String[] args) 
	{
		
		
		UserService services = new ServiceImplementation();
		User user=services.searchUserProfile(5);
		
		System.out.println("reading data of the user.....");
		System.out.println(services.searchUserProfile(1));		// read data from user profile
		System.out.println();
		
		System.out.println("creating the user profile.....");
		System.out.println("Profile creation: "+services.createUserProfile(user));		//create user profile
		System.out.println();
		
		System.out.println("Deleting the user profile.....");
		System.out.println("deleting the profile: "+services.deleteUserProfile(1, "abcd"));		//delete user profile	
		System.out.println("Search for deleted user profile: "+services.searchUserProfile(1));
		System.out.println();
		
		System.out.println("Updating the password of the user.....");
		System.out.println("Update password: "+services.updateUserPassword(2, "efgh", "roots"));		//update user data in the profile
		System.out.println();
		System.out.println("Displaying the updated user profile.....");
		System.out.println(services.searchUserProfile(2));
	}
}