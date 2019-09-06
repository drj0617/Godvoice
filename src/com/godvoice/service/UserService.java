package com.godvoice.service;

import com.godvoice.beans.User;

public interface UserService {
	User login(String email, String password);
	void saveUser(User user);
	
	boolean checkOn(String email,String password);
	
}
