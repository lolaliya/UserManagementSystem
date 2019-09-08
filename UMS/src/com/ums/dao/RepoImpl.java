
package com.ums.dao;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import com.ums.beans.User;
import com.ums.repo.UserRepository;

public class RepoImpl implements UserDAO {
	
	UserRepository repo = new UserRepository();
	private HashMap<Integer, User> db = repo.db;
	
	@Override
	public Boolean createProfile(User user) {
		user = db.put(user.getUsersId(), user);
		if(user != null){
			return true;
		}else{
			return false;
		}
	}
	

	@Override
	public User searchUser(Integer userId) {
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
	public Boolean deleteUser(Integer userId, String password) {
		boolean state = false;
		User user = searchUser(userId);
		if(user != null){
			if(user.getPassword().equals(password)){
				db.remove(userId);
				state = true;
			}
		}else{
			state = false;
		}
		
		return state;
	}
	
	

	@Override
	public Boolean updatePassword(Integer userId, String oldPassword, String newPassword) {
		boolean state = false;
		User user = searchUser(userId);
		if(user != null){
			if(user.getPassword().equals(oldPassword)){
				user.setPassword(newPassword);
				db.put(user.getUsersId(), user);
				state =  true;
			}
		}else{
			state =  false;
		}
		return state;
	}
}
