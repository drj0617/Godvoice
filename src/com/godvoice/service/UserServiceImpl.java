package com.godvoice.service;

import com.godvoice.beans.User;
import com.godvoice.dao.UserDao;
import com.godvoice.dao.UserDaoImp;

public class UserServiceImpl implements UserService{

	UserDao ud=new UserDaoImp();
	User user=new User();
	@Override
	public User login(String email ,String password) {
		User user = ud.getUserByUname_PWD(email,password);
		if(user != null) {
			return user;
		}
		else {
			
			throw new RuntimeException("登陆失败");
		}

	}
	@Override
	public void saveUser(User user) {
		ud.addUser(user);		
	}
	@Override
	public boolean checkOn(String email, String password) {

		boolean checkOn = ud.checkOn(email, password);
		if(checkOn) {
			return true;
		}
		return false;
	}

}
