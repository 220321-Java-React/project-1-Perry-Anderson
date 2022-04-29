package com.revature.services;

import com.revature.daos.UserDAO;
import com.revature.models.User;
import com.revature.models.UserRole;

public class UserService {
	UserDAO uDAO = new UserDAO();
	
	public User login(String username, String password) {
		User userAttempt = uDAO.getUser(username, password);
		
		if (userAttempt != null) {
			if(userAttempt.getPassword().equals(password)) {
				return userAttempt;
			}else {
				return null;
			}
		}else {
			return null;
		}
	}
}


//if(username.equals("user") && password.equals("password")) {
//UserRole role = new UserRole("Admin");
//return new User();
//}else {