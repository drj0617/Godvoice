package com.godvoice.web;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;

import com.godvoice.beans.User;
import com.godvoice.service.UserService;
import com.godvoice.service.UserServiceImpl;

public class RegisterServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		User user=new User();
		UserService us=new UserServiceImpl();
			//前端获得的数据封装成map对象
		user.setUname(request.getParameter("uname"));
		user.setEmail(request.getParameter("email"));
		user.setMobilenum(request.getParameter("mobilenum"));
		user.setPassword(request.getParameter("password"));
		System.out.println("注册了一个用户："+user);
		//注册的数据存到数据库中
	    us.saveUser(user);
	    response.sendRedirect("/Godvoice/index.jsp");
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}