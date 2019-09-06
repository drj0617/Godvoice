package com.godvoice.web;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.godvoice.beans.User;
import com.godvoice.service.UserService;
import com.godvoice.service.UserServiceImpl;

public class LoginServlet extends HttpServlet {
 
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(request.getSession().getAttribute("user") != null)
			return;
		String email=request.getParameter("email");
		String password=request.getParameter("password");
		UserService us=new UserServiceImpl();

		try {
			User user= us.login(email, password);
//			System.out.println(user);
			boolean checkOn = us.checkOn(email, password);
//			System.out.println(checkOn);
			if(checkOn) {
				request.getSession().setAttribute("user", user);
				
				request.setAttribute("user", user);
				request.getRequestDispatcher("/index.jsp").forward(request, response);
			}
			
		}catch (Exception e) {
			request.setAttribute("exception", e);
			request.getRequestDispatcher("/login2.jsp").forward(request, response);
//			System.out.println("ssss");
		}

	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}