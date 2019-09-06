package com.godvoice.web;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.godvoice.beans.Singer;
import com.godvoice.beans.Style;
import com.godvoice.service.SingerService;
import com.godvoice.service.SingerServiceImpl;
import com.google.gson.Gson;

/**
 * Servlet implementation class StyleServlet
 */
@WebServlet("/StyleServlet")
public class StyleServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int styleid = Integer.valueOf(request.getParameter("styleid"));
		Style st = new Style();
		st.setStyleid(styleid);
		SingerService ss = new SingerServiceImpl();
		List<Singer> singers = ss.getSingerByStyle(st);
		String singersJson = new Gson().toJson(singers);
		response.setCharacterEncoding("UTF-8");
		response.getWriter().append(singersJson);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
