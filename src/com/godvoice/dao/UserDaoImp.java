package com.godvoice.dao;

import java.sql.SQLException;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import com.godvoice.beans.User;
import com.godvoice.utils.DataSourceUtils;

public class UserDaoImp implements UserDao{
	private QueryRunner qr = new QueryRunner();
	@Override
	public User getUserByUname_PWD(String email, String password) {
		String sql = "SELECT * FROM user WHERE email=? AND password=?";
		User user = null;
		try {
			user = qr.query(DataSourceUtils.getConnection(),sql, new BeanHandler<User>(User.class),email,password);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return user;
	}

	@Override
	public void addUser(User usr) {
		String sql = "INSERT INTO user values(null,?,?,?,?)";
		try {
			qr.update(DataSourceUtils.getConnection(),sql,usr.getUname(),usr.getMobilenum(),usr.getEmail(),usr.getPassword());
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public User getUserByUname(String usrname) {
		String sql = "SELECT * FROM user WHERE uname=?";
		User user = null;
		try {
			user = qr.query(DataSourceUtils.getConnection(),sql, new BeanHandler<User>(User.class),usrname);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return user;
	}

	@Override
	public boolean checkOn(String eamil, String password) {
		String sql = "select email,password from user where email=? and password=?";
		try {
			User user = qr.query(DataSourceUtils.getConnection(),sql,
					new BeanHandler<User>(User.class),
					eamil,password);
			if( (eamil.equals(user.getEmail())) && (password.equals(user.getPassword()))) {
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
	
}
