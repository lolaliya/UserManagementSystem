package com.dev.ums.repository;
import java.util.HashMap;

import com.dev.ums.beans.User;
public class UserRepository {
	public HashMap<Integer, User> db = new HashMap<>();

	public UserRepository(){
		User user1 = new User();
		user1.setUserId(1);
		user1.setFirstName("Adam");
		user1.setLastName("Smith");
		user1.setEmail("abcd@xyz.com");
		user1.setPassword("abcd");
		db.put(1, user1);

		User user2 = new User();
		user2.setUserId(2);
		user2.setFirstName("William");
		user2.setLastName("Wordsworth");
		user2.setEmail("efgh@xyz.com");
		user2.setPassword("efgh");
		db.put(2, user2);


		User user3 = new User();
		user3.setUserId(3);
		user3.setFirstName("Henry");
		user3.setLastName("Jones");
		user3.setEmail("ijkl@xyz.com");
		user3.setPassword("ijkl");
		db.put(3, user3);


		User user4 = new User();
		user4.setUserId(4);
		user4.setFirstName("Charlie");
		user4.setLastName("Chaplin");
		user4.setEmail("mnop@xyz.com");
		user4.setPassword("mnop");
		db.put(4, user4);



		User user5 = new User();
		user5.setUserId(5);
		user5.setFirstName("Albert");
		user5.setLastName("Einstin");
		user5.setEmail("qrst@xyz.com");
		user5.setPassword("qrst");
		db.put(5, user5);
	}
}