
package com.ums.repo;

import java.util.HashMap;
import com.ums.beans.User;

public class UserRepository {
	public static HashMap<Integer, User> db = new HashMap<>();
	
	public UserRepository(){
		User user1 = new User();
		user1.setFirstName("Aatish");
		user1.setLastName("Azad");
		user1.setUsersId(1);
		user1.setPassword("root");
		db.put(1, user1);
		
		User user2 = new User();
		user2.setFirstName("Afreen");
		user2.setLastName("Sulthana");
		user2.setUsersId(2);
		user2.setPassword("root");
		db.put(2, user2);
		
		
		User user3 = new User();
		user3.setFirstName("Limcia");
		user3.setLastName("TJ");
		user3.setUsersId(3);
		user3.setPassword("root");
		db.put(3, user3);
	}
}