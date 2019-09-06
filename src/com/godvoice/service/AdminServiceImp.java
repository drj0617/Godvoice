package com.godvoice.service;

import com.godvoice.beans.Admin;
import com.godvoice.dao.AdminDao;
import com.godvoice.dao.AdminDaoImp;

public class AdminServiceImp implements AdminService{

	@Override
	public Admin adminlogin(String name, String password) {
		AdminDao ad = new AdminDaoImp();
		Admin adm = ad.getAdminByadnameAndPwd(name, password);
		if(adm != null) {
			return adm;
		}else {
			throw new RuntimeException("管理员账号/密码错误");
		}
	
	}

}
