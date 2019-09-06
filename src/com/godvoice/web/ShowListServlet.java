package com.godvoice.web;

import java.io.IOException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.godvoice.beans.Singer;
import com.godvoice.beans.Song;
import com.godvoice.beans.User;
import com.godvoice.service.CollectService;
import com.godvoice.service.CollectServiceImp;

/**
 * Servlet implementation class ShowListServlet
 */
@WebServlet("/ShowListServlet")
public class ShowListServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String method = request.getParameter("do");
		if("showMyCollection".equals(method)) {
			showMyCollection(request,response);
		}
			
	}

	public void showMyCollection(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String usid = request.getParameter("usid");
		if(usid == null || usid.equals("")) {
			response.sendRedirect("/Godvoice/login2.jsp");
			return;
		}
		User user = new User();
		user.setUsid(Integer.parseInt(usid));
		CollectService cs = new CollectServiceImp();
		Map<Song, Singer> map = cs.getCollectionMapByUser(user);
		request.setAttribute("sonsigmap", map);
		request.getRequestDispatcher("/playlist.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
	

}
