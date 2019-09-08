package com.caps.services;

import com.caps.beans.User;

public interface UserService {
	 public Boolean createProfile(User user);
		public User searchUser(Integer userId);
		public Boolean updatePassword(Integer userId, String oldPassword, String newPassword);
		public Boolean deleteUser(Integer userId, String password);
	    public User login(Integer userId,String password);
		
}
