package com.godvoice.dao;

import java.util.List;

import com.godvoice.beans.User;

public interface UserDao {
	public User getUserByUname_PWD(String username,String password); 
	
	public void addUser(User usr);
	
	public User getUserByUname(String usrname);
	
	boolean checkOn(String email,String password);
}
