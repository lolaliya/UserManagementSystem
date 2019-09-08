package com.dev.ums.daodesign;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import com.dev.ums.beans.User;
import com.dev.ums.repository.UserRepository;

public class RepositoryImplementation implements UserDAODesign {
	UserRepository repo = new UserRepository();
	private HashMap<Integer, User> db = repo.db;
	
	@Override
	public Boolean createUserProfile(User user) {
		user = db.put(user.getUserId(), user);
		if(user != null){
			return true;
		}else{
			return false;
		}
	}

	@Override
	public User searchUserProfile(Integer userId) {
		User user = null;
		Iterator it = db.entrySet().iterator();
		while (it.hasNext()) {
	        Map.Entry pair = (Map.Entry)it.next();
	        if(pair.getKey().equals(userId)){
	        	return (User)pair.getValue();
	        }
	    }
		return user;
	}

	

	@Override
	public Boolean deleteUserProfile(Integer userId, String password) {
		User user = searchUserProfile(userId);
		if(user != null){
			if(user.getPassword().equals(password)){
				db.remove(userId);
				return true;
			}
		}else{
			return false;
		}
		return false;
		
	}

	@Override
	public Boolean updateUserPassword(Integer userId, String oldPassword, String newPassword) {
		User user = searchUserProfile(userId);
		if(user != null){
			if(user.getPassword().equals(oldPassword)){
				user.setPassword(newPassword);
				db.put(user.getUserId(), user);
				return true;
			}
		}else{
			return false;
		}
		return false;
	}

}