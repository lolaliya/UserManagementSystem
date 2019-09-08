package com.ums.app;

import com.ums.beans.User;
import com.ums.services.UserServices;
import com.ums.services.UserServicesImpl;
public class App {
	public static void main(String[] args) {
		UserServices services = new UserServicesImpl();
		User user=services.searchUser(1);
		System.out.println(user);
		System.out.println(services.createProfile(user));
		System.out.println("deleted: "+services.deleteUser(1, "root"));
		System.out.println("password");		
		System.out.println(services.searchUser(1));
		System.out.println(services.updatePassword(2, "root", "roots"));
		System.out.println(services.searchUser(2));
	}


}
