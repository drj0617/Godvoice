package com.godvoice.dao;

import java.sql.SQLException;

import javax.sql.DataSource;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import com.godvoice.beans.Admin;
import com.godvoice.utils.DataSourceUtils;

public class AdminDaoImp implements AdminDao{
   QueryRunner qu = new QueryRunner(); 
	@Override
	public Admin getAdminByadnameAndPwd(String name, String password) {
		String sql = "select * from admin where adname = ? and adpassword = ?";
		try {
			Admin ad = qu.query(DataSourceUtils.getConnection(),sql, new BeanHandler<Admin>(Admin.class),name,password);
			return ad;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	

}
