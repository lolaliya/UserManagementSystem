package com.dev.daodesign;

import java.util.ArrayList;

import com.dev.beans.User;

public interface UserDaoDesign
{
	public User SearchUserProfile(int userId);
	public boolean deleteUserProfile(int userId, String password);
	public boolean createUserProfile(User user);
	public boolean updateUserPassword( String oldPassword, String newPassword);
	public ArrayList<User> showAllUsers();
}