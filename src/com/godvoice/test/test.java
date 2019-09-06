package com.godvoice.test;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.godvoice.beans.User;
import com.godvoice.dao.UserDao;
import com.godvoice.dao.UserDaoImp;

public class test {
		@Test
		public void testLogin() {
			UserDao ud = new UserDaoImp();
			User userByUname_PWD = ud.getUserByUname_PWD("123", "123");
		}
		
		@Test
		public void testRegister() {
			UserDao ud = new UserDaoImp();
			User u = new User();
			u.setUname("test");
			u.setEmail("test@163.com");
			u.setPassword("123");
			u.setMobilenum("11111");
			ud.addUser(u);
			a[] data = new a[10];
			int i = 0;
			String s = "<a  href='${pageContext.request.contextPath }/SingerServlet?singerid="+data[i].sigid+"&singername="+data[i].signame+"'><img src='"+data[i].picURL+"' style='width: 217px; height: 242px'></a>" + 
					"<a class='art' href='${pageContext.request.contextPath }/SingerServlet?singerid="+data[i].sigid+"&singername="+data[i].signame+"'>${singer.signame }</a>";
		}
		
		@Test
		public void testGetUserByuname() {
			UserDao ud = new UserDaoImp();
			User userByUname = ud.getUserByUname("Jack");
			System.out.println(userByUname);
		}
	
}
class a{
	String sigid;
	String signame;
	String picURL;
}
	
