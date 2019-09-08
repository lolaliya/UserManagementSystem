package com.dev.ums.service;
import com.dev.ums.beans.User;
import com.dev.ums.daodesign.RepositoryImplementation;
import com.dev.ums.daodesign.UserDAODesign;
public class ServiceImplementation implements UserService {
private UserDAODesign db = new RepositoryImplementation();
	
	@Override
	public Boolean createUserProfile(User user) {
		return db.createUserProfile(user);
	}

	@Override
	public User searchUserProfile(Integer userId) {
		return db.searchUserProfile(userId);
	}

	@Override
	public Boolean updateUserPassword(Integer userId, String oldPassword, String newPassword) {
		return db.updateUserPassword(userId, oldPassword, newPassword);
	}

	@Override
	public Boolean deleteUserProfile(Integer userId, String password) {
		return db.deleteUserProfile(userId, password);
	}

}