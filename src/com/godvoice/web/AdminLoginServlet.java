package com.godvoice.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.godvoice.beans.Admin;
import com.godvoice.service.AdminService;
import com.godvoice.service.AdminServiceImp;

/**
 * Servlet implementation class AdminLoginServlet
 */

public class AdminLoginServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException  {
	     AdminService ads = new AdminServiceImp();
	     String name = request.getParameter("Admin_name");
	     String password = request.getParameter("Admin_password");	     
//	     ads.adminlogin(name,password);	     
		try {
			Admin admin = ads.adminlogin(name, password);;
			request.getSession().setAttribute("admin", admin);
			request.setAttribute("admin", admin);
//			String contextPath = request.getContextPath();
			request.getRequestDispatcher("/AdminManageSongServlet").forward(request, response);
		}catch (Exception e) {			
			request.setAttribute("exception", e);
			request.getRequestDispatcher("/AdminLogin.jsp").forward(request, response);
		}
	
	   }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
