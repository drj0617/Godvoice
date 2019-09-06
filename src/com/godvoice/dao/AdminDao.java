package com.godvoice.dao;

import com.godvoice.beans.Admin;

public interface AdminDao {
	Admin getAdminByadnameAndPwd(String name, String password);

}
