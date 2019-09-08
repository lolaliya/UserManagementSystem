package com.user.dao;

import java.util.ArrayList;
import com.user.beans.User;

public interface UserDAO 
{
	public User SearchUser(int userId);
	public boolean deleteUser(int userId, String password);
	public boolean createUser(User user);
	public boolean updatePassword( String oldPassword, String newPassword);
	public ArrayList<User> showAllUsers();
}
