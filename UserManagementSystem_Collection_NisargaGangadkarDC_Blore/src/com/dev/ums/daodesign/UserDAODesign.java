package com.dev.ums.daodesign;
import com.dev.ums.beans.User;
public interface UserDAODesign {
	public Boolean createUserProfile(User user);
	public User searchUserProfile(Integer userId);
	public Boolean updateUserPassword(Integer userId, String oldPassword, String newPassword);
	public Boolean deleteUserProfile(Integer userId, String password);
}